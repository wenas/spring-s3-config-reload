package com.example.s3config;

import com.example.s3config.loader.S3ConfigWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @Autowired S3ConfigWatch watch;

  @Value("${com.example.power}")
  private String power;

  @GetMapping
  public String getPower() {

    watch.watchConfigServer();
    return power;
  }
}
