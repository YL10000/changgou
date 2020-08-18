package com.changgou.goods.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.changgou.goods.entity.Brand;
import org.apache.ibatis.annotations.Mapper;

/**
 * 品牌表(TbBrand)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-12 09:49:50
 */
@Mapper
public interface BrandDao extends BaseMapper<Brand> {

}