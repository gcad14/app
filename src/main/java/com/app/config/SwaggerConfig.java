package com.app.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public Docket createRestAPi(){
        //指定扫描包路径
        return new Docket(DocumentationType.SWAGGER_2)//指定生成的文档的类型是swagger2
        .pathMapping("/swagger")
                .select()
                .paths(PathSelectors.any())
                .build();
    }

    //添加摘要信息
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("描述")
                .description("测试描述")
                .contact(new Contact("gc","https://blog.csdn.net/u014553029","2011766189@qq.com"))
                .version("版本号：1.0.1")
                .build();
    }
}
