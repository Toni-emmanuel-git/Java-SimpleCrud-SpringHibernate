package net.javaguides.springboot;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("net.javaguides.springboot"))
				.paths(PathSelectors.regex("/*.*"))
				.build()
				.apiInfo(metaInfo());
	}
	
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Funcionarios API REST",
				"API REST de cadastro de funcionarios.",
				"1.0",
				"Terms of Service",
				new Contact("Emmanuel Antônio","emmanuel_braga@outlook.com","https://www.youtube.com/emmanuelAntonio"),
					"Apache License Version 2.0",
					"https://www.apache.org/license.html", new ArrayList<VendorExtension>()
				);
		
				return apiInfo;
	}
}
