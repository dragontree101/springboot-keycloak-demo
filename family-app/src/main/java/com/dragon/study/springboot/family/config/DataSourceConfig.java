package com.dragon.study.springboot.family.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by dragon on 2017/1/30.
 */
@Configuration
public class DataSourceConfig {

  @Bean(name = "familyDataSource")
  @ConfigurationProperties(prefix="spring.datasource.family")
  public DataSource primaryDataSource() {
    return DataSourceBuilder.create().build();
  }
}
