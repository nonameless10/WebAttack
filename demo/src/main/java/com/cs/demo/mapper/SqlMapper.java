package com.cs.demo.mapper;

import com.cs.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface SqlMapper {

    /**
     * 安全
     * 判断用户登录
     * @param userName
     * @param password
     * @return
     */
    @Select("select * from user where user_name = #{userName} and password = #{password}")
    User userLogin1(@Param("userName") String userName, @Param("password") String password);

    /**
     * 不安全
     * 判断用户登录
     * @param userName
     * @param password
     * @return
     */
    @Select("select * from user where user_name = '${userName}' and password = '${password}'")
    User userLogin2(@Param("userName") String userName, @Param("password") String password);


    /**
     * 不安全
     * 采用 ${} 模糊查询用户根据用户名
     * @param name
     * @return
     */
    @Select("select * from user where user_name like '%${name}%'")
    List<User> vagueQueryUsersByName1(@Param("name") String name);

    /**
     * 安全
     * 采用 concat + #{} 来模糊查询用户根据用户名
     * @param name
     * @return
     */
    @Select("select * from user where user_name like concat('%', #{name}, '%')")
    List<User> vagueQueryUsersByName2(@Param("name") String name);


}
