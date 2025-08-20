package com.codewithmosh.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
  @RequestMapping("/")
  // public String index(){
  //   System.out.println("inside home controller");
  //   return "index.html";
  // }
  public String index(Model model){
    System.out.println("inside home controller");
    model.addAttribute("name", "Rahul");
    return "index";
  }
}
