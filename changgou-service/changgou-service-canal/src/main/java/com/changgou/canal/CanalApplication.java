package com.changgou.canal;

import com.xpand.starter.canal.annotation.EnableCanalClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * canal启动类
 *
 * @author yanglin
 * @version 1.0
 * @date 2020/8/20 13:38
 * @since 1.0
 */
@SpringBootApplication
@EnableCanalClient
@EnableEurekaClient
public class CanalApplication {
  public static void main(String[] args) {
    SpringApplication.run(CanalApplication.class,args);
  }
}

