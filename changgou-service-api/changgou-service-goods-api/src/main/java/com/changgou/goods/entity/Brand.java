package com.changgou.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 品牌表(TbBrand)实体类
 *
 * @author makejava
 * @since 2020-08-12 09:44:14
 */
@Data
@TableName("tb_brand")
public class Brand implements Serializable {
  private static final long serialVersionUID = -18762692469991124L;
  /**
   * 品牌id
   */
  @TableId(type = IdType.AUTO)
  private Integer id;
  /**
   * 品牌图片地址
   */
  private String image;
  /**
   * 品牌的首字母
   */
  private String letter;
  /**
   * 品牌名称
   */
  private String name;
  /**
   * 排序
   */
  private Integer seq;
}