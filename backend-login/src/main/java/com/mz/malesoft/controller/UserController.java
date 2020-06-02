package com.mz.malesoft.controller;


import com.mz.malesoft.model.Role;
import com.mz.malesoft.model.User;
import com.mz.malesoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@CrossOrigin(origins = { "http://localhost:4000", "http://localhost:4200", "http://localhost:8081" })
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private Environment env;


    @PostMapping("/service/registration")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        if(userService.findByUsername(user.getUsername()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(Role.USER);
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/service/login")
    public ResponseEntity<?> getUser(Principal principal){
        if(principal == null || principal.getName() == null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
      //  return ResponseEntity.ok(userService.findByUsername(principal.getName()));
    }

    @PostMapping("/service/names")
    public ResponseEntity<?> getNamesOfUsers(@RequestBody List<Long> idList){
        return ResponseEntity.ok(userService.findUsers(idList));
    }

    @GetMapping("/service/test")
    public ResponseEntity<?> test(){
        return ResponseEntity.ok("It is working...");
    }

}
