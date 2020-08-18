package com.changgou.common.entity;

import lombok.*;

import java.io.Serializable;

/**
 * 描述
 *
 * @author 三国的包子
 * @version 1.0
 * @package entity *
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Result<T> implements Serializable {
  @NonNull
  private Integer code;//返回码
  private T data;//返回数据
  @NonNull
  private boolean flag;//是否成功
  @NonNull
  private String message;//返回消息
}

