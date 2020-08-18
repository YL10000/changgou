package com.changgou.system.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.changgou.system.entity.Role;
import com.changgou.system.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Role)表控制层
 *
 * @author yanglin
 * @since 2020-08-14 17:30:37
 */
@RestController
@RequestMapping("role")
public class RoleController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;
	
	/**
     * 查询所有数据
     *
     * @param role 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R<List<Role>> selectList(Role role) {
        return success(this.roleService.list(new QueryWrapper<>(role)));
    }

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param role 查询实体
     * @return 所有数据
     */
    @GetMapping("/page/{page}/{size}")
    public R<Page<Role>> pageList(@PathVariable("page") int page, @PathVariable("size") int size, Role role) {
		Page<Role> pageParam = new Page<>(page,size);
        return success(this.roleService.page(pageParam, new QueryWrapper<>(role)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R<Role> findById(@PathVariable Serializable id) {
        return success(this.roleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param role 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Role role) {
        return success(this.roleService.save(role));
    }

    /**
     * 修改数据
     *
     * @param role 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Role role) {
        return success(this.roleService.updateById(role));
    }
    
    
    /**
     * 通过主键删除单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @DeleteMapping("{id}")
    public R delete(@PathVariable Serializable id) {
        return success(this.roleService.removeById(id));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.roleService.removeByIds(idList));
    }
}