package com.changgou.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.changgou.system.dao.MenuDao;
import com.changgou.system.entity.Menu;
import com.changgou.system.service.MenuService;
import org.springframework.stereotype.Service;

/**
 * (TbMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-08-14 15:00:05
 */
@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuDao, Menu> implements MenuService {

}