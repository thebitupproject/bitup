package io.bit.up.services;

import static org.mockito.Mockito.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import com.amazonaws.services.ec2.AmazonEC2;

@Configuration
@ComponentScan
public class TestConfiguration {

	/** Logger */
	private static final Logger LOG = LoggerFactory.getLogger(TestConfiguration.class);

	public TestConfiguration() {
	}
	
	@Bean
	public AmazonEC2 amazonEC2() {
		return mock(AmazonEC2.class);
	}
	
	/**
	 * Run test configuration.
	 * 
	 * @return Spring's ApplicationContext with the configuration
	 */
	public ApplicationContext run() {
		LOG.info(String.format("Booting up service."));
		return new AnnotationConfigApplicationContext(TestConfiguration.class);
	}

	/**
	 * Spring's lister to run validations on input and ouput data.
	 * 
	 * @return MethodValidationPostProcessor
	 */
	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}

	/**
	 * Factory to build the validators for Spring to use.
	 * 
	 * @return LocalValidatorFactoryBean
	 */
	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {
		return new LocalValidatorFactoryBean();
	}

}
