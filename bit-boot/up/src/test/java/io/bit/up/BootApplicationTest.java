package io.bit.up;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.ec2.AmazonEC2;

import io.bit.up.BootApplication;
import io.bit.up.BootConfiguration;

public class BootApplicationTest {

	@Test
	public void testBootApplicationJavaConfig() {
		ApplicationContext springContext = new BootApplication().run();
		
		BootConfiguration testConfig = springContext.getBean(BootConfiguration.class);

		assertThat(testConfig.getRegion(), equalTo("${aws.region}"));
		assertThat(springContext.getBean(AmazonEC2.class), notNullValue());
	}

}
