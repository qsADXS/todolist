package com.example.testwarmup.mapper;

import com.example.testwarmup.pojo.Todolist;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
@Resource
public interface TodolistMapper {
    @Select("select * from todolist where userid = #{userid}")
    List<Todolist> findByUserid(Integer userid);
    @Select("select * from todolist where UUID = #{UUID}")
    Todolist findByUUID(Integer UUID);
    @Select("select UUID from todolist where userid = #{userid} and id =#{id}")
    Integer findUUID(Integer id,Integer userid);
    @Select("select * from todolist where userid = #{userid} and status = #{status}")
    List<Todolist> findByUseridWhereStatus(Integer userid,String status);
    @Select("select * from todolist where username = #{username}")
    List<Todolist> findByUsername(String username);
    @Select("Select MAX(id) from `todolist` where `userid` = #{userid}")
    Integer getMaxid(Integer userid);
    @Update("INSERT INTO `todolist` (`id`, `content`, `start_time`, `end_time`, `userid`, `status`) " +
            "VALUES (#{id},#{content},#{start_time},#{end_time},#{userid},#{status}); ")
    void insert(Todolist todolist);

    @Update("UPDATE `todolist` SET `status` = #{status}  WHERE `UUID` = #{UUID}")
    void updateStatus(String status,Integer UUID);

    @Update("update `todolist` set id = id - 1 where id > #{id} and userid = #{userid}")
    void updateid(Integer id,Integer userid);

    @Delete("DELETE FROM `todolist` WHERE `UUID` = #{UUID}")
    void delete(Integer UUID);
}
