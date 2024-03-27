package com.example.Login.Controller;
import com.example.Login.DTO.LoginDTO;
import com.example.Login.DTO.UserDTO;
import com.example.Login.Entity.User;
import com.example.Login.Service.UserService;
import com.example.Login.payloadresponse.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/login")
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/ms1")
    String display1()
    {
        return restTemplate.getForObject("http://localhost:8083/orders/hello", String.class);
    }
    @GetMapping("/all")
    private List getAllUser()
    {
        return service.getAllUser();
    }

    @GetMapping("/{userid}")
    public ResponseEntity<User> getSingleUser(@PathVariable int userid) {
        User user = service.getUserid(userid);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/orders/{userid}")
    public ArrayList getOrder(@PathVariable int userid){
        return restTemplate.getForObject("http://localhost:8083/login/orders/1", ArrayList.class);
    }

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDTO userDTO)
    {
        String id = service.addUser(userDTO);
        return id;
    }

    @PostMapping(path = "/enter")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
    {
        LoginMessage loginMessage = service.loginUser(loginDTO);
        return ResponseEntity.ok(loginMessage);
    }

}
