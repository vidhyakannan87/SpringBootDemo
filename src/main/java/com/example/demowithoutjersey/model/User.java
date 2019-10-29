package com.example.demowithoutjersey.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name="\"user\"")
public class User {

  @Id
  private long id;

  @NotNull
  private String name;

  @Column(unique = true)
  @NotNull
  private String email;


}
