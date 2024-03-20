package com.nttdata.yanki.management.sm.repository;

import com.nttdata.yanki.management.sm.model.PaymentMadeEvent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PaymentEventRepository extends ReactiveMongoRepository<PaymentMadeEvent, String> {
}
