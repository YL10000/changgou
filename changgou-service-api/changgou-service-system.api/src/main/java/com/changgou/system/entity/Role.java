package com.changgou.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * (TbRole)实体类
 *
 * @author makejava
 * @since 2020-08-14 14:36:52
 */
@TableName("tb_role")
@Data
public class Role implements Serializable {
  /**
   * ID
   */
  @TableId(type = IdType.AUTO)
  private Integer id;
  /**
   * 角色名称
   */
  private String name;

}