package com.nttdata.yanki.management.sm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.yanki.management.sm.model.UserRegisterEvent;
import com.nttdata.yanki.management.sm.service.impl.UserRegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/register")
public class UserRegisterController {
  private final ObjectMapper json = new ObjectMapper();

  @Autowired
  UserRegisterService userRegisterService;

  @PostMapping
  public Mono<UserRegisterEvent> createUser(@RequestBody UserRegisterEvent request){
    try {
      log.info("*** The request for create a user is: " + json.writeValueAsString(request));
    } catch (JsonProcessingException e) {
      log.debug("** Error to convert json. Cause: " + e.getCause() + " -- Message: "
          + e.getMessage());
    }
    return userRegisterService.saveUser(request);
  }

  @GetMapping("/{id}")
  public Mono<UserRegisterEvent> findByUser(@PathVariable String id){
    return userRegisterService.findByIdUser(id);
  }
}
