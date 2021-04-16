package com.sharding.shardingjdbc.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author Juncheng He
 * @title: UserAndWareHouseVo
 * @projectName shardingjdbc
 * @description: TODO
 * @date 2020/6/22  10:22
 */
@Data
public class UserAndWareHouseVo {
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

    @TableField("warehouse_name")
    private String warehouseName;


    private String cityName;

}

