package com.sharding.shardingjdbc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sharding.shardingjdbc.entity.UserInfo;
import com.sharding.shardingjdbc.mapper.UserInfoMapper;
import com.sharding.shardingjdbc.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author Juncheng He
 * @title: UserInfoImpl
 * @projectName shardingjdbc
 * @description: TODO
 * @date 2020/6/4  14:40
 */
@Service
public class UserInfoImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
}
