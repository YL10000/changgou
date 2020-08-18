package com.changgou.goods.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.changgou.goods.entity.Brand;

import java.util.List;
import java.util.Map;

/**
 * 品牌表(TbBrand)表服务接口
 *
 * @author makejava
 * @since 2020-08-12 09:55:48
 */
public interface BrandService extends IService<Brand> {

  /**
   * 按条件进行查询
   *
   * @param params
   * @return java.util.List<com.changgou.goods.entity.entity.Brand>
   * @author yanglin
   * @time 2020/8/12 15:05
   **/
  List<Brand> findList(Map<String, String> params);

  /**
   * 按条件进行分页查询
   *
   * @param page  当前页数
   * @param size  没有显示的条数
   * @param params  查询条件
   * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page
   * @author yanglin
   * @time 2020/8/12 15:40
   **/
  Page<Brand> pageList(int page, int size, Map<String, String[]> params);
}