package com.example.s3config.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties
public class S3ConfigBootstrapConfiguration {

  @Autowired
  private ConfigurableEnvironment environment;

  @Bean
  @ConditionalOnMissingBean
  public S3ConfigProperties s3ConfigProperties(ConfigurableEnvironment environment) {
    return new S3ConfigProperties(environment);
  }



}
