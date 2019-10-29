package com.example.demowithoutjersey.service;

import com.example.demowithoutjersey.controller.api.request.UserRequest;
import com.example.demowithoutjersey.model.User;

import java.util.List;

public interface UserService {
  List<User>  getAllUsers();

  void addNewUser();

  void addNewUser(UserRequest userRequest);

  User getUserById(long id);

  User updateUser(long id,UserRequest userRequest);

}
