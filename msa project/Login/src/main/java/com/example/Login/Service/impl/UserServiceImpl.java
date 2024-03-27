package com.example.Login.Service.impl;

import com.example.Login.DTO.LoginDTO;
import com.example.Login.DTO.UserDTO;
import com.example.Login.Entity.User;
import com.example.Login.Repo.UserRepo;
import com.example.Login.Service.UserService;
import com.example.Login.exceptions.ResourceNotFoundException;
import com.example.Login.payloadresponse.LoginMessage;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.query.Order;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getUserid(),
                userDTO.getName(),
                this.passwordEncoder.encode(userDTO.getPassword())
        );
        userRepo.save(user);
        return user.getName();
    }

    @Override
    public LoginMessage loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = userRepo.findByName(loginDTO.getName());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByNameAndPassword(loginDTO.getName(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("password Not Match", false);
            }
        }else {
            return new LoginMessage("name not exits", false);
        }
    }

    @Override
    public User getUserid(int userid) {
        User user = userRepo.findById(userid).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        return user;
    }

    @Override
    public List getAllUser() {
        List users = new ArrayList();
        userRepo.findAll().forEach(user -> users.add(user));
        return users;
    }
}
