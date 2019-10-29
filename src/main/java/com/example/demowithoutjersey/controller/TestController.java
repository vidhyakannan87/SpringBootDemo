package com.example.demowithoutjersey.controller;

import com.example.demowithoutjersey.controller.api.request.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/test")
public interface TestController {

  @GetMapping("/demo")
  ResponseEntity demoWithOutJPA();

  @GetMapping("")
  ResponseEntity getAllUsers();

//  @PostMapping("")
//  ResponseEntity createNewUser();


  @PostMapping("")
  ResponseEntity createNewUserWithRequestBody(@RequestBody UserRequest userRequest);

  @GetMapping("/{id}")
  ResponseEntity getUserById(@PathVariable long id);

  @PatchMapping("/{id}")
  ResponseEntity updateUser(@PathVariable long id, @RequestBody UserRequest userRequest);


}
