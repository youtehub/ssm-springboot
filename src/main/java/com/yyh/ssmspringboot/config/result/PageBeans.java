package com.yyh.ssmspringboot.config.result;

import java.util.List;

/**
 * PageBeans
 *
 * @author yyh
 */
public class PageBeans {

    public static <T> PageBean<T> build(long total, List<T> rows) {
        return new PageBean<>(total, rows);
    }
}
