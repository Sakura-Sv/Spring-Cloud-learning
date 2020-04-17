package com.test.springcloud.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.springcloud.demo.entity.User;
import com.test.springcloud.demo.entity.UserDto;

public interface UserService  {

    User getUserInfo(Long id);

    Page<User> getPage(Integer index);

    User saveUser(UserDto userDto);

    void deleteUser(Long id);

}
