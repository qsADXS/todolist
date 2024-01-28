package com.example.testwarmup.mapper;

import com.example.testwarmup.pojo.User;

import java.util.Map;

public interface UserServer {

    Map<String,Object> registerUser(User user);

    Map<String,Object> loginUser(String username, String password);

    String getName(String token);
}
