package com.nttdata.yanki.management.sm.repository;

import com.nttdata.yanki.management.sm.model.UserRegisterEvent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRegisterRepository extends ReactiveMongoRepository<UserRegisterEvent, String> {
}
