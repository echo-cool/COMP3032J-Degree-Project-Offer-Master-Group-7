package com.group7.controller.auth;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import cn.hutool.json.JSONObject;
import com.google.gson.Gson;
import com.group7.controller.auth.payload.LoginRequest;
import com.group7.controller.auth.payload.SignupRequest;
import com.group7.controller.user.UserDetailsImpl;
import com.group7.db.jpa.*;
import com.group7.db.jpa.utils.ERole;
import com.group7.utils.common.JwtResponse;
import com.group7.utils.common.JwtUtils;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.authentication.OAuth2LoginAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.group7.utils.common.R;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @Author: WangYuyang
 * @Date: 2023/2/26-18:00
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.controller
 * @Description:
 **/
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("oauth/echocool/redirection")
    public RedirectView getOAuthRedirectionURL(RedirectAttributes attributes){
        String authUrl = "http://auth.echo.cool/o/authorize/";
        String clientId = "OjxfcvMiTPb7DEIoopIebvJNNzWtr8Og3R1uVRuU";
        String secret = "gg7ouyLMif08EVOUdJMSEL15oZOBSD2ZKpAmc1BvFs3YWPZONqGJb7BqrgkMkuw1rrh3rCmuI98DVgWFnLLffna8ePPBIBdLEUw82GJgcIKAuR1lQ6cirhw5borQyOBc";
        String redirectUrl = "http://localhost:3000/login";
        String responseType = "code";
        String scope = "openid";
        // Return the OAuth server redirection URL
        String url = authUrl + "?client_id=" + clientId + "&redirect_uri=" + redirectUrl + "&response_type=" + responseType + "&scope=" + scope;
        return new RedirectView(url, true, true, false);
//        return R.ok().data("url", );
    }
    @GetMapping("oauth/echocool/callback")
    public R getJWTfromOAuthToken(ServletRequest request) throws IOException {
        String authUrl = "http://auth.echo.cool/o/authorize/";
        String clientId = "OjxfcvMiTPb7DEIoopIebvJNNzWtr8Og3R1uVRuU";
        String secret = "gg7ouyLMif08EVOUdJMSEL15oZOBSD2ZKpAmc1BvFs3YWPZONqGJb7BqrgkMkuw1rrh3rCmuI98DVgWFnLLffna8ePPBIBdLEUw82GJgcIKAuR1lQ6cirhw5borQyOBc";
        String redirectUrl = "http://localhost:3000/login";
        String responseType = "code";
        String scope = "openid";
        String token = request.getParameter("code");
        //http://auth.echo.cool/o/token
        okhttp3.Request request1 = new okhttp3.Request.Builder()
                .url("http://auth.echo.cool/o/token/")
                .post(okhttp3.RequestBody.create(okhttp3.MediaType.parse("application/x-www-form-urlencoded"), "client_id=" + clientId + "&client_secret=" + secret + "&grant_type=authorization_code&code=" + token + "&redirect_uri=" + redirectUrl))
                .build();

        okhttp3.Response response = null;
        try {
            response = new OkHttpClient().newCall(request1).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(response == null){
            return R.error().message("Failed to get the response from the OAuth server, response is null").data("URL", "http://auth.echo.cool/o/token?client_id=" + clientId + "&client_secret=" + secret + "&grant_type=authorization_code&code=" + token + "&redirect_uri=" + redirectUrl);
        }
        if (!response.isSuccessful()) {
            return R.error().message("Failed to get the response from the OAuth server, response code: " + response.code() + ", message: " + response.message() + ", body: " + response.body().string()).data("URL", "http://auth.echo.cool/o/token?client_id=" + clientId + "&client_secret=" + secret + "&grant_type=authorization_code&code=" + token + "&redirect_uri=" + redirectUrl);
        }
        if(response.body() == null){
            return R.error().message("Failed to get the response from the OAuth server, body is null").data("URL", "http://auth.echo.cool/o/token?client_id=" + clientId + "&client_secret=" + secret + "&grant_type=authorization_code&code=" + token + "&redirect_uri=" + redirectUrl);
        }
        String body = null;
        try {
            body = response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //{\"access_token\": \"TxzEpRQuQakJAiXV7k46npDEEXwHrM\", \"expires_in\": 36000, \"token_type\": \"Bearer\", \"scope\": \"openid\", \"refresh_token\": \"OSdOlkcTBbV6Rp6pyUPyieRngWED8r\", \"id_token\": \"eyJ0eXAiOiAiSldUIiwgImFsZyI6ICJSUzI1NiIsICJraWQiOiAieDRud0dzcThUcEM5RVJ2ZnRkZTJpYnE5ZGk2Wlctcm5scHV1c1dLTmhLOCJ9.eyJhdWQiOiAiT2p4ZmN2TWlUUGI3REVJb29wSWVidkpOTnpXdHI4T2czUjF1VlJ1VSIsICJpYXQiOiAxNjgwODc2NjQyLCAiYXRfaGFzaCI6ICJyUlJBTWc4a2tEZ1JnNXExQUZpdThBIiwgInN1YiI6ICIyIiwgImdpdmVuX25hbWUiOiAid3l5IiwgImZhbWlseV9uYW1lIjogInd5eSIsICJuYW1lIjogInd5eSIsICJwcmVmZXJyZWRfdXNlcm5hbWUiOiAid3l5IiwgImVtYWlsIjogIiIsICJtYWlsIjogIiIsICJpc3MiOiAiaHR0cDovL2F1dGguZWNoby5jb29sL28iLCAiZXhwIjogMTY4MDkxMjY0MiwgImF1dGhfdGltZSI6IDE2ODA4NzE0ODEsICJqdGkiOiAiYTgzZTlmZTQtMmI2Ny00OGEzLTkzYjAtMDlhOWI4MDQ0YzVmIn0.mLVUGOWO-pdMzfqSqeDXdjl0febfZcmUcRdrKjANy3hV2kfgY4i7I2ZbHSgVSnneigiKA_c0baHjzwwXjd9g7sIS2zeMip1bghrTxQZt0-HMxqsEPzZ__8Q0MA-ZeK4dgriPDJ2VVevo-r4ybBK4fYjZPsxWKcu14_rI9Dq-O-Eatv_JER1UaTWrM5nA5Q0IIXhmPzIR4zIn7PQJ2GHaeomN9IzJZCds732BvAOv__86JaOiv8ui5yx46sdq8HigPFSMYdJ64eGR1xOqDcZhfbXCWbuvNuO1au6BpWZyMqXTSXxtznFb836AVnK2h69nISZcounV5Y8jBFQpTFzldLF6BhqMC9FnAzQMS5psH5x5NOX_48phFSOkb_CgSqTHJRCTn-VaiypjCk6D3aVwqzGbwDrH77uMY-ZCI9pe3ewZqxhosX83BjjBZbhR5PDTKJO9jBpa8TSxUjcZ4TCzwY7f87Druxr_A9Dhacz3t_EEkcMoa_K7Ss8hifvPauFKnr6Sp-FZaOecD5B__vkPzcRg41mWeUG0F3GYUxM38zxtY-0b5GZjh2c3LCpOpdKVZ75zz2ih0blHbmPZvY3Md2dbUqb7NLPdlsD0NwCcOVo0dP06HB86MdV-AEbWtXEXcLovSmsUoebxseyohhQr-jRbAQ2h1rO7MsqAqpWzUYk\"}"
        JSONObject json = new JSONObject(body);
        String access_token = (String) json.get("access_token");

        //http://auth.echo.cool/o/userinfo/
        Request request2 = new Request.Builder()
                .url("http://auth.echo.cool/o/userinfo/")
                .get()
                .addHeader("Authorization", "Bearer " + access_token)
                .build();
        Response response2 = null;

        try {
            response2 = new OkHttpClient().newCall(request2).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert response2 != null;
        if(response2.body() == null){
            return R.error().message("Failed to get the response from the OAuth server, body is null").data("URL", "http://auth.echo.cool/o/token?client_id=" + clientId + "&client_secret=" + secret + "&grant_type=authorization_code&code=" + token + "&redirect_uri=" + redirectUrl);
        }
        String body2 = response2.body().string();
        JSONObject json2 = new JSONObject(body2);
        System.out.println(json2);
        String email = (String) json2.get("email");
        System.out.println(email);
        User user = userRepository.findByEmail(email).orElse(null);
        if (user != null)
            user.setApplications(null);
        System.out.println(user);
        if (user != null){
            return R.ok().data("user", user).data("jwt", jwtUtils.generateJWTfromUser(user));
        }

        return R.error().message("NO USER FOUND")
                .data("code", token)
                .data("URL", "http://auth.echo.cool/o/token?client_id=" + clientId + "&client_secret=" + secret + "&grant_type=authorization_code&code=" + token + "&redirect_uri=" + redirectUrl)
                .data("response",body)
                .data("access_token", access_token)
                .data("userInfo", body2)
                .data("username", email)
                ;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult bindingResult) {

        // check the auto validation defined in LoginRequest
        if(bindingResult.hasErrors()){
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message(bindingResult.getAllErrors().get(0).getDefaultMessage()));
        }

        // check if the user exist
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElse(null);
        if (user == null){
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message("Login failed: User does not exist!"));
        }

        // check the password
        if(!encoder.matches(loginRequest.getPassword(), user.getPassword())){
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message("Login failed: Wrong password!"));
        }

        // for authentication and token generation
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getAvatar(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest, BindingResult bindingResult) {

        // check the auto validation defined in SignupRequest
        if(bindingResult.hasErrors()){
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message(bindingResult.getAllErrors().get(0).getDefaultMessage()));
        }

        // check username duplication
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message("Error: Username is already taken!"));
        }

        // check email duplication
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message("Error: Email is already in use!"));
        }

        // check two passwords
        if (!signUpRequest.getPassword().equals(signUpRequest.getRePassword())){
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message("Error: Two passwords do not match!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                                signUpRequest.getEmail(),
                                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin" -> {
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                    }
                    case "mod" -> {
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                    }
                    default -> {
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                    }
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(R.ok().message("User registered successfully!"));
    }

    @GetMapping(value = "/getUserInfo")
    public ResponseEntity<?> getUserByToken(HttpServletRequest request){
        // find user from the token in request header
        User user = jwtUtils.getUserFromRequestByToken(request);
        if (user == null){
            return ResponseEntity
                    .badRequest()
                    .body(R.error().message("Invalid token! User not found! You should login first."));
        }
        user.setApplications(null);


        // return the user info
        return ResponseEntity.ok(R.ok().data("user", user));
    }

}

//@RestController
//@RequestMapping(value = "/api")
//public class AuthController {
//    @Autowired
//    LoginService loginService;
//
//    @Autowired
//    RegisterService registerService;
//
//    @GetMapping(value = "/hello")
//    public R hello() {
//        return R.ok().message("hello");
//    }
//
//
//    @PostMapping(value = "/login")
//    @CrossOrigin
//    public R login(@RequestBody LoginDTO loginDTO) {
//        return loginService.login(loginDTO);
//    }
//
//    @PostMapping(value = "/logout")
//    @CrossOrigin
//    public R logout() {
//        return R.ok();
//    }
//
//
//    @PostMapping(value = "/register")
//    public R register(@RequestBody RegisterVo registerVo){
//        return registerService.register(registerVo);
//    }
//
//    @GetMapping(value = "/getUserInfo")
//    public R getUserByToken(HttpServletRequest request){
//        Long userId = JwtUtil.getUserIdByToken(request);
//        // query user from db
//        User user = registerService.getUserById(userId);
//        if (user == null){
//            return R.error().message("User not found");
//        }
//        return R.ok().data("user", user);
//    }
//
//}
