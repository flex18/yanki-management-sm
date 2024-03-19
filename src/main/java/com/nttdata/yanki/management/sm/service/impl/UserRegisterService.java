package com.nttdata.yanki.management.sm.service.impl;

import com.nttdata.yanki.management.sm.model.UserRegisterEvent;
import com.nttdata.yanki.management.sm.repository.UserRegisterRepository;
import com.nttdata.yanki.management.sm.service.inter.UserRegisterInterface;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserRegisterService implements UserRegisterInterface {

  @Autowired
  UserRegisterRepository userRegisterRepository;

  @Override
  public Mono<UserRegisterEvent> saveUser(UserRegisterEvent request) {
    String id = UUID.randomUUID().toString();
    request.setUserId(id);
    return userRegisterRepository.save(request);
  }

  @Override
  public Mono<UserRegisterEvent> findByIdUser(String id) {
    return userRegisterRepository.findById(id);
  }
}
