package com.yyh.ssmspringboot.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyh.ssmspringboot.config.result.PageBean;
import com.yyh.ssmspringboot.config.result.ResponseResult;
import com.yyh.ssmspringboot.config.result.ResponseResults;
import com.yyh.ssmspringboot.entity.User;
import com.yyh.ssmspringboot.mybatis.UserDAO;
import com.yyh.ssmspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserDAO继承基类
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User getById(Integer id) {
        return null;
    }

    @Override
    public ResponseResult<PageBean<User>> getAll(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<User> users = userDAO.selectAll();
        return ResponseResults.success((Page<User>) users);
    }

    @Override
    public ResponseResult insert(User user) {
        userDAO.insert(user);
        return ResponseResults.success();
    }

    @Override
    public ResponseResult delete(Integer id) {
        userDAO.deleteByPrimaryKey(id);
        return ResponseResults.success();
    }

    @Override
    public ResponseResult update(User user) {
        userDAO.updateByPrimaryKeySelective(user);
        return ResponseResults.success();
    }


}