package giggles.giggle.config;

import java.util.ArrayList;
import java.util.List;

import giggles.giggle.infra.util.aop.AuthorityInterceptor;
import giggles.giggle.infra.util.aop.IdentifyCodeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
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

/**
 * @author zty
 *
 * <p>swagger and springmvc config</p>
 */
@Configuration
@EnableSwagger2
public class Swagger2Config extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthorityInterceptor()).addPathPatterns("/v1/**");
        registry.addInterceptor(new IdentifyCodeInterceptor()).addPathPatterns("/v1/users/login");
        super.addInterceptors(registry);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/");
        super.addResourceHandlers(registry);
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("giggles.giggle.api.controller.v1"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(setHeaderToken());
    }

    /**
     * <p>swagger information</p>
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("giggle v1 version api")
                .description("elegant restful style")
                .termsOfServiceUrl("https://blog.csdn.net/qq_33905749")
                .version("1.0")
                .build();
    }

    /**
     * @return <p>token param config</p>
     */
    private List<Parameter> setHeaderToken() {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> params = new ArrayList<>();
        parameterBuilder.name("Authorization").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        params.add(parameterBuilder.build());
        return params;
    }

}
