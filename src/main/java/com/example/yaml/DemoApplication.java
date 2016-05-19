package com.example.yaml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	public static PropertySourcesPlaceholderConfigurer properties() {
//		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
//		YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
//		yaml.setResources(new ClassPathResource("server_country.yml"));
//		propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
//		return propertySourcesPlaceholderConfigurer;
//	}
}
