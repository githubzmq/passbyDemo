package com.passby.service;

import com.passby.entity.User;

/**
 * Created by 01054511 on 2017/5/8.
 */

public interface UserService {
    User getById(int id);

    int save(User user);
}
