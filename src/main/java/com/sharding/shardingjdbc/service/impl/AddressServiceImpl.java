package com.sharding.shardingjdbc.service.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sharding.shardingjdbc.entity.AddressEntity;
import com.sharding.shardingjdbc.mapper.AddressMapper;
import com.sharding.shardingjdbc.service.AddressService;
import org.springframework.stereotype.Service;

/**
 * @author Juncheng He
 * @title: AddressServiceImpl
 * @projectName shardingjdbc
 * @description: TODO
 * @date 2020/6/9  10:39
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, AddressEntity> implements AddressService {
}
