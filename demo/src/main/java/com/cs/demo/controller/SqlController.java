package com.cs.demo.controller;

import com.cs.demo.entity.User;
import com.cs.demo.mapper.SqlMapper;
import com.cs.demo.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class SqlController {

    @Resource
    SqlMapper sqlMapper;

    @PostMapping("/login1")
    Result userLogin1(@RequestParam(value = "name") String name,
                     @RequestParam(value = "password") String password) {
        User user = sqlMapper.userLogin1(name, password);
        Result res;
        if(user == null) {
            res = new Result(-1, "failure", "用户名和密码不匹配");
        }
        else {
            res = new Result<String>(1, "success", user.toString());
        }
        return res;
    }

    @PostMapping("/login2")
    Result userLogin2(@RequestParam(value = "name") String name,
                     @RequestParam(value = "password") String password) {
        User user = sqlMapper.userLogin2(name, password);
        Result res;
        if(user == null) {
            res = new Result(-1, "failure", "用户名和密码不匹配");
        }
        else {
            res = new Result<String>(1, "success", user.toString());
        }
        return res;
    }

    @PostMapping("/query1")
    Result query1(@RequestParam(value = "name") String name) {
        Result res;
        List<User> users = sqlMapper.vagueQueryUsersByName1(name);
        if(users == null) {
            res = new Result(-1, "failure", "不存在该用户");
        } else {
            res = new Result(1, "success", users.toString());
        }
        return res;
    }

    @PostMapping("/query2")
    Result query2(@RequestParam(value = "name") String name) {
        Result res;
        List<User> users = sqlMapper.vagueQueryUsersByName2(name);
        if(users == null) {
            res = new Result(-1, "failure", "不存在该用户");
        } else {
            res = new Result(1, "success", users.toString());
        }
        return res;
    }

    @GetMapping("/test")
    String test() {
        return "<img src='http://www.xxx.com' onerror='alert(document.cookie)'>";
    }

}
