package com.nttdata.yanki.management.sm.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document("payment")
public class PaymentMadeEvent {

  @Id
  private String paymentId;
  private String cellPhoneNumber;
  private BigDecimal amount;
  private String date = new DateTime().toDateTimeISO().toString();
}
