package com.yyh.ssmspringboot.config.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

/**
 * PageBean
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T> {
    @ApiModelProperty(value = "总记录数", position = 1, example = "0")
    private long total;
    @ApiModelProperty(value = "分页数据", position = 2)
    private List<T> rows;
}
