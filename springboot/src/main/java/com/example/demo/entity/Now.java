package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("nowkai")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Now {
    @TableId(value ="serialno",type = IdType.AUTO)
    private Integer serialno;
    private Integer no;
    private  Integer kaihome;
    private  Integer kaipeace;
    private  Integer kaiguest;
    private  Integer scorehome;
    private  Integer scoreguest;
    private  String createdtime;


}
