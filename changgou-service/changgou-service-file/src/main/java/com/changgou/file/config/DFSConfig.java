package com.changgou.file.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * dfs配置类
 *
 * @author yanglin
 * @version 1.0
 * @date 2020/8/13 11:34
 * @since 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "dfs")
@Data
public class DFSConfig {
  String charset;
  Integer connectTimeout;
  Integer networkTimeout;
  Integer trackerHttpPort;
  String[] trackerServer;
}

