package com.changgou.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * dfs启动类
 *
 * @author yanglin
 * @version 1.0
 * @date 2020/8/13 14:17
 * @since 1.0
 */
//排除数据库自动配置类，避免加载数据相关信息
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
public class DFSApplication {
  public static void main(String[] args) {
    SpringApplication.run(DFSApplication.class, args);
  }
}

