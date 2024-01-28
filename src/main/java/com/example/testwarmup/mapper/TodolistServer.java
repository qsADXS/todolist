package com.example.testwarmup.mapper;

import com.example.testwarmup.pojo.Todolist;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface TodolistServer {
    Map<String, Object> addTodo(Todolist todolist);

    Map<String, Object> getAllEvent(String status, String username);

    Map<String, Object> update(Integer id,String username);

    Map<String, Object> delete(Integer id,String username);
}
