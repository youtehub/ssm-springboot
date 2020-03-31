package com.yyh.ssmspringboot.config.result;

import com.github.pagehelper.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ResponseResults
 *
 * @author zhangquanli
 */
public class ResponseResults {

    /**
     * 构建简单响应数据
     *
     * @param code 代码
     * @param msg  信息
     * @param data 数据
     * @param <T>  泛型
     * @return ResponseResult
     */
    public static <T> ResponseResult<T> build(int code, String msg, T data) {
        return new ResponseResult<>(code, msg, data);
    }

    /**
     * 构建无响应数据
     *
     * @param code 代码
     * @param msg  信息
     * @return ResponseResult
     */
    public static ResponseResult build(int code, String msg) {
        return new ResponseResult<>(code, msg, null);
    }

    /**
     * 成功，简单响应数据
     *
     * @param msg  信息
     * @param data 数据
     * @param <T>  泛型
     * @return ResponseResult
     */
    public static <T> ResponseResult<T> success(String msg, T data) {
        return build(ResponseCode.SUCCESS, msg, data);
    }

    /**
     * 成功，分页响应数据
     *
     * @param msg   信息
     * @param total 总记录数
     * @param rows  分页数据
     * @param <T>   泛型
     * @return ResponseResult
     */
    public static <T> ResponseResult<PageBean<T>> success(String msg, long total, List<T> rows) {
        PageBean<T> data = PageBeans.build(total, rows);
        return build(ResponseCode.SUCCESS, msg, data);
    }

    /**
     * 成功，简单响应数据
     *
     * @param data 数据
     * @param <T>  泛型
     * @return ResponseResult
     */
    public static <T> ResponseResult<T> success(T data) {
        return build(ResponseCode.SUCCESS, ResponseMsg.SUCCESS, data);
    }

    /**
     * 成功，简单响应数据
     *
     * @param data 数据
     * @return ResponseResult
     */
    public static  ResponseResult successful(Object data) {
        return build(ResponseCode.SUCCESS, ResponseMsg.SUCCESS, data);
    }

    /**
     * 成功，分页响应数据
     *
     * @param total 总记录数
     * @param rows  分页数据
     * @param <T>   泛型
     * @return ResponseResult
     */
    public static <T> ResponseResult<PageBean<T>> success(long total, List<T> rows) {
        PageBean<T> data = PageBeans.build(total, rows);
        return build(ResponseCode.SUCCESS, ResponseMsg.SUCCESS, data);
    }

    /**
     * 成功，分页响应数据
     *
     * @param page 分页（Mybatis PageHelper）
     * @param <T>  泛型
     * @return ResponseResult
     */
    public static <T> ResponseResult<PageBean<T>> success(Page<T> page) {
        PageBean<T> data = PageBeans.build(page.getTotal(), page.getResult());
        return build(ResponseCode.SUCCESS, ResponseMsg.SUCCESS, data);
    }

    /**
     * 成功，分页响应数据
     *
     * @param page    分类（Mybatis PageHelper）
     * @param convert 转换源类型为目标类型
     * @param <T>     源类型
     * @param <R>     目标类型
     * @return ResponseResult
     */
    public static <T, R> ResponseResult<PageBean<R>> success(Page<T> page, Function<T, R> convert) {
        long total = page.getTotal();
        List<R> rows = page.stream().map(convert).collect(Collectors.toList());
        PageBean<R> data = PageBeans.build(total, rows);
        return build(ResponseCode.SUCCESS, ResponseMsg.SUCCESS, data);
    }

    /**
     * 成功，无响应数据
     *
     * @return ResponseResult
     */
    @SuppressWarnings("unchecked")
    public static <T> ResponseResult<T> success() {
        return build(ResponseCode.SUCCESS, ResponseMsg.SUCCESS);
    }

    /**
     * 失败，简单响应数据
     *
     * @param msg  信息
     * @param data 数据
     * @param <T>  泛型
     * @return ResponseResult
     */
    public static <T> ResponseResult<T> failure(String msg, T data) {
        return build(ResponseCode.FAILURE, msg, data);
    }

    /**
     * 失败，无响应数据
     *
     * @param msg 信息
     * @return ResponseResult
     */
    @SuppressWarnings("unchecked")
    public static <T> ResponseResult<T> failure1000(String msg) {
        return build(ResponseCode.SUCCESS, msg);
    }
    /**
     * 失败，无响应数据
     *
     * @param msg 信息
     * @return ResponseResult
     */
    @SuppressWarnings("unchecked")
    public static <T> ResponseResult<T> failure(String msg) {
        return build(ResponseCode.FAILURE, msg);
    }

    /**
     * 失败，无响应数据
     *
     * @return ResponseResult
     */
    @SuppressWarnings("unchecked")
    public static <T> ResponseResult failure() {
        return build(ResponseCode.FAILURE, ResponseMsg.FAILURE);
    }
}
