package com.zlx.team.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


/**
 * @Author zlx
 * @Date 2024/2/27 23:01
 */
//@Configuration // 配置类
////@EnableSwagger2 // 开启 swagger2 的自动配置
//@ComponentScan({"springfox.documentation.schema"})
//@Profile({"dev", "test"})   //版本控制访问
//public class SwaggerConfig {
//    @Bean
//    public Docket docket() {
//        // 创建一个 swagger 的 bean 实例
//        return new Docket(DocumentationType.SWAGGER_2)
//
//                // 配置接口信息
//                .select() // 设置扫描接口
//                // 配置如何扫描接口
//                .apis(RequestHandlerSelectors
//                                //.any() // 扫描全部的接口，默认
//                                //.none() // 全部不扫描
//                                .basePackage("com.zlx.team.controller")
//                        // 扫描指定包下的接口，最为常用
//                        //.withClassAnnotation(RestController.class) // 扫描带有指定注解的类下所有接口
//                        //.withMethodAnnotation(PostMapping.class) // 扫描带有只当注解的方法接口
//
//                )
//                .paths(PathSelectors
//                                .any() // 满足条件的路径，该断言总为true
//                        //.none() // 不满足条件的路径，该断言总为false（可用于生成环境屏蔽 swagger）
//                        //.ant("/user/**") // 满足字符串表达式路径
//                        //.regex("") // 符合正则的路径
//                )
//                .build();
//    }
//
//    // 基本信息设置
//    private ApiInfo apiInfo() {
//        Contact contact = new Contact(
//                // 作者邮箱
//                "zlx", "", "2090444602@qq.com");
//        return new ApiInfoBuilder()
//                // 标题
//                .title("测试swagger")
//                // 描述
//                .description("")
//                // 跳转连接
//                .termsOfServiceUrl("https://www.bilibili.com")
//                // 版本
//                .version("1.0")
//                .license("")
//                .licenseUrl("")
//                .contact(contact)
//                .build();
//    }
//
//}

@Configuration
@EnableSwagger2WebMvc
@Profile({"dev", "test"})   //版本控制访问
public class SwaggerConfig {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 这里一定要标注你控制器的位置
                .apis(RequestHandlerSelectors.basePackage("com.zlx.team.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * api 信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("测试")
                .description("测试")
                .termsOfServiceUrl("")
                .contact(new Contact("zlx","","2090444602@qq.com"))
                .version("1.0")
                .build();
    }
}