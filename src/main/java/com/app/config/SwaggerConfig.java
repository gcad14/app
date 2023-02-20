package com.app.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableOpenApi //开启swagger自定义接口文档
@Configuration //相当于Spring配置中的<beans>
public class SwaggerConfig {

    @Value("${swagger.enable}")
    private Boolean enable;

    public Docket createRestAPi() {
        //指定扫描包路径
        return new Docket(DocumentationType.OAS_30)
                //配置swagger是否生效
                .enable(enable)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    //添加摘要信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("描述")
                .description("测试描述")
                .contact(new Contact("gc", "https://blog.csdn.net/u014553029", "2011766189@qq.com"))
                .version("V1.0")
                .build();
    }
}
