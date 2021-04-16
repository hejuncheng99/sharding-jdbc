package com.sharding.shardingjdbc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sharding.shardingjdbc.entity.WarehouseInfoEntity;
import com.sharding.shardingjdbc.vo.UserAndWareHouseVo;

/**
 * @author Juncheng He
 * @title: WarehouseInfoService
 * @projectName shardingjdbc
 * @description: TODO
 * @date 2020/6/22  10:20
 */
public interface WarehouseInfoService extends IService<WarehouseInfoEntity> {
    /**
     * 连表查询
     * @return
     */
    IPage<UserAndWareHouseVo> getUserAndWareHouseVo();

    /**
     * 测试查询路由
     * @return
     */
    WarehouseInfoEntity getByWarehouseId();
}
