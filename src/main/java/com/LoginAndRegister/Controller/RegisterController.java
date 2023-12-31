package com.LoginAndRegister.Controller;

import com.LoginAndRegister.Models.User;
import com.LoginAndRegister.Service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/MyWebsite")
public class RegisterController {

    @Autowired
    private UserRegisterService userRegisterService;

    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @GetMapping("/Register")
    public String savePage(Model model) {
        model.addAttribute("newUser",new User());
        return "RegisterPage";
    }

    @PostMapping("/saveUser")
    public String addUser(@ModelAttribute("newUser") User user) {
        user.setActive(1);
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        userRegisterService.saveUser(user);
        return "redirect:/MyWebsite/main";
    }

}
