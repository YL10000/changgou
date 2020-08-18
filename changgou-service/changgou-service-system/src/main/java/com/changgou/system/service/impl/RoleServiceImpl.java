package com.changgou.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.changgou.system.dao.RoleDao;
import com.changgou.system.entity.Role;
import com.changgou.system.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * (TbRole)表服务实现类
 *
 * @author makejava
 * @since 2020-08-14 15:00:05
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

}