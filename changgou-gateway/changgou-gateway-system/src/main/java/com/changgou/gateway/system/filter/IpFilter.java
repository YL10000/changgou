package com.changgou.gateway.system.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;

/**
 * gateway网关，自定义ip过滤器
 *
 * @author yanglin
 * @version 1.0
 * @date 2020/8/14 10:38
 * @since 1.0
 */
@Component
@Slf4j
public class IpFilter implements GlobalFilter, Ordered {
  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    log.info("经过第{}个过滤器{}", getOrder(), this.getClass().getName());
    ServerHttpRequest request = exchange.getRequest();
    InetSocketAddress remoteAddress = request.getRemoteAddress();
    log.info("请求的ip地址为:{}", remoteAddress.getHostName());
    return chain.filter(exchange);
  }

  @Override
  public int getOrder() {
    return 1;
  }
}

