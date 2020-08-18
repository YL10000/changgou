package com.changgou.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * (TbRoleMenu)实体类
 *
 * @author makejava
 * @since 2020-08-14 14:36:52
 */
@TableName("tb_role_menu")
@Data
public class RoleMenu implements Serializable {
  @TableId(type = IdType.AUTO)
  private Integer id;
  private String menuId;
  private Integer roleId;
}