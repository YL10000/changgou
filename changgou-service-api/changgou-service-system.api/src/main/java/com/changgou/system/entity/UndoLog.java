package com.changgou.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (UndoLog)实体类
 *
 * @author makejava
 * @since 2020-08-14 14:36:52
 */
@Data
@TableName("undo_log")
public class UndoLog implements Serializable {

  private Long branchId;
  private String ext;
  @TableId(type = IdType.AUTO)
  private Long id;
  private LocalDateTime logCreated;
  private LocalDateTime logModified;
  private Integer logStatus;
  private Object rollbackInfo;
  private String xid;
}