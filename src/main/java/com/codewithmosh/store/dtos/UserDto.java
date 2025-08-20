package com.codewithmosh.store.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {
  private long id;
  private String name;
  private String email;
  // @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
  // private LocalDateTime createdAt;
}
