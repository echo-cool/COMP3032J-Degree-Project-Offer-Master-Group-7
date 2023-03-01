package com.group7.controller.auth.reg;

import com.group7.db.jpa.User;
import com.group7.utils.common.R;

/**
 * @Author: LiuZhe
 * @Date: 2023/2/28 - 21:36
 */
public interface RegisterService {

    public R register(RegisterVo registerVo);
    public User getUserById(Long id);
}
