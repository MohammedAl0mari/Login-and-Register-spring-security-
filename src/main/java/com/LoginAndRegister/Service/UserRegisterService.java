package com.LoginAndRegister.Service;


import com.LoginAndRegister.DAO.UserRepository;
import com.LoginAndRegister.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class UserRegisterService {
    @Autowired
    private UserRepository userRepository;
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }
    public boolean getUser(User user) {
        return userRepository.findByEmail(user.getEmail()) == null;
    }
}
