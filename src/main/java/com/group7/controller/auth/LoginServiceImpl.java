package com.group7.controller.auth;

import com.group7.db.jpa.User;
import com.group7.db.jpa.UserRepository;
import com.group7.utils.common.JwtUtil;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


/**
 * @Author: WangYuyang
 * @Date: 2023/2/26-18:21
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.controller.auth
 * @Description:
 **/
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserRepository userRepository;

    @Override
    public R login(LoginDTO loginDTO) {
        // get login form inputs from DTO
        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();

        // check inputs
        if (StringUtils.isEmpty(email)) {
            return R.error().message("Login failed - Email cannot be empty!");
        }
        if (StringUtils.isEmpty(password)) {
            return R.error().message("Login failed - Password cannot be empty!");
        }

        //query by example
        User user = userRepository.findByEmail(loginDTO.getEmail());

        // check user
        if (user == null){
            return  R.error().message("Login failed - Email not found!");
        }

        // check the password
        if(!password.equals(user.getPassword())){
            return R.error().message("Login failed - Wrong password!");
        }

        // encapsulate user into VO and create a token
        LoginVO loginVO = new LoginVO();
        loginVO.setId(user.getId().toString());
        //这里token直接用一个uuid
        //使用jwt的情况下，会生成一个jwt token,jwt token里会包含用户的信息
        String token = JwtUtil.createToken(user);
        loginVO.setToken(token);
        loginVO.setUser(user);

        return R.ok().data("token", token).data("data", loginVO);
    }
}
