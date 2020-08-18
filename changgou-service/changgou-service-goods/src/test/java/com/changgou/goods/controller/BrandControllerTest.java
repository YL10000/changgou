package com.changgou.goods.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.changgou.goods.entity.Brand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * brand controller测试类
 *
 * @author yanglin
 * @version 1.0
 * @date 2020/8/12 13:47
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BrandControllerTest {

  @Autowired
  private BrandController brandController;

  @Test
  public void findAll() {
    R<List<Brand>> brands = brandController.selectList(null);
    System.out.println(brands);
  }

  @Test
  public void pageList() {
    R<Page<Brand>> pageList = brandController.pageList(1, 10, null);
    System.out.println(pageList);
  }
}

