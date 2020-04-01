package com.yyh.ssmspringboot.mybatis;

import com.yyh.ssmspringboot.config.BaseMapper;
import com.yyh.ssmspringboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * UserDAO继承基类
 */
@Mapper
@Repository
public interface UserDAO extends BaseMapper<User> {

    User getById(Integer id);
}