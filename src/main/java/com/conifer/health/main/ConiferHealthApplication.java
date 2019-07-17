package com.conifer.health.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Starting Point Of Conifer Health Application.
 * @author bipin.muduli
 *
 */


@EnableAutoConfiguration(exclude={JmxAutoConfiguration.class})
@ComponentScan("com.conifer.health.*")
//@SpringBootApplication(scanBasePackages={"com.conifer.health.main"})
// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class ConiferHealthApplication extends WebMvcConfigurerAdapter {
	
	
	public static void main(String[] args) {
		SpringApplication.run(ConiferHealthApplication.class, args);
	}
	

}
