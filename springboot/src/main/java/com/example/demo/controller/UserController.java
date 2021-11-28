package com.example.demo.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.commom.Result;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserMapper userMapper;
    @PostMapping("/login")
    public Result<?> login(@RequestBody User user) {
        User res = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getScorehome,user.getScorehome()).eq(User::getScoreguest,user.getScoreguest()));
        if(res==null){
            return Result.success();
        }
        return Result.error("-1","密码错误");
    }

    @PostMapping
    public Result save(@RequestBody User user) {
        userMapper.insert(user);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody User user) {
        userMapper.updateById(user);
        return Result.success();
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "") String searchHome,
                              String searchPeace, String searchGuest, String searchbig, String searchkailibig) {

        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        wrapper.like(User::getHome, searchHome).like(User::getPeace, searchPeace).like(User::getGuest, searchGuest);
//                .le(User::getHome,searchbig).le(User::getPeace,searchbig).le(User::getGuest,searchbig)
//                .le(User::getKaihome,searchkailibig).le(User::getKaipeace,searchkailibig).le(User::getKaiguest,searchkailibig);
        Page<User> userPage = userMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(userPage);
    }
}
