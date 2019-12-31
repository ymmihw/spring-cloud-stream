package com.ymmihw.spring.cloud.stream.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import lombok.extern.slf4j.Slf4j;

@EnableBinding(Source.class)
@Slf4j
public class SendService {

  @Autowired
  private Source source;

  public void sendMessage(String msg) {
    log.debug("send message {}", msg);
    try {
      source.output().send(MessageBuilder.withPayload(msg).build());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
