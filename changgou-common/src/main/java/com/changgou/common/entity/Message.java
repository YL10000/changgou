package com.changgou.common.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/*****
 * @Author: www.itheima.com
 * @Description: entity:MQ消息封装
 ****/
@Data
public class Message implements Serializable{

  //执行的操作  1：增加，2：修改,3：删除
  private int code;

  //数据
  private Object content;

  //发送的routkey
  @JSONField(serialize = false)
  private String routekey;

  //交换机
  @JSONField(serialize = false)
  private String exechange;

  public Message() {
  }

  public Message(int code, Object content) {
    this();
    this.code = code;
    this.content = content;
  }

  public Message(int code, Object content, String routekey, String exechange) {
    this(code,content);
    this.routekey = routekey;
    this.exechange = exechange;
  }


}

