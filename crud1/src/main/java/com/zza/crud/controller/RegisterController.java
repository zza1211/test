package com.zza.crud.controller;

import com.zza.crud.Mapper.UserMapper;
import com.zza.crud.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class RegisterController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/user/register")
    public String toRegister(){
        return "register";
    }
    @RequestMapping(value = "/user/register.html")
    public String register(@RequestParam("username") String username, @RequestParam("pass") String password, @RequestParam("phnumber") String phnumber, @RequestParam("QQ") String QQ, Map<String,Object> map){
        User user=userMapper.loginUser(phnumber);
        if (!(user ==null)){
            map.put("msg","电话已注册");
            return "/user/register";
        }
        else{
            userMapper.register(username,password,phnumber,QQ);
            return "redirect:/";
        }
    }
}
