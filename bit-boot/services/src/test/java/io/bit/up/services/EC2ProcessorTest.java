package io.bit.up.services;

import static org.mockito.Mockito.*;

import javax.validation.ConstraintViolationException;

import io.bit.up.pojo.BitUpStartRequest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;

import io.bit.up.test.builder.BitUpRequestBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= { TestConfiguration.class } )
public class EC2ProcessorTest {
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private AmazonEC2 amazonEC2;

    @Autowired
    private IEC2Service service;

	@Test
	public void testProcess_nullRequest() {
		thrown.expect(ConstraintViolationException.class);
		service.up(null);
	}

	@Test
	public void testProcess_invalidRequest() {
		thrown.expect(ConstraintViolationException.class);
		service.up(new BitUpStartRequest());
	}

	@Test
	public void testProcess_validRequest() {
		BitUpStartRequest bitUpStartRequest = new BitUpRequestBuilder().withImageId("imageId")
				.withInstanceType("instanceType").withKeyName("keyName").withSecurityGroups("securityGroup").build();
		when(amazonEC2.runInstances(Matchers.any(RunInstancesRequest.class))).thenReturn(new RunInstancesResult());
		
		service.up(bitUpStartRequest);
	}

}
