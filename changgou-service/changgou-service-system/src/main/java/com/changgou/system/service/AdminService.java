package com.changgou.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.changgou.system.entity.Admin;

/**
 * (TbAdmin)表服务接口
 *
 * @author makejava
 * @since 2020-08-14 15:00:04
 */
public interface AdminService extends IService<Admin> {

  /**
   * 登录
   * @param admin
   * @return
   */
  Boolean login(Admin admin);
}