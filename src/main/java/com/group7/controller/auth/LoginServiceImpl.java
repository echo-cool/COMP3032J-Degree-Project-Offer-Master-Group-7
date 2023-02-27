package com.group7.controller.auth;

import com.group7.db.jpa.User;
import com.group7.db.jpa.UserRepository;
import com.group7.utils.common.JwtUtil;
import com.group7.utils.common.R;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.UUID;


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
        if (StringUtils.isEmpty(loginDTO.getLoginName())) {
            return R.error().message("Username is empty");
        }
        if (StringUtils.isEmpty(loginDTO.getPassword())) {
            return R.error().message("Password is empty");
        }

        //query by example
        User user = userRepository.findByUsername(loginDTO.getLoginName());
        //比较密码
        if (user != null && user.getPassword().equals(loginDTO.getPassword())) {
            LoginVO loginVO = new LoginVO();
            loginVO.setId(user.getId().toString());
            //这里token直接用一个uuid
            //使用jwt的情况下，会生成一个jwt token,jwt token里会包含用户的信息
            System.out.println(user);
            String token = JwtUtil.createToken(user);
            loginVO.setToken(token);
            loginVO.setUser(user);
            return R.ok().data("data", loginVO);
        }
        return R.error().message("failed");
    }
}
