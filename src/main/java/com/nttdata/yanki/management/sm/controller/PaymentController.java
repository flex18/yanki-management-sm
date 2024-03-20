package com.nttdata.yanki.management.sm.controller;

import com.nttdata.yanki.management.sm.model.PaymentMadeEvent;
import com.nttdata.yanki.management.sm.service.impl.PaymentMadeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/send-payment")
public class PaymentController {

  @Autowired
  PaymentMadeServer paymentMadeServer;

  @PostMapping
  public Mono<PaymentMadeEvent> sendPayment(@RequestBody PaymentMadeEvent request){
    return paymentMadeServer.sendPayment(request);
  }
}
