package com.changgou.system.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.changgou.system.entity.OauthClientDetails;
import org.apache.ibatis.annotations.Mapper;

/**
 * (OauthClientDetails)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-14 14:59:59
 */
@Mapper
public interface OauthClientDetailsDao extends BaseMapper<OauthClientDetails> {


}