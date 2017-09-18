package com.springdi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.springdi.services.EmailService;
import com.springdi.services.MessageServices;

/*
 * Spring Dependency Injection Configuration with Annotations., 
 * 
 * For annotation based configuration, we need to write a Configurator class that will be used 
 * to inject the actual implementation bean to the component property.
 * 
 */

/*
 * 
 * @Configuration : annotation is used to let Spring know that it’s a Configuration class.
   @ComponentScan :annotation is used with @Configuration annotation to specify the packages to look for Component classes.
   @Bean : annotation is used to let Spring framework know that 
   		   this method should be used to get the bean implementation to inject in Component classes.
 * 
 * 
 */

@Configuration
@ComponentScan(value={"com.springdi.consumer"})
public class DIConfiguration {
	@Bean
	public MessageServices getMessageService(){
		return new EmailService();
	}
}
