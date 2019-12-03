package com.zza.crud.controller;
import com.zza.crud.Mapper.UserMapper;
import com.zza.crud.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class LoginController {
    @Autowired
    UserMapper userMapper;
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("pass") String password, Map<String,Object> map, HttpSession session) {
        User user=userMapper.loginUser(username);
        if (user==null){
            map.put("msg","您尚未注册");
            return "Login";
        }
        else if (!user.getPassword().equals(password)){
            map.put("msg","密码错误");
            return "Login";
        }
        else  {
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";
        }
    }
}