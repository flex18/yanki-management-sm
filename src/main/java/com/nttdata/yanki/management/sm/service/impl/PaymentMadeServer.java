package com.nttdata.yanki.management.sm.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.yanki.management.sm.configuration.kafka.KafkaProperties;
import com.nttdata.yanki.management.sm.model.PaymentMadeEvent;
import com.nttdata.yanki.management.sm.repository.PaymentEventRepository;
import com.nttdata.yanki.management.sm.service.inter.PaymentInterface;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class PaymentMadeServer implements PaymentInterface {

  ObjectMapper json = new ObjectMapper();

  @Autowired
  PaymentEventRepository paymentEventRepository;

  @Autowired
  KafkaTemplate<String, PaymentMadeEvent> kafkaTemplate;

  @Autowired
  KafkaProperties kafkaProperties;


  @Override
  public Mono<PaymentMadeEvent> sendPayment(PaymentMadeEvent request) {
    String id = UUID.randomUUID().toString();
    request.setPaymentId(id);
    try {
      String paymentMsg = json.writeValueAsString(request);
      log.debug("*** The payment to insert is: [ {} ]", paymentMsg);
    } catch (JsonProcessingException j) {
      log.error("*** Error to convert message json. Cause: {} -- Message: {}", j.getCause(), j.getMessage());
    }
    sendToKafka(request);
    return paymentEventRepository.save(request);
  }

  private void sendToKafka(PaymentMadeEvent pay){
    Message<PaymentMadeEvent> message = MessageBuilder
        .withPayload(pay)
        .setHeader(KafkaHeaders.TOPIC, kafkaProperties.getTopicYanki())
        .build();
    kafkaTemplate.send(message);
  }
}
