package com.nttdata.yanki.management.sm.service.inter;

import com.nttdata.yanki.management.sm.model.PaymentMadeEvent;
import reactor.core.publisher.Mono;

public interface PaymentInterface {
  Mono<PaymentMadeEvent> sendPayment(PaymentMadeEvent request);
}
