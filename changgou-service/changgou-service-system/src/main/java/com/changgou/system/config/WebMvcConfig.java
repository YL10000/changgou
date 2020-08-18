package com.changgou.system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * mvc配置类
 *
 * @author yanglin
 * @version 1.0
 * @date 2020/8/12 17:49
 * @since 1.0
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**").addResourceLocations(
        "classpath:/static/");
    registry.addResourceHandler("doc.html").addResourceLocations(
        "classpath:/META-INF/resources/");
    registry.addResourceHandler("/webjars/**").addResourceLocations(
        "classpath:/META-INF/resources/webjars/");
    super.addResourceHandlers(registry);
  }

  @Override
  protected void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**").
        //允许跨域的域名，可以用*表示允许任何域名使用
            allowedOrigins("*").
        //允许任何方法（post、get等）
            allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS").
        //允许任何请求头
            allowedHeaders("*").
        //带上cookie信息
            allowCredentials(true).
        exposedHeaders(HttpHeaders.SET_COOKIE).
        //maxAge(3600)表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
            maxAge(3600L);
  }
}

