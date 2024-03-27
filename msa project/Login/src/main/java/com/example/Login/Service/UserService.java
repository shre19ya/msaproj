package com.example.Login.Service;

import com.example.Login.DTO.LoginDTO;
import com.example.Login.DTO.UserDTO;
import com.example.Login.Entity.User;
import com.example.Login.payloadresponse.LoginMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    String addUser(UserDTO userDTO);

    LoginMessage loginUser(LoginDTO loginDTO);

    User getUserid(int userid);

    List getAllUser();
}
