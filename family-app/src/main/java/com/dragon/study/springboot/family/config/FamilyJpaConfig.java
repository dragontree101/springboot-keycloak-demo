package com.dragon.study.springboot.family.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by dragon on 2017/1/30.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef="entityManagerFactoryPrimary",
    transactionManagerRef="transactionManagerPrimary",
    basePackages= { "com.dragon.study.springboot.family" }) //设置Repository所在位置
public class FamilyJpaConfig {

  @Resource(name = "familyDataSource")
  private DataSource dataSource;

  @Bean
  public EntityManagerFactory entityManagerFactoryPrimary() {
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setJpaVendorAdapter(vendorAdapter);
    factory.setPackagesToScan("com.dragon.study.springboot.family.module");
    factory.setDataSource(dataSource);
    Properties p = new Properties();
    p.setProperty("hibernate.physical_naming_strategy", "com.dragon.study.springboot.family.hibernate.PhysicalNamingStrategyImpl");
    p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
    p.setProperty("hibernate.show_sql", "true");
    factory.setJpaProperties(p);
    factory.afterPropertiesSet();

    return factory.getObject();
  }

  @Bean
  public PlatformTransactionManager transactionManagerPrimary(
      EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager txManager = new JpaTransactionManager();
    txManager.setEntityManagerFactory(entityManagerFactory);
    return txManager;
  }
}
