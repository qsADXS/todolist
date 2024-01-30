package com.example.testwarmup.Dao;

import com.example.testwarmup.mapper.TodolistMapper;
import com.example.testwarmup.mapper.TodolistServer;
import com.example.testwarmup.mapper.UserMapper;
import com.example.testwarmup.pojo.Todolist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class TodolistServerImpl implements TodolistServer {
    @Autowired
    TodolistMapper todolistMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String, Object> addTodo(Todolist todolist) {
        Map<String, Object> response = new HashMap<>();
        Integer userid;
        try {
            userid = userMapper.findByUsername(todolist.getUsername()).getId();
        }catch (Exception e){
            response.put("code",-1);
            response.put("mse",e.getCause());
            return response;
        }

        todolist.setUserid(userid);
        Integer maxid = todolistMapper.getMaxid(userid);
        if(maxid == null){
            maxid = 0;
        }
        todolist.setId(maxid+1);
        todolistMapper.insert(todolist);
        response.put("code",200);
        response.put("mse","success");
        return response;
    }

    @Override
    public Map<String, Object> getAllEvent(String status, String username) {
        Map<String, Object> response = new HashMap<>();
        Integer userid;
        try {
            userid = userMapper.findByUsername(username).getId();
        }catch (Exception e){
            response.put("code",-1);
            response.put("mse",e.getCause());
            return response;
        }
        List<Todolist> todolists;
        if(Objects.equals(status, "-1")){
            todolists = todolistMapper.findByUserid(userid);
        }else {
            todolists = todolistMapper.findByUseridWhereStatus(userid, status);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("item",todolists);
        data.put("total",todolists.size());

        response.put("data",data);
        response.put("msg","success");
        response.put("code",200);
        return  response;
    }

    @Override
    public Map<String, Object> update(Integer id,String username) {
        Map<String, Object> response = new HashMap<>();
        Integer userid;
        Integer UUID;
        String status;
        try {
            System.out.println(username);
            userid = userMapper.findByUsername(username).getId();
            UUID = todolistMapper.findUUID(id,userid);
            status = todolistMapper.findByUUID(UUID).getStatus();
            if(Objects.equals(status, "1")){
                status = "0";
            }else{
                status = "1";
            }
            todolistMapper.updateStatus(status,UUID);
        }catch (Exception e){
            response.put("code",-1);
            response.put("mse",e.getCause());
            return response;
        }
        response.put("code",200);
        response.put("msg","success");

        return  response;
    }

    @Override
    public Map<String, Object> delete(Integer id, String username) {
        Map<String, Object> response = new HashMap<>();
        Integer userid;
        Integer UUID;
        try {
            userid = userMapper.findByUsername(username).getId();
            UUID = todolistMapper.findUUID(id,userid);
            todolistMapper.delete(UUID);
            todolistMapper.updateid(id,userid);

        }catch (Exception e){
            response.put("code",-1);
            response.put("mse",e.getCause());
            return response;
        }
        response.put("code",200);
        response.put("msg","success");
        return response;
    }
}
