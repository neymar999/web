package com.example.demo.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.commom.Result;
import com.example.demo.entity.Now;
import com.example.demo.mapper.NowMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/now")
public class NowController {

    @Resource
    NowMapper nowMapper;

    @PostMapping
    public Result save(@RequestBody Now now) {
        nowMapper.insert(now);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Now now) {
        nowMapper.updateById(now);
        return Result.success();
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "") String searchkaiHome,
                              String searchkaiPeace, String searchkaiGuest,String searchno) {

        LambdaQueryWrapper<Now> wrapper = Wrappers.<Now>lambdaQuery();
        wrapper.gt(Now::getCreatedtime,"2021-11-27 00:00:00").lt(Now::getCreatedtime,"2021-11-28 00:00:00");

       // wrapper.like(Now::getKaihome, searchkaiHome).like(Now::getKaipeace, searchkaiPeace).like(Now::getKaiguest, searchkaiGuest);
        Page<Now> userPage = nowMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(userPage);
    }

}
