package com.cs.demo.mapper;

import com.cs.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
class SqlMapperTest {

    @Resource
    SqlMapper sqlMapper;


    @Test
    void judgeLogin() {
        User user = sqlMapper.userLogin1("'LiSi' #", " ");
        System.out.println(user);
    }

    @Test
    void queryUsersAsc() {
        List<User> users = sqlMapper.vagueQueryUsersByName2("Z");
        for(User user : users) {
            System.out.println(user.toString());
        }
    }
}