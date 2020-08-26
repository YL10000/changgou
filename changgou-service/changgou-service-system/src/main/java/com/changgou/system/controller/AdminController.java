package com.changgou.system.controller;


import cn.hutool.core.lang.UUID;
import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.changgou.system.entity.Admin;
import com.changgou.system.service.AdminService;
import com.changgou.system.util.JwtUtil;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Admin)表控制层
 *
 * @author yanglin
 * @since 2020-08-14 17:21:47
 */
@RestController
@RequestMapping("admin")
public class AdminController extends ApiController {
  /**
   * 服务对象
   */
  @Resource
  private AdminService adminService;

  /**
   * 通过主键删除单条数据
   *
   * @param id 主键
   * @return 单条数据
   */
  @DeleteMapping("{id}")
  public R delete(@PathVariable Serializable id) {
    return success(this.adminService.removeById(id));
  }

  /**
   * 删除数据
   *
   * @param idList 主键结合
   * @return 删除结果
   */
  @DeleteMapping
  public R delete(@RequestParam("idList") List<Long> idList) {
    return success(this.adminService.removeByIds(idList));
  }

  /**
   * 通过主键查询单条数据
   *
   * @param id 主键
   * @return 单条数据
   */
  @GetMapping("{id}")
  public R<Admin> findById(@PathVariable Serializable id) {
    return success(this.adminService.getById(id));
  }

  /**
   * 新增数据
   *
   * @param admin 实体对象
   * @return 新增结果
   */
  @PostMapping
  public R insert(@RequestBody Admin admin) {
    //使用随机盐对密码进行加密
    admin.setPassword(BCrypt.hashpw(admin.getPassword(),BCrypt.gensalt()));
    return success(this.adminService.save(admin));
  }

  /**
   * 分页查询所有数据
   *
   * @param page  分页对象
   * @param admin 查询实体
   * @return 所有数据
   */
  @GetMapping("/page/{page}/{size}")
  public R<Page<Admin>> pageList(@PathVariable("page") int page, @PathVariable("size") int size, Admin admin) {
    Page<Admin> pageParam = new Page<>(page, size);
    return success(this.adminService.page(pageParam, new QueryWrapper<>(admin)));
  }

  /**
   * 查询所有数据
   *
   * @param admin 查询实体
   * @return 所有数据
   */
  @GetMapping
  public R<List<Admin>> selectList(Admin admin) {
    return success(this.adminService.list(new QueryWrapper<>(admin)));
  }

  /**
   * 修改数据
   *
   * @param admin 实体对象
   * @return 修改结果
   */
  @PutMapping
  public R update(@RequestBody Admin admin) {
    return success(this.adminService.updateById(admin));
  }

  @PostMapping("login")
  public R login(@RequestBody Admin admin){

    Boolean valid = this.adminService.login(admin);
    Assert.isTrue(valid,"用户名或密码不正确");

    //生成jwt返回给客户端
    String jwt = JwtUtil.createJWT(UUID.fastUUID().toString(), admin.getLoginName(), null);
    return success(jwt);
  }
}