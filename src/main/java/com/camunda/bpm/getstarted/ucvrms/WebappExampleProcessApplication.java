package com.camunda.bpm.getstarted.ucvrms;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

    public static void main(String[] args) {
        SpringApplication.run(WebappExampleProcessApplication.class, args);
    }
}
