package com.ymmihw.spring.cloud.stream.consumer;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import lombok.extern.slf4j.Slf4j;

@EnableBinding(Sink.class)
@Slf4j
@SpringBootApplication
public class Consumer {

  @StreamListener(Sink.INPUT)
  public void process(Message<?> message) {

    log.debug("receive message {}", message.getPayload());
    Acknowledgment acknowledgment =
        message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
    if (acknowledgment != null) {
      log.debug("Acknowledgment provided");
      acknowledgment.acknowledge();
    }
  }

  public static void main(String[] args) {
    new SpringApplicationBuilder(Consumer.class).web(WebApplicationType.NONE).run(args);
  }
}
