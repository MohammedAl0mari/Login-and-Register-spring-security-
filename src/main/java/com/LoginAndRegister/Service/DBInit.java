package com.LoginAndRegister.Service;

import com.LoginAndRegister.DAO.RolesRepository;
import com.LoginAndRegister.DAO.UserRepository;
import com.LoginAndRegister.Models.Role;
import com.LoginAndRegister.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DBInit implements CommandLineRunner {
    private UserRepository userRepository;
    private RolesRepository rolesRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public DBInit(UserRepository userRepository, RolesRepository authoritiesRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.rolesRepository = authoritiesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        rolesRepository.deleteAll();
        Role roleAdmin = new Role("ROLE_ADMIN");
        rolesRepository.save(roleAdmin);
        Role roleUser = new Role("ROLE_USER");
        rolesRepository.save(roleUser);
        User admin = new User("admin",passwordEncoder.encode("admin"),"admin@admin.com",1);
        admin.setRoles(this.rolesRepository.findAll());
        userRepository.save(admin);
        /////////////////////////////////////////////////////////////////////////
        User user = new User("user",passwordEncoder.encode("user"),"user@user.com",1);
        userRepository.save(user);

    }
}
