package io.bit.up.ec2;

import static org.mockito.Mockito.*;

import javax.validation.ConstraintViolationException;

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

import io.bit.up.BootApplication;
import io.bit.up.pojo.BitUpRequest;
import io.bit.up.test.builder.BitUpRequestBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= { BootApplication.class, MockBeansConfig.class } )
public class EC2ProcessorTest {
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private AmazonEC2 amazonEC2;

    @Autowired
    private IUpService processor;

	@Test
	public void testProcess_nullRequest() {
		thrown.expect(ConstraintViolationException.class);
		processor.up(null);
	}

	@Test
	public void testProcess_invalidRequest() {
		thrown.expect(ConstraintViolationException.class);
		processor.up(new BitUpRequest());
	}

	@Test
	public void testProcess_validRequest() {
		BitUpRequest bitUpRequest = new BitUpRequestBuilder().withImageId("imageId")
				.withInstanceType("instanceType").withKeyName("keyName").withSecurityGroups("securityGroup").build();
		when(amazonEC2.runInstances(Matchers.any(RunInstancesRequest.class))).thenReturn(new RunInstancesResult());
		
		processor.up(bitUpRequest);
	}

}
