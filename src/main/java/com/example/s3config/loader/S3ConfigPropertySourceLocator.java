package com.example.s3config.loader;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class S3ConfigPropertySourceLocator implements PropertySourceLocator {

  private S3ConfigProperties s3ConfigProperties;
  public S3ConfigPropertySourceLocator(S3ConfigProperties S3ConfigProperties) {
    this.s3ConfigProperties = S3ConfigProperties;
  }

  @Override public org.springframework.core.env.PropertySource<?> locate(Environment environment) {
    HashMap<String, Object> propMap = new HashMap<>();
    propMap.put("com.example.power", System.currentTimeMillis());

    MapPropertySource propertySource =
        new MapPropertySource("s3-config", propMap);

    return propertySource;
  }
}
