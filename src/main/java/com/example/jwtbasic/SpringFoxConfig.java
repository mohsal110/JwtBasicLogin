package com.example.jwtbasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig implements WebMvcConfigurer {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Room")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.jwtbasic"))
                .paths(PathSelectors.any())
                .build();
    }

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/swagger-ui.html");
        // use setStatusCode(HttpStatus.XYZ) for any custom status code if required, e.g. MOVED_PERMANENTLY
//        registry.addRedirectViewController("/swagger-ui", "/swagger-ui.html");
        // any other alias
    }





}
