package com.group7.controller.auth.reg;

import com.group7.db.jpa.User;
import com.group7.db.jpa.UserRepository;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * @Author: LiuZhe
 * @Date: 2023/2/28 - 21:37
 */
@Service
public class RegisterServiceImpl implements RegisterService{

    @Resource
    private UserRepository userRepository;

    @Override
    public R register(RegisterVo registerVo) {
        // get registration info from VO
        String username = registerVo.getUsername();
        String email = registerVo.getEmail();
        String password = registerVo.getPassword();
        String rePassword = registerVo.getRePassword();

        // check empty
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(email) ||
                StringUtils.isEmpty(password) || StringUtils.isEmpty(rePassword)){
            return R.error().message("Registration failed - empty field(s)");
        }

        // check two passwords
        if (!password.equals(rePassword)){
            return R.error().message("Registration failed - different passwords");
        }

        // check redundant email or username
        User byUsername = userRepository.findByUsername(username);
        User byEmail = userRepository.findByEmail(email);
        if (byUsername != null){
            return R.error().message("Registration failed - username already exists");
        }else if(byEmail != null){
            return R.error().message("Registration failed - email already exists");
        }

        // fine to register now
        userRepository.save(new User(username, email, password));

        return R.ok();
    }

    @Override
    public User getUserById(Long id) {
        if(id == null){
            return null;
        }
        if(!userRepository.findById(id).isPresent()){
            return null;
        }
        User user = userRepository.findById(id).get();
        return user;
    }


}
