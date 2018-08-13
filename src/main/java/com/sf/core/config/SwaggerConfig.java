package com.sf.core.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;


/**
 * Swagger 文档配置
 *
 * @author lijie.zh
 */
@Configuration
@EnableSwagger2
@SuppressWarnings("unchecked")
public class SwaggerConfig {

    @Bean
    public Docket allApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .paths(or(regex("/.*")))
                .build()
                .apiInfo(allApiInfo());
    }
    private ApiInfo allApiInfo() {
        return new ApiInfoBuilder()
                .title("所有接口")
                .description("包含所有接口服务")
                .version("1.0")
                .termsOfServiceUrl("NO terms of service")
                .build();
    }



    @Bean
    public Docket loginApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("登录注册")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .paths(doFilteringRules())
                .build()
                .apiInfo(loginApiInfo());
    }

    private Predicate<String> doFilteringRules() {
        return or(regex("/login"), regex("/version/.*"), regex("/password/.*"), regex("/register"), regex("/user/.*"));
    }

    @Bean
    public Docket sysApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("系统管理")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .paths(or(regex("/sys/.*")))
                .build()
                .apiInfo(sysApiInfo());
    }

    private ApiInfo loginApiInfo() {
        return new ApiInfoBuilder()
                .title("用户登录、注册等")
                .description("包含用户的注册、登录、版本校验、升级等基础的接口服务")
                .version("1.0")
                .termsOfServiceUrl("NO terms of service")
                .build();
    }

    private ApiInfo sysApiInfo() {
        return new ApiInfoBuilder()
                .title("系统管理")
                .description("系统管理相关的接口都在这里")
                .version("1.0")
                .termsOfServiceUrl("NO terms of service")
                .build();
    }

}
