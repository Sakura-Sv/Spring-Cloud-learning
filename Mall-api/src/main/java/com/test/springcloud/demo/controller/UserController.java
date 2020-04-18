package com.test.springcloud.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.springcloud.demo.entity.User;
import com.test.springcloud.demo.entity.UserDto;
import com.test.springcloud.demo.service.UserService;
import com.test.springcloud.demo.util.response.AjaxResponseBody;
import com.test.springcloud.demo.util.response.Result;
import com.test.springcloud.demo.util.response.ResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@AjaxResponseBody
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public Result<List<UserDto>> findAll(Integer index) {
        Page<User> users = userService.getPage(index);
        if (users != null) {
            return Result.success(users.getRecords().stream().map(UserDto::new).collect(Collectors.toList()));
        }
        return Result.failure();
    }

    @GetMapping("/{id}")
    public Result<UserDto> detail(@PathVariable Long id) {
        User user = userService.getUserInfo(id);
        return (null != user) ? Result.success(new UserDto(user)) : Result.failure(ResultStatus.WRONG_PARAMETERS);
    }

    @PostMapping("/{id}")
    public Result<UserDto> update(@PathVariable Long id,
                                  @RequestBody UserDto userDto) {
        userDto.setId(id);
        User user = userService.saveUser(userDto);
        return (null != user) ? Result.success(new UserDto(user)) : Result.failure(ResultStatus.WRONG_PARAMETERS);
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return Result.success(true);
    }

}
