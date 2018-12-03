package com.ud.basic.system.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*@Configuration
@EnableSwagger2*/
public class SystemSwaggerConfig {
    @Bean
    public Docket api() {
    	//添加head参数start  
    	ParameterBuilder tokenPar = new ParameterBuilder();
    	List<Parameter> pars = new ArrayList<Parameter>();  
    	tokenPar.name("Authorization").description("令牌").modelRef(new ModelRef("string"))
    	.parameterType("header").required(false)
    	.defaultValue("Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJbXCJhZG1pblwiLFwiMVwiXSIsImV4cCI6MTUzNTU2NjYxMH0.hV7EIiT8pR-FhWRpCZpRUWVQsPtJP98KbuZQVvahhm1gXCSHPD8jY0GQfTqDQ4isnUjig5NSk-nnBZ8o_CWVvA")
    	.build();  
    	pars.add(tokenPar.build());  
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(apiInfo())
                .select()  // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.ud")) // 对所有api进行监控
                .paths(PathSelectors.any()) // 对所有路径进行监控
                .build()
                .globalOperationParameters(pars)
                .useDefaultResponseMessages(false).enable(true);
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("接口文档").build();
    }
}
