package com.LoginAndRegister.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/MyWebsite")
public class mainController {
    @GetMapping("/home")
    public String index(){
        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return "LoginPage";
    }
    @GetMapping("/signup")
    public String sign(){
        return "RegisterPage";
    }

    
}
