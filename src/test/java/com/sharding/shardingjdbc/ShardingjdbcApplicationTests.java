package com.sharding.shardingjdbc;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sharding.shardingjdbc.entity.AddressEntity;
import com.sharding.shardingjdbc.entity.UserInfo;
import com.sharding.shardingjdbc.entity.WarehouseInfoEntity;
import com.sharding.shardingjdbc.service.AddressService;
import com.sharding.shardingjdbc.service.UserInfoService;
import com.sharding.shardingjdbc.service.WarehouseInfoService;
import com.sharding.shardingjdbc.vo.UserAndWareHouseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootTest
@Slf4j
class ShardingjdbcApplicationTests {


    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private WarehouseInfoService warehouseInfoService;

    @Test
    void insertUserInfo() {

        for (int i = 1; i < 20; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setCreateTime(new Date());
            userInfo.setEmail("email-" + i);
            userInfo.setName("name-" + i);
            userInfo.setPhone("Phone-" + i);
            userInfo.setPassword("password-" + i);
            if (i % 2 == 0) {
                userInfo.setSex(Boolean.TRUE);

            } else {
                userInfo.setSex(Boolean.FALSE);

            }
            userInfoService.save(userInfo);
        }
    }

    @Test
    void insertAddress() {

        for (int i = 0; i < 20; i++) {
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setCode("CODE" + i);
            addressEntity.setLit(i);
            addressEntity.setName("NAME" + i);
            addressEntity.setType(i / 2);
            addressEntity.setPid("PID" + i);


            addressService.save(addressEntity);
        }
    }

    @Test
    void insertWareHouse() {

        for (int i = 0; i < 20; i++) {
            WarehouseInfoEntity warehouseInfoEntity = new WarehouseInfoEntity();
            warehouseInfoEntity.setWarehouseName("仓库" + i);
            warehouseInfoEntity.setPrincipal("负责人" + i);
            warehouseInfoEntity.setPhoneNum("电话号码" + i);
            warehouseInfoEntity.setAddress("地址" + i);
            warehouseInfoEntity.setCreateTime(new Date());

            warehouseInfoService.save(warehouseInfoEntity);
        }
    }

    @Test
    void queryPage() {

        IPage<UserInfo> page = userInfoService.page(
                new Page<>(1, 10),
                new QueryWrapper<UserInfo>()
                        .orderByDesc("create_time")
                        .ge("create_time", "2020-06-09")
        );

        log.error(page.toString());


    }


    @Test
    void getUserAndWareHouseVo() {
//        IPage<UserAndWareHouseVo> list = warehouseInfoService.getUserAndWareHouseVo();
//        log.info(list.getRecords().toString());

        warehouseInfoService.list();
    }

    @Test
    void deleteById() {
    }

    @Test
    void updateById() {

        UserInfo userInfo = userInfoService.getById(1272695487871954945L);

        WarehouseInfoEntity warehouseInfoEntity = warehouseInfoService.getById(481792958505422850L);
        warehouseInfoEntity.setUpdateUser(userInfo.getUserId());
        warehouseInfoEntity.setUpdateTime(new Date());

        warehouseInfoService.updateById(warehouseInfoEntity);

    }


    @Test
    void getByWarehouseId(){
        warehouseInfoService.getByWarehouseId();
    }
}
