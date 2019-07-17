package com.conifer.health.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = "com.conifer.health")
@EnableWebMvc
public class ConiferHealthConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private Environment env;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*")
				.allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
				.allowedHeaders("X-Auth-Token", "Content-Type")
				.allowCredentials(false).maxAge(4800);
	}

/*	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		return dataSource;
	}
	   @Bean
	   public ListFactoryBean getSessionFactory() {
	      ListFactoryBean factoryBean = new ListFactoryBean();

	      Properties props=new Properties();
	      props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	      props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
	      return factoryBean;
	   }*/


	
}
