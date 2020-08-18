package com.changgou.system.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.changgou.system.entity.Menu;
import com.changgou.system.service.MenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Menu)表控制层
 *
 * @author yanglin
 * @since 2020-08-14 17:29:29
 */
@RestController
@RequestMapping("menu")
public class MenuController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private MenuService menuService;
	
	/**
     * 查询所有数据
     *
     * @param menu 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R<List<Menu>> selectList(Menu menu) {
        return success(this.menuService.list(new QueryWrapper<>(menu)));
    }

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param menu 查询实体
     * @return 所有数据
     */
    @GetMapping("/page/{page}/{size}")
    public R<Page<Menu>> pageList(@PathVariable("page") int page, @PathVariable("size") int size, Menu menu) {
		Page<Menu> pageParam = new Page<>(page,size);
        return success(this.menuService.page(pageParam, new QueryWrapper<>(menu)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R<Menu> findById(@PathVariable Serializable id) {
        return success(this.menuService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param menu 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Menu menu) {
        return success(this.menuService.save(menu));
    }

    /**
     * 修改数据
     *
     * @param menu 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Menu menu) {
        return success(this.menuService.updateById(menu));
    }
    
    
    /**
     * 通过主键删除单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @DeleteMapping("{id}")
    public R delete(@PathVariable Serializable id) {
        return success(this.menuService.removeById(id));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.menuService.removeByIds(idList));
    }
}