package com.hssblog.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hssblog.common.constant.RespEnum;
import com.hssblog.common.resp.RespBean;
import com.hssblog.entity.Blog;
import com.hssblog.exception.GlobalException;
import com.hssblog.service.BlogService;
import com.hssblog.util.ShiroUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hssblog
 * @since 2020-05-25
 */
@Slf4j
@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    /**
     * 分页查询博客列表
     *
     * @param currentPage 单当前页
     * @return RespBean
     */
    @GetMapping("/blogs")
    public RespBean list(@RequestParam(defaultValue = "1") Integer currentPage) {
        Page page = new Page(currentPage, 5);
        IPage pageData = blogService.page(page, new QueryWrapper<Blog>().orderByDesc("created"));
        return RespBean.success(pageData);
    }

    /**
     * 查询某篇博客
     * @param id 博客id
     * @return RespBean
     */
    @GetMapping("/blog/{id}")
    public RespBean detail(@PathVariable(name = "id") Long id) {
        Blog blog = blogService.getById(id);
        if (blog == null) {
            throw new GlobalException(RespEnum.NOT_FOUND);
        }
        return RespBean.success(blog);
    }

    /**
     * 编辑博客
     *
     * @param blog Blog
     * @return RespBean
     */
    @RequiresAuthentication
    @PostMapping("/blog/edit")
    public RespBean edit(@Validated @RequestBody Blog blog) {
        Blog temp;
        if (blog.getId() != null) {
            temp = blogService.getById(blog.getId());
            if (temp.getUserId().equals(ShiroUtil.getProfile().getId())) {
                log.error(">>>>>>>>>>>>>>>当前用户无编辑权限");
                throw new GlobalException(RespEnum.NO_AUTHORITY_EDIT);
            }
        } else {
            temp = new Blog();
            temp.setUserId(ShiroUtil.getProfile().getId());
            temp.setCreated(LocalDateTime.now());
            temp.setStatus(0);
        }
        BeanUtil.copyProperties(blog, temp, "id", "userId", "created", "status");
        blogService.saveOrUpdate(temp);
        return RespBean.success();
    }
}
