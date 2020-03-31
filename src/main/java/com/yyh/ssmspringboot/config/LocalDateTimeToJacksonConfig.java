package com.yyh.ssmspringboot.config;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * LocalDateTime2JsonConfig
 *
 * @author zhangquanli
 */
@Configuration
public class LocalDateTimeToJacksonConfig {

    /**
     * LocalDateTime格式化
     */
    private static final String LOCAL_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * LocalDate格式化
     */
    private static final String LOCAL_DATE_FORMAT = "yyyy-MM-dd";

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        // 序列化
        LocalDateTimeSerializer localDateTimeSerializer = new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_FORMAT));
        LocalDateSerializer localDateSerializer = new LocalDateSerializer(DateTimeFormatter.ofPattern(LOCAL_DATE_FORMAT));
        // 反序列化
        LocalDateTimeDeserializer localDateTimeDeserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_FORMAT));
        LocalDateDeserializer localDateDeserializer = new LocalDateDeserializer(DateTimeFormatter.ofPattern(LOCAL_DATE_FORMAT));
        Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer = builder -> builder.serializerByType(LocalDateTime.class, localDateTimeSerializer)
                .serializerByType(LocalDate.class, localDateSerializer)
                .deserializerByType(LocalDateTime.class, localDateTimeDeserializer)
                .deserializerByType(LocalDate.class, localDateDeserializer);
        return jackson2ObjectMapperBuilderCustomizer;
    }
}
