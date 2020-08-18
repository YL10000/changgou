package com.changgou.goods.component;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 *
 * @author yanglin
 * @version 1.0
 * @date 2020/8/12 10:25
 * @since 1.0
 */
@RestControllerAdvice
public class BaseExceptionHandler {
  @ExceptionHandler(Exception.class)
  @ResponseBody
  public R handleException(Exception e) {
    return R.failed(e.getMessage());
  }
}

