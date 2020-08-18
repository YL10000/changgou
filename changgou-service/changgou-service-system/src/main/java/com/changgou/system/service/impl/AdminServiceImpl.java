package com.changgou.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.changgou.system.dao.AdminDao;
import com.changgou.system.entity.Admin;
import com.changgou.system.service.AdminService;
import org.springframework.stereotype.Service;

/**
 * (TbAdmin)表服务实现类
 *
 * @author makejava
 * @since 2020-08-14 15:00:04
 */
@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminDao, Admin> implements AdminService {

  @Override
  public Boolean login(Admin admin) {
    //根据用户名和状态查询用户
    Admin one = this.lambdaQuery().eq(Admin::getLoginName, admin.getLoginName()).eq(Admin::getStatus, "1").one();
    if (BeanUtil.isEmpty(one)) return false;
    //验证密码是否正确
    return BCrypt.checkpw(admin.getPassword(),one.getPassword());
  }
}