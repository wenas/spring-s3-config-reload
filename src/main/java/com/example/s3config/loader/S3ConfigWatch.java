package com.example.s3config.loader;

import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicBoolean;

public class S3ConfigWatch implements EnvironmentAware {

  private final AtomicBoolean running = new AtomicBoolean(false);
  private final ContextRefresher refresher;
  private Environment environment;

  public S3ConfigWatch(ContextRefresher refresher) {
    this.refresher = refresher;
  }

  @Override public void setEnvironment(Environment environment) {
    
    this.environment = environment;
  }

  @PostConstruct
  public void start() {
    this.running.compareAndSet(false, true);
  }

  @Scheduled(initialDelayString = "180000",
      fixedDelayString = "500")
  public void watchConfigServer() {
    if (this.running.get()) {
//      String newState = this.environment.getProperty("config.client.state");
//      String oldState = ConfigClientStateHolder.getState();

      // only refresh if state has changed
//      if (stateChanged(oldState, newState)) {
//        ConfigClientStateHolder.setState(newState);
        this.refresher.refresh();
//      }
    }
  }

}
