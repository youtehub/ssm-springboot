package com.yyh.ssmspringboot.config.result;

/**
 * ResponseCode
 *
 * @author zhangquanli
 */
public interface ResponseCode {

    /**
     * 公共的成功代码
     */
    int SUCCESS = 1000;
    /**
     * 公共的失败代码
     */
    int FAILURE = 2000;
    /**
     * 认证失败
     */
    int AUTHENTICATION_FAILED = 1001;
    /**
     * 认证过期
     */
    int AUTHENTICATION_EXPIRED = 1002;
    /**
     * 授权失败
     */
    int AUTHORIZATION_FAILED = 1003;
    /**
     * 请求参数错误
     */
    int REQUEST_PARAMETER_ERROR = 1004;
    /**
     * 非法操作
     */
    int OPERATION_INVALID = 1005;
    /**
     * 业务异常
     */
    int BUSINESS_ERROR = 1006;
    /**
     * 登录重置
     */
    int LOGIN_RESET = 1007;
}
