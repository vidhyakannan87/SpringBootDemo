package com.example.demowithoutjersey.controller.api.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {

  private long id;

  private String name;

  private String email;

}
