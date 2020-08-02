package com.fyp.SpringBootBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//	@SpringBootApplication includes 3 annotation (see below). These are the annotations used to start the
// 	Spring Boot Application to run on a server.
//	@Component — Tells the compiler that the following class is a component which should be included when compiling the whole application.
//	@ComponentScan — This one does the Scan of which packages we are going to use in the following Java class.
//	@EnableAutoConfiguration — enables Spring Boot’s autoconfiguration mechanism to import important modules for the Spring Boot to run.
@EnableSwagger2
//@EnableElasticsearchRepositories("com.example.springmysqlelastic.repo.elastic")
public class SpringBootBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBackendApplication.class, args);
	}

}
