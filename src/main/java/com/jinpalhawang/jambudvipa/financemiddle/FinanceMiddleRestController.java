package com.jinpalhawang.jambudvipa.financemiddle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class FinanceMiddleRestController {

  private static final Logger log = LoggerFactory.getLogger(FinanceMiddleRestController.class);

  @Value("${helloWorld}")
  private String helloWorld;

  @RequestMapping("/")
  public String helloWorld() {
    log.info(helloWorld);
    return helloWorld;
  }

}
