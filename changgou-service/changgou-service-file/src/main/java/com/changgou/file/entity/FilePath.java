package com.changgou.file.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * dfs file path对象
 *
 * @author yanglin
 * @version 1.0
 * @date 2020/8/13 14:57
 * @since 1.0
 */
@Data
@AllArgsConstructor
public class FilePath {

  private String group;

  private String remotePath;
}

