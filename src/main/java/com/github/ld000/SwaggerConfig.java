package com.github.ld000;

import com.github.ld000.common.CommonResultResponse;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket k2Api() {

        List<ResponseMessage> responseMessageArrayList = Lists.newArrayList(
                new ResponseMessageBuilder()
                        .code(400)
                        .message("Bad Request")
                        .responseModel(new ModelRef(CommonResultResponse.class.getSimpleName()))
                        .build(),
                new ResponseMessageBuilder()
                        .code(500)
                        .message("Internal Server Error")
                        .responseModel(new ModelRef(CommonResultResponse.class.getSimpleName()))
                        .build()
        );
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, responseMessageArrayList)
                .globalResponseMessage(RequestMethod.POST, responseMessageArrayList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageArrayList)
                .forCodeGeneration(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.ld000"))
                .build()
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("脑图API")
                .description("https://github.com/ld000")
                .termsOfServiceUrl("https://github.com/ld000")
                .version("1.0")
                .build();
    }

}
