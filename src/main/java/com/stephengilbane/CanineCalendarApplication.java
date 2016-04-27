/*
 * Copyright 2015-2016 Stephen Gilbane.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package com.stephengilbane;

import static springfox.documentation.builders.PathSelectors.regex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.stephengilbane.repos.DogBreedRepository;

import io.swagger.models.Contact;
import io.swagger.models.Info;
import io.swagger.models.Swagger;
import io.swagger.models.Tag;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Main dog calendar application.  Intended to manage schedules of dog visits,
 * dogs, their owners, and the visit clients.
 * Called by Spring Boot.
 * 
 * @author stephengilbane
 */
@ComponentScan
@EnableAutoConfiguration
@EnableWebMvc
@EnableSwagger2
@SpringBootApplication
public class CanineCalendarApplication 
{
	
	private static final Logger log = LoggerFactory.getLogger(CanineCalendarApplication.class);

	/**
	 * Main method called by Spring Boot.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		SpringApplication.run(CanineCalendarApplication.class, args);
	}
	
	/**
	 * Swagger support for online doc.
	 * @return
	 */
    @Bean
    public Docket dogSchedApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("CanineScheduler")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/caninescheduler.*"))
                .build();
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Canine Visit Scheduler API")
                .description("Canine Visit Scheduler Application")
                .termsOfServiceUrl("/termsOfService.html")
                .version("1.0")
                .build();
    }
    
    /**
     * Swagger app info.
     * @return
     */
    private Swagger swagger() 
    {
        Info info = new Info()
                .title("Dog Scheduler")
                .description("This is a demo server to coordinate dog visits.")
                .contact(new Contact()
                        .email("sgilbane@gmail.com"));
        Swagger swagger = new Swagger()
                .info(info);
        swagger.tag(new Tag()
               .name("dog")
               .description("Everything about your Dog"));
        swagger.tag(new Tag()
                .name("visit")
                .description("Everything about your Dog Visit"));
        swagger.tag(new Tag()
                .name("client")
                .description("Everything about Client organizations."));
        return swagger;
    }
    
    /**
     * CORS support for Swagger.
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/v2/api-docs").allowedOrigins("*");
            }
        };
    }
	
	/**
	 * Example CommandLinRunner to run during startup.
	 * @param repository
	 * @return
	 */
	@Bean
	public CommandLineRunner demo(DogBreedRepository repository) 
	{
		return (args) -> {
			log.info("Starting with breeds:");
			for (DogBreed db : repository.findAll()) 
			{
				log.info('\t' + db.toString());
			}
		};
	}
}
