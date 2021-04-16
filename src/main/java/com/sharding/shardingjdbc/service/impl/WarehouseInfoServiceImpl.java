package com.sharding.shardingjdbc.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sharding.shardingjdbc.entity.WarehouseInfoEntity;
import com.sharding.shardingjdbc.mapper.WarehouseInfoMapper;
import com.sharding.shardingjdbc.service.WarehouseInfoService;
import com.sharding.shardingjdbc.vo.UserAndWareHouseVo;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.stereotype.Service;

/**
 * @author Juncheng He
 * @title: WarehouseInfoServiceImpl
 * @projectName shardingjdbc
 * @description: TODO
 * @date 2020/6/22  10:20
 */
@Service
public class WarehouseInfoServiceImpl extends ServiceImpl<WarehouseInfoMapper, WarehouseInfoEntity> implements WarehouseInfoService {
    @Override
    public IPage<UserAndWareHouseVo> getUserAndWareHouseVo() {

        return this.baseMapper.getUserAndWareHouseVo(new Page<>(1, 100));

    }

    @Override

    @ShardingTransactionType(TransactionType.LOCAL)
    public WarehouseInfoEntity getByWarehouseId() {
        return this.baseMapper.getByWarehouseId();
    }
}
