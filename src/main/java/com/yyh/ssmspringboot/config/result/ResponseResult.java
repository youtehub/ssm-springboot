package com.yyh.ssmspringboot.config.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ResponseResult
 *
 * @author yyh
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult<T> {
    @ApiModelProperty(value = "代码", position = 1, example = "1000")
    private int code;
    @ApiModelProperty(value = "信息", position = 2, example = "成功")
    private String msg;
    @ApiModelProperty(value = "数据", position = 3)
    private T data;
}
