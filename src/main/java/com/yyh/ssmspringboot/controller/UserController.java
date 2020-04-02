package com.yyh.ssmspringboot.controller;

import com.yyh.ssmspringboot.config.BaseMapper;
import com.yyh.ssmspringboot.config.result.PageBean;
import com.yyh.ssmspringboot.config.result.ResponseResult;
import com.yyh.ssmspringboot.config.validate.Insert;
import com.yyh.ssmspringboot.entity.User;
import com.yyh.ssmspringboot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理
 *
 * @author yyh
 */
@RestController
@Api(tags = "用户管理")
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getAll")
    @ApiOperation("获取所有用户")
    public ResponseResult<PageBean<User>> getAll(@ApiParam(value = "当前页码", required = true, example = "1") @RequestParam Integer page,
                                                 @ApiParam(value = "分页大小", required = true, example = "10") @RequestParam Integer size) {
        return userService.getAll(page, size);
    }

    @PostMapping("insert")
    @ApiOperation("新增用户")
    public ResponseResult insert(@ApiParam(value = "用户信息", required = true, example = "1") @Validated(Insert.class) User user) {
        return userService.insert(user);
    }

    @PostMapping("update")
    @ApiOperation("修改用户")
    public ResponseResult update(@ApiParam(value = "用户信息", required = true, example = "1") @Validated(Insert.class) User user) {
        return userService.update(user);
    }

    @PostMapping("delete")
    @ApiOperation("删除用户")
    public ResponseResult delete(@ApiParam(value = "用户Id", required = true, example = "1") @RequestParam Integer id) {
        return userService.delete(id);
    }


}