package io.bit.up.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;

/**
 * Bitup service configuration. <br>It provides the following beans :
 * <ul>
 * <li>Properties configuration</li>
 * <li>Amazon EC2 client</li>
 * <li>Listener to validate service's inputs and outputs</li>
 * </ul>
 * 
 * @author atuffrea
 *
 */
@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class BootApplication {

	/** Application's properties. */
	@Autowired
	private BootConfiguration configuration;

	/** Logger */
	private static final Logger LOG = LoggerFactory.getLogger(BootApplication.class);

	public BootApplication() {
	}
	
	/**
	 * Run bitup's spring boot configuration.
	 * 
	 * @return Spring's ApplicationContext with the configuration
	 */
	public ApplicationContext run() {
		LOG.info(String.format("Booting bitup."));
		return new AnnotationConfigApplicationContext(BootApplication.class);
	}

	/**
	 * Build a client used to launch request to AWS EC2 API.
	 * 
	 * @return amazon EC2 client
	 */
	@Bean
	@Scope("prototype")
	public AmazonEC2 amazonEC2() {
		return AmazonEC2ClientBuilder.standard()
				.withRegion(configuration.getRegion())
				.build();
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