package com.camunda.bpm.getstarted.ucvrms;

import com.alibaba.druid.pool.DruidDataSource;
import org.camunda.bpm.engine.spring.ProcessEngineFactoryBean;
import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.camunda.bpm.engine.spring.SpringProcessEngineServicesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * <p>spring配置信息
 *
 * @author 杨玉龙, yulong.yang@ucarinc.com
 * @version 1.0
 * @since 2019/3/28
 */
@Configuration
@AutoConfigureBefore(SpringProcessEngineServicesConfiguration.class)
public class ExampleProcessEngineConfiguration {

  @Bean
  public DataSource dataSource() {
    // Use a JNDI data source or read the properties from
    // env or a properties file.
    // Note: The following shows only a simple data source
    // for In-Memory H2 database.

    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/camunda?autoReconnect=true&serverTimezone=UTC&characterEncoding=utf-8");
    dataSource.setUsername("camunda");
    dataSource.setPassword("123456");
    return dataSource;
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    return new DataSourceTransactionManager(dataSource());
  }

  @Bean
  public SpringProcessEngineConfiguration processEngineConfiguration() {
    SpringProcessEngineConfiguration config = new SpringProcessEngineConfiguration();

    config.setDataSource(dataSource());
    config.setTransactionManager(transactionManager());

    config.setDatabaseSchemaUpdate("true");
    config.setHistory("audit");
    config.setJobExecutorActivate(true);

    return config;
  }

  @Bean
  public ProcessEngineFactoryBean processEngine() {
    ProcessEngineFactoryBean factoryBean = new ProcessEngineFactoryBean();
    factoryBean.setProcessEngineConfiguration(processEngineConfiguration());
    return factoryBean;
  }

}
