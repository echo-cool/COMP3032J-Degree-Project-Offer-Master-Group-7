package com.group7.controller.user;


import com.group7.controller.auth.payload.LoginRequest;
import com.group7.controller.user.payload.ChangePasswordRequest;
import com.group7.controller.user.payload.EditBackgroundRequest;
import com.group7.controller.user.payload.EditPersonalInfoRequest;
import com.group7.db.jpa.*;
import com.group7.db.jpa.utils.ERole;
import com.group7.db.jpa.utils.SpecificationsBuilder;
import com.group7.entitiy.SchoolQueryVo;
import com.group7.entitiy.UserQueryVo;
import com.group7.entitiy.UserUpdateVo;
import com.group7.utils.common.JwtUtils;
import com.group7.service.UserService;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserRepository userRepository;

    @Resource
    private ProfileRepository profileRepository;

    @Resource
    RoleRepository roleRepository;

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

//            String username = jwtUtils.getUserNameFromJwtToken(token.split(" ")[1]);
//            User user = userRepository.findByUsername(username).orElse(null);

            long userId = jwtUtils.getUserIdFromJwtToken(token.split(" ")[1]);
            User user = userRepository.findById(userId).orElse(null);

            if (user != null) {
                return R.ok().data("data", user);
            } else {
                return R.error();
            }
        } else {
            return R.error().message("error");
        }
    }

    @GetMapping("/getSelectedPrograms")
    public ResponseEntity<?> getSelectedPrograms(HttpServletRequest request){

        User user = jwtUtils.getUserFromRequestByToken(request);
        if (user == null){
            // user dose not login
            return ResponseEntity.ok(R.ok().data("isLogin", false));
        }

        // get a list of selected programs of this user
        Set<Application> applications = user.getApplications();
        Set<Program> selectedPrograms = new HashSet<>();
        for (Application ap : applications){
            selectedPrograms.add(ap.getProgram());
        }

        return ResponseEntity.ok(R.ok().data("isLogin", true).data("selectedPrograms", selectedPrograms));
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

        // the avatar url using resources/static as root
        String preURL = "upload/avatar/";

        // store the file locally
        String newFileName = userService.uploadAvatar(file, preURL);
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

        // check the auto validation
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

    @PostMapping("/editPersonalInfo")
    public ResponseEntity<?> editPersonalInfo(@Valid @RequestBody EditPersonalInfoRequest editPersonalInfoRequest, BindingResult bindingResult, HttpServletRequest request){

        // get the current user
        User user = jwtUtils.getUserFromRequestByToken(request);

        // check the auto validation
        if(bindingResult.hasErrors()){
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message(bindingResult.getAllErrors().get(0).getDefaultMessage()));
        }

        // get info from request
        String username = editPersonalInfoRequest.getUsername();
        String email = editPersonalInfoRequest.getEmail();
        String bio = editPersonalInfoRequest.getBio();

        // check the username
        // if username changed
        if (!username.equals(user.getUsername())){
            // if taken by another user
            if (userRepository.existsByUsername(username)){
                return ResponseEntity
                        .badRequest()
                        .body(R.error().message("Failed: This username has already been taken!"));
            }

            // update username
            user.setUsername(username);
        }

        // check the email
        if (!email.equals(user.getEmail())){
            // if taken by another user
            if (userRepository.existsByEmail(email)){
                return ResponseEntity
                        .badRequest()
                        .body(R.error().message("Failed: This email is already in use!"));
            }

            // update email
            user.setEmail(email);
        }

        // check the bio
        if (!bio.equals(user.getBio())){
            // update bio
            user.setBio(bio);
        }

        // update db
        userRepository.save(user);

        return ResponseEntity.ok(R.ok().data("user", user));
    }

    @PostMapping("/editApplicationBackground")
    public ResponseEntity<?> editApplicationBackground(@Valid @RequestBody EditBackgroundRequest ebRequest, BindingResult bindingResult, HttpServletRequest request){

        // get the current user
        User user = jwtUtils.getUserFromRequestByToken(request);

        // check the auto validation
        if(bindingResult.hasErrors()){
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message(bindingResult.getAllErrors().get(0).getDefaultMessage()));
        }

        // get the background obj of this user
        Profile profile = user.getProfile();

        // check English proficiency test type
        if (ebRequest.getTestType().equals("IELTS")){
            // get scores
            double ieltsTotal = ebRequest.getTotalIELTS();
            double ieltsL = ebRequest.getListeningIELTS();
            double ieltsS = ebRequest.getSpeakingIELTS();
            double ieltsR = ebRequest.getReadingIELTS();
            double ieltsW = ebRequest.getWritingIELTS();
            // get the decimal part
            int dT = Integer.parseInt(String.valueOf(ieltsTotal).split("\\.")[1]);
            int dL = Integer.parseInt(String.valueOf(ieltsL).split("\\.")[1]);
            int dS = Integer.parseInt(String.valueOf(ieltsS).split("\\.")[1]);
            int dR = Integer.parseInt(String.valueOf(ieltsR).split("\\.")[1]);
            int dW = Integer.parseInt(String.valueOf(ieltsW).split("\\.")[1]);
            // the decimal part can be 0 or 5 only
            if ((dT != 0 && dT != 5) ||
                    (dL != 0 && dL != 5) ||
                    (dS != 0 && dS != 5) ||
                    (dR != 0 && dR != 5) ||
                    (dW != 0 && dW != 5)){
                return ResponseEntity
                        .badRequest()
                        .body(R.error().message("Failed: The decimal part of IELTS score should be 0 or 5 only!"));
            }
            // check if the sub-scores match the total score
            double initialTotal = (ieltsS + ieltsL + ieltsR + ieltsW) / 4;
            double realTotal = Math.round(initialTotal * 2) / 2.0;
            if (ieltsTotal != realTotal){
                return ResponseEntity
                        .badRequest()
                        .body(R.error().message("Failed: The IELTS sub-scores do not match the total score!"));
            }
            // update the English Proficiency Tests section (IELTS)
            profile.setTestType(ebRequest.getTestType());
            profile.setTotalIELTS(ieltsTotal);
            profile.setListeningIELTS(ieltsL);
            profile.setReadingIELTS(ieltsR);
            profile.setSpeakingIELTS(ieltsS);
            profile.setWritingIELTS(ieltsW);

        }else if(ebRequest.getTestType().equals("TOEFL")){
            // get scores
            int toeflT = ebRequest.getTotalTOEFL();
            int toeflR = ebRequest.getReadingTOEFL();
            int toeflL = ebRequest.getListeningTOEFL();
            int toeflS = ebRequest.getSpeakingTOEFL();
            int toeflW = ebRequest.getWritingTOEFL();
            // check if the sub-scores match the total score
            if (toeflT != (toeflR + toeflL + toeflS + toeflW)){
                return ResponseEntity
                        .badRequest()
                        .body(R.error().message("Failed: The TOEFL sub-scores do not match the total score!"));
            }
            // update the English Proficiency Tests section (TOEFL)
            profile.setTestType(ebRequest.getTestType());
            profile.setTotalTOEFL(toeflT);
            profile.setReadingTOEFL(toeflR);
            profile.setListeningTOEFL(toeflL);
            profile.setSpeakingTOEFL(toeflS);
            profile.setWritingTOEFL(toeflW);

        }else{
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message("Failed: English test type Error!"));
        }

        // check gre score
        int greT = ebRequest.getGreTotal();
        int greV = ebRequest.getGreVerbal();
        int greQ = ebRequest.getGreQuantitative();
        int greAW = ebRequest.getGreAnalyticalWriting();
        if (greT != (greV + greQ)){
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message("Failed: The GRE sub-scores do not match the total score!"));
        }

        // update the Application Target section
        profile.setApplicationRound(ebRequest.getApplicationRound());
        profile.setTargetDegree(ebRequest.getTargetDegree());
        profile.setTargetMajor(ebRequest.getTargetMajor());
        profile.setTargetOfferType(ebRequest.getTargetOfferType());

        // update the undergraduate background section
        profile.setGpa(ebRequest.getGpa());
        profile.setRank(ebRequest.getRank());
        profile.setUnderGradSchoolCate(ebRequest.getUnderGradSchoolCate());
        profile.setUnderGradSchoolName(ebRequest.getUnderGradSchoolName());
        profile.setUnderGradMajor(ebRequest.getUnderGradMajor());

        // update the GRE section
        profile.setGreTotal(greT);
        profile.setGreAnalyticalWriting(greAW);
        profile.setGreVerbal(greV);
        profile.setGreQuantitative(greQ);

        // save to db
        profileRepository.save(profile);

        return ResponseEntity.ok(R.ok().data("user", user));
    }

    @PatchMapping("/updateUser")
    public R updateUser(@RequestBody UserUpdateVo userInfo) {
        User user = userRepository.findById(userInfo.getId()).orElse(null);

        String username = userInfo.getUsername();
        if (!username.equals(user.getUsername())){
            // if taken by another user
            if (userRepository.existsByUsername(username)){
                return R.error().message("Failed: This username has already been taken!");
            }

            // update username
            user.setUsername(username);
        }

        String email = userInfo.getEmail();
        // check the email
        if (!email.equals(user.getEmail())){
            // if taken by another user
            if (userRepository.existsByEmail(email)){
                return R.error().message("Failed: This email is already in use!");
            }

            // update email
            user.setEmail(email);
        }

        Set<Role> roles = new HashSet<>();
        for (String role: userInfo.getRoles()) {
            roles.add(roleRepository.findByName(ERole.valueOf(role)).orElse(null));
        }

        user.setRoles(roles);

        // update the password for user
        user.setPassword(encoder.encode(userInfo.getPassword()));
        userRepository.save(user);

        return R.ok().message("Update successfully!").data("data", user);

    }

    @PostMapping("/createUser")
    public R createUser(@RequestBody UserUpdateVo userInfo) {

        User user = new User();

        String username = userInfo.getUsername();
        if (!username.equals(user.getUsername())){
            // if taken by another user
            if (userRepository.existsByUsername(username)){
                return R.error().message("Failed: This username has already been taken!");
            }

            // update username
            user.setUsername(username);
        }

        String email = userInfo.getEmail();
        // check the email
        if (!email.equals(user.getEmail())){
            // if taken by another user
            if (userRepository.existsByEmail(email)){
                return R.error().message("Failed: This email is already in use!");
            }

            // update email
            user.setEmail(email);
        }

        Set<Role> roles = new HashSet<>();
        for (String role: userInfo.getRoles()) {
            roles.add(roleRepository.findByName(ERole.valueOf(role)).orElse(null));
        }

        user.setRoles(roles);

        // update the password for user
        user.setPassword(encoder.encode(userInfo.getPassword()));
        userRepository.save(user);

        return R.ok().message("Create successfully!").data("data", user);

    }

    @RequestMapping("/condition-query/{current}/{limit}")
    public R conditionQuery(@PathVariable("current") long current,
                            @PathVariable("limit") long limit,
                            @RequestBody(required = false) UserQueryVo userQueryVo) {
        Page<User> map = userService.pageByVo(current-1, limit, userQueryVo);
        return R.ok().data("data", map);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<User> search(@RequestParam(value = "search") String search) {
        Specification<User> spec = new SpecificationsBuilder<User>().buildSpecification(search);
        return userRepository.findAll(spec);
    }

    @RequestMapping("/get-liked-programs")
    public R likeProgram(HttpServletRequest request) {
        User user = jwtUtils.getUserFromRequestByToken(request);
        Set<Program> likedPrograms = user.getLikedPrograms();
        return R.ok().data("likedPrograms", likedPrograms);
    }
}
