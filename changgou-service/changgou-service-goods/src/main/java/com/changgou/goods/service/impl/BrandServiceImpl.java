package com.changgou.goods.service.impl;


import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.changgou.goods.dao.BrandDao;
import com.changgou.goods.entity.Brand;
import com.changgou.goods.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 品牌表(TbBrand)表服务实现类
 *
 * @author makejava
 * @since 2020-08-12 09:55:48
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandDao, Brand> implements BrandService {


  @Override
  public List<Brand> findList(Map<String, String> params) {
    if (CollUtil.isEmpty(params)) return null;
    LambdaQueryChainWrapper<Brand> queryChainWrapper = this.lambdaQuery();
    Optional.ofNullable(params.get("name")).ifPresent(name -> {
      queryChainWrapper.like(Brand::getName, name);
    });
    Optional.ofNullable(params.get("letter")).ifPresent(letter -> {
      queryChainWrapper.eq(Brand::getLetter, letter);
    });
    return queryChainWrapper.list();
  }

  @Override
  public Page<Brand> pageList(int page, int size, Map<String, String[]> params) {
    Page<Brand> brandPage = new Page<>(page,size);
    LambdaQueryChainWrapper<Brand> queryChainWrapper = this.lambdaQuery();
    if (CollUtil.isEmpty(params)) {
      return queryChainWrapper.page(brandPage);
    }
    Optional.ofNullable(params.get("name")).ifPresent(names -> {
      queryChainWrapper.like(Brand::getName, names[0]);
    });
    Optional.ofNullable(params.get("letter")).ifPresent(letters -> {
      queryChainWrapper.in(Brand::getLetter, letters);
    });
    return queryChainWrapper.page(brandPage);
  }
}