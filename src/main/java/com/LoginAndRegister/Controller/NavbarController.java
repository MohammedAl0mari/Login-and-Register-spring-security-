package com.LoginAndRegister.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/MyWebsite")
public class NavbarController {
    @GetMapping("/profile")
    public String profile(){
        return "profile/index";
    }
    @GetMapping("/admin")
    public String Admin(){
        return "admin/index";
    }
    @GetMapping("/management")
    public String Manage(){
        return "management/index";
    }
}
