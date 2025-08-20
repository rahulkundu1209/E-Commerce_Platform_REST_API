package com.codewithmosh.store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithmosh.store.entities.Message;

@RestController
public class MessageController {
  @GetMapping("/hello")
  public Message sayHello(){
    System.out.println("Inside hello function");
    return new Message("Hello World", "Rahul Kundu");
  }
}
