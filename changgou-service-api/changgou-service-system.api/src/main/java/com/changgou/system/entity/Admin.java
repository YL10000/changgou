package com.changgou.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * (TbAdmin)实体类
 *
 * @author makejava
 * @since 2020-08-14 14:36:52
 */
@TableName("tb_admin")
@Data
public class Admin implements Serializable {
  @TableId(type = IdType.AUTO)
  private Integer id;
  /**
   * 用户名
   */
  private String loginName;
  /**
   * 密码
   */
  private String password;
  /**
   * 状态
   */
  private String status;
}