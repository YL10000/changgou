package com.changgou.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.changgou.system.dao.OauthClientDetailsDao;
import com.changgou.system.entity.OauthClientDetails;
import com.changgou.system.service.OauthClientDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (OauthClientDetails)表服务实现类
 *
 * @author makejava
 * @since 2020-08-14 15:00:01
 */
@Service("oauthClientDetailsService")
public class OauthClientDetailsServiceImpl extends ServiceImpl<OauthClientDetailsDao, OauthClientDetails> implements OauthClientDetailsService {

}