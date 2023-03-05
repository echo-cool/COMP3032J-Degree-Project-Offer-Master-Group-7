package com.group7.controller.user;


import com.group7.controller.auth.payload.LoginRequest;
import com.group7.controller.user.payload.ChangePasswordRequest;
import com.group7.db.jpa.User;
import com.group7.db.jpa.UserRepository;
import com.group7.utils.common.JwtUtils;
import com.group7.service.UserService;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder encoder;

    @Resource
    JwtUtils jwtUtils;

    // The allowed picture type for uploading
    private static final String[] PIC_TYPES = new String[]{"bmp", "jpg", "jpeg", "png", "gif", "svg"};

    @RequestMapping("/getUser")
    public R getUser(HttpServletRequest request) {
        if (Objects.equals(request.getMethod(), "GET")) {
            String token = request.getHeader("Authorization");

            String username = jwtUtils.getUserNameFromJwtToken(token.split(" ")[1]);

//            String id = request.getAttribute("id").toString();
            User user = userRepository.findByUsername(username).orElse(null);

            if (user != null) {
                return R.ok().data("data", user);
            } else {
                return R.error();
            }
        } else {
            return R.error().message("error");
        }
    }

    @PostMapping("/uploadAvatar")
    public ResponseEntity<?> uploadAvatar(MultipartFile file, HttpServletRequest request){
        // check empty file
        if (file.isEmpty()){
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message("Upload failed - empty picture"));
        }

        // check file type
        String ext = file.getOriginalFilename().split("\\.")[1];
        boolean isValidType = false;
        for (String type : PIC_TYPES){
            if (type.equals(ext)){
                isValidType = true;
                break;
            }
        }
        if(!isValidType){
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message("Upload failed - the picture type should be the following: " +
                            "\"bmp\", \"jpg\", \"jpeg\", \"png\", \"gif\", \"svg\""));
        }

        // get user id from the token in the header of http request
        // find user from the token in request header
        User user = jwtUtils.getUserFromRequestByToken(request);
        if (user == null){
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message("Upload failed - You should login first."));
        }

        // store the file locally
        String newFileName = userService.uploadAvatar(file);
        if (newFileName == null){
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message("Upload failed - Try it again latter."));
        }

        // update the user avatar in db
        user.setAvatar(newFileName);
        userRepository.save(user);

        return ResponseEntity.ok(R.ok().data("avatar", newFileName).data("user", user));
    }

    @PostMapping("/changePassword")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest, BindingResult bindingResult, HttpServletRequest request){

        // check login
        User user = jwtUtils.getUserFromRequestByToken(request);
        if (user == null){
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message("Failed: You should login first."));
        }

        // check the auto validation defined in SignupRequest
        if(bindingResult.hasErrors()){
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message(bindingResult.getAllErrors().get(0).getDefaultMessage()));
        }

        // check the email
        if (!changePasswordRequest.getEmail().equals(user.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message("Failed: Email does not match your account!"));
        }

        // check old password
        if (!encoder.matches(changePasswordRequest.getOldPassword(), user.getPassword())){
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message("Failed: You have to enter the correct old password!"));
        }

        // check two new passwords
        if (!changePasswordRequest.getNewPassword().equals(changePasswordRequest.getReNewPassword())){
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message("Failed: Two new passwords do not match!"));
        }

        // update the password for user
        user.setPassword(encoder.encode(changePasswordRequest.getNewPassword()));
        userRepository.save(user);

        return ResponseEntity.ok(R.ok().data("user", user));

    }

}
