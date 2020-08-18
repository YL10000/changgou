package com.changgou.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * 分页结果类
 */
@Data
@AllArgsConstructor
public class PageResult<T> {

  private List<T> rows;//记录
  private Long total;//总记录数
}


