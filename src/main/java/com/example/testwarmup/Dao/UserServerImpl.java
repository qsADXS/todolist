package com.example.testwarmup.Dao;

import com.example.testwarmup.mapper.UserMapper;
import com.example.testwarmup.mapper.UserServer;
import com.example.testwarmup.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServerImpl implements UserServer {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Map<String,Object> registerUser(User user) {
        Map<String,Object>responseMap = new HashMap<>();
        User existingUser = userMapper.findByUsername(user.getUsername());
        if (existingUser != null) {
            responseMap.put("code",-1);
            responseMap.put("msg","已存在相同用户名");
        }else{
        // 插入用户到数据库
            userMapper.insertUser(user);
            responseMap.put("code",200);
            responseMap.put("msg","success");
        }
        return responseMap;
    }

    @Override
    public Map<String, Object> loginUser(String username, String password) {
        Map<String, Object> responseMap = new HashMap<>();

        User user = userMapper.findByUsername(username);

        if (user != null && password.equals(user.getPassword())) {
            // 用户身份验证成功，生成令牌
            String token = jwtUtil.generateToken(username);

            responseMap.put("code", 200);
            responseMap.put("msg", "success");
            responseMap.put("token", token);
        } else {
            responseMap.put("code", -1);
            responseMap.put("msg", "无效的凭据");
        }

        return responseMap;
    }

    @Override
    public String getName(String token) {
        JwtUtil jwtUtil1 = new JwtUtil();
        return jwtUtil1.getUsernameFromToken(token);
    }



}

