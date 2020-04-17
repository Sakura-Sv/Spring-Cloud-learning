package com.test.springcloud.demo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.springcloud.demo.entity.User;
import com.test.springcloud.demo.entity.UserDto;
import com.test.springcloud.demo.mapper.UserMapper;
import com.test.springcloud.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    private static final Integer PAGESIZE = 5;

    @Override
    public User getUserInfo(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public Page<User> getPage(Integer index) {
        return this.page(new Page<>(index, PAGESIZE));
    }

    @Override
    @Transactional
    public User saveUser(UserDto userDto) {
        User user = new User(userDto);
        this.saveOrUpdate(user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userMapper.deleteById(id);
    }
}
