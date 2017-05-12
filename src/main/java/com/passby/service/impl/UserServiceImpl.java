package com.passby.service.impl;

import com.passby.dao.UserMapper;
import com.passby.entity.User;
import com.passby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 用户信息
 *
 * @author zhangmq
 * @Create 2017-05-08 16:39
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public User getById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public int save(User user) {
        return userMapper.insertSelective(user);
    }
}
