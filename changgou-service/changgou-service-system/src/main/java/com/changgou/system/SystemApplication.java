package com.changgou.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 后台管理微服务启动类
 *
 * @author yanglin
 * @version 1.0
 * @date 2020/8/14 14:53
 * @since 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@CrossOrigin
public class SystemApplication {
  public static void main(String[] args) {
    SpringApplication.run(SystemApplication.class, args);
  }
}

