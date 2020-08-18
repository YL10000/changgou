package com.changgou.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.changgou.system.dao.AdminRoleDao;
import com.changgou.system.entity.AdminRole;
import com.changgou.system.service.AdminRoleService;
import org.springframework.stereotype.Service;

/**
 * (TbAdminRole)表服务实现类
 *
 * @author makejava
 * @since 2020-08-14 15:00:05
 */
@Service("adminRoleService")
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleDao, AdminRole> implements AdminRoleService {

}