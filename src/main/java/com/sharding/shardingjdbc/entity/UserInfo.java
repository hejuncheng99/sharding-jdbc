package com.sharding.shardingjdbc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Juncheng He
 * @title: UserInfo
 * @projectName shardingjdbc
 * @description: TODO
 * @date 2020/6/3  14:31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id")
    private Long userId;

    @TableField("name")
    private String name;

    @TableField("city_id")
    private Integer cityId;

    @TableField("sex")
    private Boolean sex;

    @TableField("phone")
    private String phone;

    @TableField("email")
    private String email;

    @TableField("create_time")
    private Date createTime;

    @TableField("password")
    private String password;


    private Long warehouseId;

}
