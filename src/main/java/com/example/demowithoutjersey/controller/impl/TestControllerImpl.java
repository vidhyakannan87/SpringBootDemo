package com.example.demowithoutjersey.controller.impl;

import com.example.demowithoutjersey.controller.TestController;
import com.example.demowithoutjersey.controller.api.request.UserRequest;
import com.example.demowithoutjersey.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControllerImpl implements TestController {

  private final UserService userService;

  public TestControllerImpl(UserService userService) {
    this.userService = userService;
  }

  @Override
  public ResponseEntity demoWithOutJPA() {
    return ResponseEntity.ok("It Works");
  }

  @Override
  public ResponseEntity getAllUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

//  @Override
//  public ResponseEntity createNewUser() {
//     userService.addNewUser();
//    return ResponseEntity.ok().build();
//  }

  @Override
  public ResponseEntity createNewUserWithRequestBody(@RequestBody UserRequest userRequest) {
    userService.addNewUser(userRequest);
    return ResponseEntity.ok().build();

  }

  @Override
  public ResponseEntity getUserById(@PathVariable long id) {
    return ResponseEntity.ok(userService.getUserById(id));
  }

  @Override
  public ResponseEntity updateUser(@PathVariable long id, @RequestBody UserRequest userRequest) {
    return ResponseEntity.ok(userService.updateUser(id, userRequest));
  }

}
