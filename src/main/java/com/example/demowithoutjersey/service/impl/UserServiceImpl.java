package com.example.demowithoutjersey.service.impl;

import com.example.demowithoutjersey.controller.api.request.UserRequest;
import com.example.demowithoutjersey.model.User;
import com.example.demowithoutjersey.repository.UserRepository;
import com.example.demowithoutjersey.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  private final ModelMapper modelMapper = new ModelMapper();

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }


  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public void addNewUser() {
    User user = new User();

    user.setEmail("testdemo@test.com");
    user.setId(1004);
    user.setName("Demo");

    userRepository.saveAndFlush(user);


  }

  @Override
  public void addNewUser(UserRequest userRequest) {

    User user = modelMapper.map(userRequest, User.class);
    userRepository.saveAndFlush(user);


  }

  @Override
  public User getUserById(long id) {
    Optional<User> user = userRepository.findById(id);
    if (user.isPresent()) {
      return user.get();
    }

    throw new BadRequestException("User not found");

  }

  @Override
  public User updateUser(long id, UserRequest userRequest) {
    User oldUser = getUserById(id);

    if(!oldUser.getEmail().equalsIgnoreCase(userRequest.getEmail())){

      oldUser.setEmail(userRequest.getEmail());
    }

    if(!oldUser.getName().equals(userRequest.getName())){
      oldUser.setName(userRequest.getName());
    }

    userRepository.saveAndFlush(oldUser);

    return oldUser;


  }
}
