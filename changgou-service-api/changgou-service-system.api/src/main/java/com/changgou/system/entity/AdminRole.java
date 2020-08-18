package com.changgou.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * (TbAdminRole)实体类
 *
 * @author makejava
 * @since 2020-08-14 14:36:52
 */
@Data
@TableName("tb_admin_role")
public class AdminRole implements Serializable {
  @TableId(type = IdType.AUTO)
  private Integer id;
  /**
   * 管理员ID
   */
  private Integer adminId;
  /**
   * 角色ID
   */
  private Integer roleId;
}