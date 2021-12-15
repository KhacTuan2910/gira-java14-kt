package cyb.ot.javabackend.girajava14kt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfiguration {
	@Value("${api.info.title}") String title;
	
	@Bean
	public OpenAPI getOpenApi() {
		return new OpenAPI()
				.info(new Info().title(title)
	              .description("Gira application for education purpose")
	              .version("v1.0")
	              .license(new License().name("NO LICENSE").url("http://springdoc.org"))
	              .contact(new Contact()
	            		  .email("tuannguyen2924@gmail.com")
	            		  .name("Tuan Nguyen")))
			    .externalDocs(new ExternalDocumentation()
	              .description("Spring Documentation")
	              .url("https://spring.io/projects/spring-framework"));

	}
}
