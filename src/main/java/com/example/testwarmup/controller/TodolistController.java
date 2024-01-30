package com.example.testwarmup.controller;

import com.example.testwarmup.mapper.TodolistServer;
import com.example.testwarmup.pojo.Todolist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
public class TodolistController {
    @Autowired
    private TodolistServer todolistServer;
    @PostMapping("/task")
    public Map<String, Object> creatEvent(@RequestBody Todolist todolist
                                        ){
        return todolistServer.addTodo(todolist);
    }
    @GetMapping("/task")
    public Map<String, Object> getEvent(@RequestParam Map<String,Object>map){
        map.putIfAbsent("status", -1);
        return todolistServer.getAllEvent(map.get("status").toString(),
                                            map.get("username").toString());
    }
    @PutMapping("/task/{id}")
    public Map<String,Object> update(@PathVariable Integer id,
                                     @RequestBody Map<String,Object> map){
        return todolistServer.update(id,map.get("username").toString());
    }
    @DeleteMapping("/task/{id}")
    public Map<String,Object> delete(@PathVariable Integer id,
                                     @RequestParam String username){
        return todolistServer.delete(id,username);
    }
    //这里前端要求将id放在body当中
    @PutMapping("/task")
    public Map<String,Object> update(@RequestBody Map<String,Object> map){
        return todolistServer.update(Integer.valueOf(map.get(("id")).toString()),
                                    map.get("username").toString());
    }
    @DeleteMapping("/task")
    public Map<String,Object> delete(@RequestBody Map<String,Object> map){
        return todolistServer.delete(Integer.valueOf(map.get(("id")).toString()),
                                    map.get("username").toString());
    }

}
