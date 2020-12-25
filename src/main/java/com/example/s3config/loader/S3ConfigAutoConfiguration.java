package com.example.s3config.loader;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration(proxyBeanMethods = false)
public class S3ConfigAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public S3ConfigProperties configClientProperties(Environment environment, ApplicationContext context) {
    if (context.getParent() != null && BeanFactoryUtils.beanNamesForTypeIncludingAncestors(context.getParent(),
        S3ConfigProperties.class).length > 0) {
      return BeanFactoryUtils.beanOfTypeIncludingAncestors(context.getParent(), S3ConfigProperties.class);
    }
    S3ConfigProperties client = new S3ConfigProperties(environment);
    return client;
  }


  @Configuration(proxyBeanMethods = false)
//  @ConditionalOnClass(ContextRefresher.class)
//  @ConditionalOnBean(ContextRefresher.class)
  protected static class ConfigClientWatchConfiguration {

    @Bean
    public S3ConfigWatch s3ConfigWatch(ContextRefresher contextRefresher) {
      return new S3ConfigWatch(contextRefresher);
    }

  }

}
