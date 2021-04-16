package com.sharding.shardingjdbc.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author JunCheng He
 * @since 2020-06-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_address")
public class AddressEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    @TableField("code")
    private String code;

    @TableField("name")
    private String name;

    @TableField("pid")
    private String pid;

    @TableField("type")
    private Integer type;

    @TableField("lit")
    private Integer lit;


}
