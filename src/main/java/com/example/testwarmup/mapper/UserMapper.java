package com.example.testwarmup.mapper;

import com.example.testwarmup.pojo.User;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Mapper
@Resource
public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where username = #{username}")
    User findByUsername(String username);

    @Update("INSERT INTO `user` (`username`, `password`) VALUES (#{username},#{password}); ")
    @Transactional
    void insertUser(User user);
}
