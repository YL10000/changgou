package com.changgou.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.changgou.system.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * (TbAdmin)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-14 15:00:03
 */
@Mapper
public interface AdminDao extends BaseMapper<Admin> {


}