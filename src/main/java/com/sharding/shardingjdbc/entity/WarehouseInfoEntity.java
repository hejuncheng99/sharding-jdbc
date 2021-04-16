package com.sharding.shardingjdbc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Juncheng He
 * @title: WarehouseInfoEntity
 * @projectName shardingjdbc
 * @description: TODO
 * @date 2020/6/22  10:18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("warehouse_info")
public class WarehouseInfoEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "warehouse_id", type = IdType.AUTO)
    private Long warehouseId;

    @TableField("warehouse_name")
    private String warehouseName;

    @TableField("principal")
    private String principal;

    @TableField("phone_num")
    private String phoneNum;

    @TableField("address")
    private String address;

    @TableField("state")
    private Integer state;

    @TableField("create_user")
    private Long createUser;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_user")
    private Long updateUser;

    @TableField("update_time")
    private Date updateTime;
}
