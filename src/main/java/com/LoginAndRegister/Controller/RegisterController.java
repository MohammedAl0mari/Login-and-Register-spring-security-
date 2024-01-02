package com.LoginAndRegister.Controller;

import com.LoginAndRegister.Models.User;
import com.LoginAndRegister.Service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


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

    @PostMapping("/Register")
    public String addUser(@Valid @ModelAttribute("newUser") User user
                        , BindingResult bindingResult) {


        if(bindingResult.hasErrors())
            return "RegisterPage";

        if(!user.getPassword().equals(user.getRePassword())){
           bindingResult.rejectValue("rePassword","","Password Dose not match !!");
            return "RegisterPage";}

        boolean isEmailExist= (userRegisterService.getUser(user));
        if(!isEmailExist){
            bindingResult.rejectValue("email","","Already used!!");
            return "RegisterPage";}

        user.setActive(1);
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        userRegisterService.saveUser(user);
        return "redirect:/MyWebsite/main";
    }

}
