package com.nttdata.yanki.management.sm.configuration.kafka;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@EnableConfigurationProperties
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "messagingyanki")
public class KafkaProperties {

  private String urlKafkaServer;
  private String topicYanki;
}
