package com.yyh.ssmspringboot.config.result;

/**
 * ResponseMsg
 *
 * @author yyh
 */
public interface ResponseMsg {

    /**
     * 公共的成功信息
     */
    String SUCCESS = "成功";
    /**
     * 公共的失败信息
     */
    String FAILURE = "失败";
    /**
     * 认证失败
     */
    String AUTHENTICATION_FAILED = "认证失败";
    /**
     * 认证过期
     */
    String AUTHENTICATION_EXPIRED = "认证过期";
    /**
     * 认证过期
     */
    String REPEAT_LOGIN = "该账号已在另一地点登录，请重新登录";
    /**
     * 授权失败
     */
    String AUTHORIZATION_FAILED = "授权失败";
    /**
     * 请求参数错误
     */
    String REQUEST_PARAMETER_ERROR = "请求参数错误";
    /**
     * 非法操作
     */
    String OPERATION_INVALID = "你正在操作的流程与项目流程不符合，重新操作";
    /**
     * 业务异常
     */
    String BUSINESS_ERROR = "业务异常";
    /**
     * 服务器异常
     */
    String SERVER_EXCEPTION = "服务器异常";
}
