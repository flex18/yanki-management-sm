package com.nttdata.yanki.management.sm.service.inter;

import com.nttdata.yanki.management.sm.model.UserRegisterEvent;
import reactor.core.publisher.Mono;

public interface UserRegisterInterface {
  Mono<UserRegisterEvent> saveUser(UserRegisterEvent request);
  Mono<UserRegisterEvent> findByIdUser(String id);
}
