package com.sharding.shardingjdbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sharding.shardingjdbc.entity.WarehouseInfoEntity;
import com.sharding.shardingjdbc.vo.UserAndWareHouseVo;

/**
 * @author Juncheng He
 * @title: WarehouseInfoMapper
 * @projectName shardingjdbc
 * @description: TODO
 * @date 2020/6/22  10:17
 */
public interface WarehouseInfoMapper extends BaseMapper<WarehouseInfoEntity> {
    /**
     * 连表查询
     *
     * @return
     */
    Page<UserAndWareHouseVo> getUserAndWareHouseVo(Page page);

    /**
     * 测试查询路由
     * @return
     */
    WarehouseInfoEntity getByWarehouseId();



}
