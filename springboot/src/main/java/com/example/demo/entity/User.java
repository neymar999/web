package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("bifakaili")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId(value ="serialno",type = IdType.AUTO)
    private Integer serialno;
    private  String home;
    private  String peace;
    private  String guest;
    private  Integer kaihome;
    private  Integer kaipeace;
    private  Integer kaiguest;
    private String dish;
    private  Integer scorehome;
    private  Integer scoreguest;


}
