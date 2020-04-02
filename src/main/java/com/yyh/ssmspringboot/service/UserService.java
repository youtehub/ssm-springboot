package com.yyh.ssmspringboot.service;

import com.yyh.ssmspringboot.config.BaseMapper;
import com.yyh.ssmspringboot.config.result.PageBean;
import com.yyh.ssmspringboot.config.result.ResponseResult;
import com.yyh.ssmspringboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * UserDAO继承基类
 */
public interface UserService {

    User getById(Integer id);

    /**
     * 获取所有用户
     *
     * @param page
     * @param size
     * @return
     */
    ResponseResult<PageBean<User>> getAll(Integer page, Integer size);

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    ResponseResult insert(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    ResponseResult delete(Integer id);

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    ResponseResult update(User user);
}