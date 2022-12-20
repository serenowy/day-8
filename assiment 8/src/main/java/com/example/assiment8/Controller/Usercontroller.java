package com.example.assiment8.Controller;

import com.example.assiment8.Dto.Api;
import com.example.assiment8.Service.Userservice;
import com.example.assiment8.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class Usercontroller {
    private final Userservice userservice;

    @GetMapping("/get")
    public ResponseEntity getUser(){
        List<User> user= userservice.getUser();
        return ResponseEntity.status(200).body(user);
    }
    @PostMapping("/add")
    public ResponseEntity addUser( @RequestBody @Valid User user,  Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body (message);
        }
       userservice.addUser(user);
        return ResponseEntity.status(200).body (new Api("Add user"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable  Integer id,@Valid @RequestBody User user, Errors errors){
        if (errors.hasErrors()){

            return ResponseEntity.status(400).body (errors.getFieldError().getDefaultMessage());
        }
        userservice.updateUser(id,user);

        return ResponseEntity.status(200).body(new Api(" user Updated"));

    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser (@PathVariable  Integer id){
        userservice.deleteUser(id);
        return "user DELETED";}
    @GetMapping("/byi/{id}")
    public ResponseEntity  getUserById(@PathVariable Integer id )
    {
     User user = userservice.getUserById(id);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/gete")
    public ResponseEntity getUserByEmail(@RequestBody String email)
    {
        User user =userservice.getUserByEmail(email);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/getp/{pas}")
    public ResponseEntity getUserByUsernameAndPassword(@RequestBody String  username  , @PathVariable Integer password )
    {
        User user = userservice.getUserByUsernameAndPassword(username,password);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/getr")
    public ResponseEntity getAllByRole(@RequestBody String role)
    {
        List<User> user =userservice.getAllByRole(role);
        return ResponseEntity.status(200).body(user);

    }
    @GetMapping("/geta")
    public ResponseEntity getUsersByAge(@RequestBody Integer age )
    {
        List<User> user =userservice.getUsersByAge(age);
        return ResponseEntity.status(200).body(user);
    }
}

