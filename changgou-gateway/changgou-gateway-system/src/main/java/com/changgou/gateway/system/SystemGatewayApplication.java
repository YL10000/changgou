package com.changgou.gateway.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 后台微服务网关
 *
 * @author yanglin
 * @version 1.0
 * @date 2020/8/14 10:15
 * @since 1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
public class SystemGatewayApplication {
  public static void main(String[] args) {
    SpringApplication.run(SystemGatewayApplication.class,args);
  }
}

