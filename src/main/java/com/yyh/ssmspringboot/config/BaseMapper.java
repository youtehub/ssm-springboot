package com.yyh.ssmspringboot.config;

import tk.mybatis.mapper.common.*;

/**
 * @author ふさん
 * @date 2019/9/26  9:55
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T>, ConditionMapper<T>, ExampleMapper<T> {
}
