package com.changgou.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 商品微服务启动类
 *
 * @author yanglin
 * @version 1.0
 * @date 2020/8/12 10:29
 * @since 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@CrossOrigin
public class GoodsApplication {
  public static void main(String[] args) {
    SpringApplication.run(GoodsApplication.class,args);
  }
}

