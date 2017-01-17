package io.bit.up.ec2;

import static org.mockito.Mockito.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.services.ec2.AmazonEC2;

@Configuration
public class MockBeansConfig {
	
	@Bean
	public AmazonEC2 amazonEC2() {
		return mock(AmazonEC2.class);
	}

}
