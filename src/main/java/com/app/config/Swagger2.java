package com.app.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi //开启swagger
@EnableKnife4j //开启knife4j
//@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("用户管理")
                .apiInfo(new ApiInfoBuilder()
                        .title("标题")
                        .description("miaoshu")
                        .version("1.0")
                        .contact(new Contact("gc", "adf", "2011766189@qq.com"))
                        .termsOfServiceUrl("adsfasdfad")
                        .build()
                )
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.app.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
