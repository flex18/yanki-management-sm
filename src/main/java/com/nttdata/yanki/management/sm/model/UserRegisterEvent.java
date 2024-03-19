package com.nttdata.yanki.management.sm.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document("userRegisterEvent")
public class UserRegisterEvent {

  @Id
  private String userId;
  private String dni;
  private String cellPhoneNumber;
  private String imeiCellPhone;
  private String email;
}
