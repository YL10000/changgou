package com.changgou.gateway.system.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义gateway url过滤器
 *
 * @author yanglin
 * @version 1.0
 * @date 2020/8/14 10:43
 * @since 1.0
 */
@Slf4j
@Component
public class UrlFilter implements GlobalFilter, Ordered {
  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    log.info("经过第{}个过滤器{}", getOrder(), this.getClass().getName());
    ServerHttpRequest request = exchange.getRequest();
    String path = request.getURI().getPath();
    log.info("请求url为:{}", path);
    return chain.filter(exchange);
  }

  @Override
  public int getOrder() {
    return 2;
  }
}

