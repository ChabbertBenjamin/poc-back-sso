package com.example.pocbacksso.controller;

import com.example.pocbacksso.assembler.UserAssembler;
import com.example.pocbacksso.model.User;
import com.example.pocbacksso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping()

public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserAssembler userAssembler;

    @GetMapping("users")
    public List<User> getAllUsers(){
        /*Iterable<User> allUsers =*/
        return userRepository.findAll();
        /*System.out.println(ResponseEntity.ok(userAssembler.toCollectionModel(allUsers)));
        return ResponseEntity.ok(userAssembler.toCollectionModel(allUsers));*/
    }
    @RequestMapping(method=RequestMethod.OPTIONS)
    public void corsHeaders(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
        response.addHeader("Access-Control-Max-Age", "3600");
    }



    /*
    @GetMapping("users/{userId}")
    public void getOneUserById(@PathVariable String userId){
        userRepository.findById(userId);
    }*/


    @PostMapping("user")
    public void addUser(@RequestBody User user){
        userRepository.save(user);
    }

}
