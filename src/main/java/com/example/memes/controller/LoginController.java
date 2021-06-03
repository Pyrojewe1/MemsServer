package com.example.memes.controller;


import com.example.memes.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping(value = "/loginController")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping(value = "login")
    @ResponseBody
    public Long verifyUser(@RequestParam String username ,@RequestParam String password){
        return loginService.verifyUser(username,password);

    }

}
