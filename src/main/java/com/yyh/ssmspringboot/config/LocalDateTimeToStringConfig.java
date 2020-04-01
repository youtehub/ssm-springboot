package com.yyh.ssmspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * LocalDateTimeToStringConfig
 *
 * @author yyh
 */
@Configuration
public class LocalDateTimeToStringConfig {

    /**
     * LocalDateTime格式化
     */
    private static final String LOCAL_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * LocalDate格式化
     */
    private static final String LOCAL_DATE_FORMAT = "yyyy-MM-dd";

    @Bean
    public StringToLocalDateTimeConverter localDateTimeConverter() {
        return new StringToLocalDateTimeConverter();
    }

    @Bean
    public StringToLocalDateConverter localDateConverter() {
        return new StringToLocalDateConverter();
    }

    private class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {
        @Override
        public LocalDateTime convert(String source) {
            return LocalDateTime.parse(source, DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_FORMAT));
        }
    }

    private class StringToLocalDateConverter implements Converter<String, LocalDate> {
        @Override
        public LocalDate convert(String source) {
            return LocalDate.parse(source, DateTimeFormatter.ofPattern(LOCAL_DATE_FORMAT));
        }
    }
}
