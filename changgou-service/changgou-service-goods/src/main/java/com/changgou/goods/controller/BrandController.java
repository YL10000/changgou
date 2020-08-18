package com.changgou.goods.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.changgou.goods.entity.Brand;
import com.changgou.goods.service.BrandService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 品牌表(Brand)表控制层
 *
 * @author yanglin
 * @since 2020-08-14 16:31:16
 */
@RestController
@RequestMapping("brand")
public class BrandController extends ApiController {
  /**
   * 服务对象
   */
  @Resource
  private BrandService brandService;

  /**
   * 通过主键删除单条数据
   *
   * @param id 主键
   * @return 单条数据
   */
  @DeleteMapping("{id}")
  public R delete(@PathVariable Serializable id) {
    return success(this.brandService.removeById(id));
  }

  /**
   * 删除数据
   *
   * @param idList 主键结合
   * @return 删除结果
   */
  @DeleteMapping
  public R delete(@RequestParam("idList") List<Long> idList) {
    return success(this.brandService.removeByIds(idList));
  }

  /**
   * 通过主键查询单条数据
   *
   * @param id 主键
   * @return 单条数据
   */
  @GetMapping("{id}")
  public R<Brand> findById(@PathVariable Serializable id) {
    return success(this.brandService.getById(id));
  }

  /**
   * 新增数据
   *
   * @param brand 实体对象
   * @return 新增结果
   */
  @PostMapping
  public R insert(@RequestBody Brand brand) {
    return success(this.brandService.save(brand));
  }

  /**
   * 分页查询所有数据
   *
   * @param page     分页对象
   * @return 所有数据
   */
  @GetMapping("/page/{page}/{size}")
  public R<Page<Brand>> pageList(@PathVariable("page") int page, @PathVariable("size") int size, HttpServletRequest request) {
    Map<String, String[]> keywords = request.getParameterMap();
    return success(this.brandService.pageList(page, size, keywords));
  }

  /**
   * 查询所有数据
   *
   * @param brand 查询实体
   * @return 所有数据
   */
  @GetMapping
  public R<List<Brand>> selectList(Brand brand) {
    return success(this.brandService.list(new QueryWrapper<>(brand)));
  }

  /**
   * 修改数据
   *
   * @param brand 实体对象
   * @return 修改结果
   */
  @PutMapping
  public R update(@RequestBody Brand brand) {
    return success(this.brandService.updateById(brand));
  }
}