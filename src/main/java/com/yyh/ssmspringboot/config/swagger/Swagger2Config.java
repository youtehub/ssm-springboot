package com.yyh.ssmspringboot.config.swagger;

import com.spring4all.swagger.EnableSwagger2Doc;
import com.yyh.ssmspringboot.config.result.ResponseResult;
import com.yyh.ssmspringboot.config.result.ResponseResults;
import com.yyh.ssmspringboot.config.validate.Insert;
import com.yyh.ssmspringboot.config.validate.Update;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Swagger2Config
 *
 * @author yiyh
 */

@ComponentScan("com.yyh.ssmspringboot.controller")//需要扫描的api位置
@Configuration//说明是一个配置类
@EnableSwagger2Doc
public class Swagger2Config {
    /**
     * 创建BeanApi
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yyh.ssmspringboot.controller"))//扫描Api包
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Springboot-Swagger示例")//api的标日
                .description("一般常用api信息")//api描述
                .termsOfServiceUrl("https://www.baidu.com/")//服务地址
                .contact(new Contact("cqc", "https://www.baidu.com/", "leomple@163.com"))//联系信息
                .version("1.0")
                .build();
    }

}
