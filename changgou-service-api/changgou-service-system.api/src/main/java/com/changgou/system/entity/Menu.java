package com.changgou.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * (TbMenu)实体类
 *
 * @author makejava
 * @since 2020-08-14 14:36:52
 */
@TableName("tb_menu")
@Data
public class Menu implements Serializable {
  /**
   * 图标
   */
  private String icon;
  /**
   * 菜单ID
   */
  @TableId(type = IdType.AUTO)
  private String id;
  /**
   * 菜单名称
   */
  private String name;
  /**
   * 上级菜单ID
   */
  private String parentId;
  /**
   * URL
   */
  private String url;
}