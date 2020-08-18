package com.changgou.gateway.system.filter;

import cn.hutool.core.util.StrUtil;
import com.changgou.gateway.system.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 鉴权过滤器，用于验证token
 *
 * @author yanglin
 * @version 1.0
 * @date 2020/8/17 17:40
 * @since 1.0
 */
@Component
@Slf4j
public class AuthorizeFilter implements GlobalFilter, Ordered {
  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    /**
     * 1、如果是登录请求，直接放行
     * 1、获取请求头中token信息
     * 2、验证token
     */
    log.info("请求路径为：{}", exchange.getRequest().getURI().getPath());
    //如果是登录请求，直接放行
    if (exchange.getRequest().getURI().getPath().contains("admin/login")) return chain.filter(exchange);

    ServerHttpResponse response = exchange.getResponse();
    //获取token
    String token = exchange.getRequest().getHeaders().getFirst("token");
    if (StrUtil.isEmpty(token)) {
      response.setStatusCode(HttpStatus.UNAUTHORIZED);
      return response.setComplete();
    }

    //解析token
    try {
      JwtUtil.parseJWT(token);
    } catch (Exception e) {
      //token过期或者不正确
      log.error("解析token失败,{}", e.getMessage());
      response.setStatusCode(HttpStatus.UNAUTHORIZED);
      return response.setComplete();
    }
    return chain.filter(exchange);
  }

  @Override
  public int getOrder() {
    return 0;
  }
}

