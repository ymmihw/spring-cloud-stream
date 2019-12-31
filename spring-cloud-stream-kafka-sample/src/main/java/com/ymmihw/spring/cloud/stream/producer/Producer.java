package com.ymmihw.spring.cloud.stream.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Producer {

  @Autowired
  private SendService service;

  @RequestMapping(value = "/send/{msg}", method = RequestMethod.GET)
  public void send(@PathVariable("msg") String msg) {
    service.sendMessage(msg);
  }

  public static void main(String[] args) {
    SpringApplication.run(Producer.class, args);
  }
}
