package com.cs.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {

        // 测试数据库的连接
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }

}
