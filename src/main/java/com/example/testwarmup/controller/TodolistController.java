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
    public Map<String, Object> creatEvent(@RequestBody Todolist todolist){
        return todolistServer.addTodo(todolist);
    }
    @GetMapping("/task")
    public Map<String, Object> getEvent(@RequestParam String status,
                                        @RequestBody Map<String,Object> map){
        return todolistServer.getAllEvent(status, map.get("username").toString());
    }
    @PutMapping("/task/{id}")
    public Map<String,Object> update(@PathVariable Integer id,
                                     @RequestBody Map<String,Object> map){
        return todolistServer.update(id,map.get("username").toString());
    }
    @DeleteMapping("/task/{id}")
    public Map<String,Object> delete(@PathVariable Integer id,
                                     @RequestBody Map<String,Object> map){
        return todolistServer.delete(id,map.get("username").toString());
    }

}
