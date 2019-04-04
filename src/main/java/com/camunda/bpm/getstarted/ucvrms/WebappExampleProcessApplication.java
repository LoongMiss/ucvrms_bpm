package com.camunda.bpm.getstarted.ucvrms;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

/**
 * <p>camunda 启动类
 *
 * @author 杨玉龙, yulong.yang@ucarinc.com
 * @version 1.0
 * @since 2019/3/26
 */

@SpringBootApplication
@EnableProcessApplication
public class WebappExampleProcessApplication {

  @Autowired
  private RuntimeService runtimeService;

  public static void main(String[] args) {
    SpringApplication.run(WebappExampleProcessApplication.class, args);
  }

  @EventListener
  private void processPostDeploy(PostDeployEvent event) {

    runtimeService.startProcessInstanceByKey("loanApproval");
  }
}
