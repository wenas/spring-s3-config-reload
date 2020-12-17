package com.example.s3config.loader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.config.ConfigData;
import org.springframework.boot.context.config.ConfigDataLoader;
import org.springframework.boot.context.config.ConfigDataLoaderContext;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.core.env.PropertySource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ConfigLoader implements ConfigDataLoader<TestConfigDataResource> {

    @Override
    public ConfigData load(ConfigDataLoaderContext context, TestConfigDataResource resource) throws IOException, ConfigDataResourceNotFoundException {

        log.info(context.toString());

        log.info(resource.toString());

        List<PropertySource<?>> composite = new ArrayList<>();

        return new ConfigData(composite);
    }
}
