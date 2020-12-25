package com.example.s3config.loader;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;

@ConfigurationProperties(S3ConfigProperties.PREFIX)
public class S3ConfigProperties {
  /** プレフィックス */
  public static final String PREFIX = "com.example.s3config";
  private final Environment environment;

  public S3ConfigProperties(Environment environment) {
    this.environment = environment;
  }
}
