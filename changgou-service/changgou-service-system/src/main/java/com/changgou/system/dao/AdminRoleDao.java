package com.changgou.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.changgou.system.entity.AdminRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * (TbAdminRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-14 15:00:05
 */
@Mapper
public interface AdminRoleDao extends BaseMapper<AdminRole> {


}