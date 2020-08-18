package com.changgou.gateway.system.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * 网关配置类
 *
 * @author yanglin
 * @version 1.0
 * @date 2020/8/14 11:03
 * @since 1.0
 */
@Configuration
public class GatewayConfig {

  /**
   * 定义根据什么来进行限流
   */
  @Bean
  public KeyResolver hostKey() {
    return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
  }
}

