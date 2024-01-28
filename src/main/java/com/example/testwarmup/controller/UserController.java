package com.example.testwarmup.controller;

import com.example.testwarmup.Dao.JwtUtil;
import com.example.testwarmup.mapper.UserMapper;
import com.example.testwarmup.mapper.UserServer;
import com.example.testwarmup.pojo.User;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserServer userServer;
    @Autowired
    JwtUtil jwtUtil;
    @GetMapping
    public List<User> getUser(){
        return userMapper.findAll();
    }
    @PostMapping("/register/")
    public Map<String, Object> addUser(@RequestBody User user){
        return userServer.registerUser(user);
    }
    @PostMapping("/login/")
    public Map<String, Object> loginUser(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        return userServer.loginUser(username, password);
    }

    @PostMapping("change-password")
    public Map<String, Object> changePassword(
            @RequestHeader("Authorization") String token,
            @RequestBody Map<String, String> request) {

        // 验证 token 的有效性
        if (jwtUtil.validateToken(token)) {
            // 从 token 中获取用户名
            String username = jwtUtil.getUsernameFromToken(token);
            // 从 request 中获取新密码
            String newPassword = request.get("newPassword");
            // 调用 UserService 修改密码的方法

            Map<String, Object> response = new HashMap<>();
            response.put("code","200");

            return response;
        } else {
            // Token 无效的处理逻辑
            Map<String, Object> response = new HashMap<>();
            response.put("code", -1);
            response.put("msg", "Unauthorized");
            return response;
        }

    }
}
