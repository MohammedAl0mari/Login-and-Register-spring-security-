package com.LoginAndRegister.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/MyWebsite")
public class mainController {
    @GetMapping("/main")
    public String index(){
        return "HomePage";
    }
    /*@GetMapping("/test")
    public String first(){
        return "HomePage";
    }*/
    @GetMapping("/login")
    public String login(){
        return "LoginPage";
    }
    @GetMapping("/signup")
    public String sign(){
        return "RegisterPage";
    }
}
