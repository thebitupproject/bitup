package io.bit.up.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.amazonaws.services.ec2.model.RunInstancesRequest;

import io.bit.up.pojo.BitUpStartRequest;
import io.bit.up.services.impl.RunInstancesRequestLoader;
import io.bit.up.test.builder.BitUpRequestBuilder;

public class RunInstancesRequestLoaderTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testLoad_nullData() {
		thrown.expect(NullPointerException.class);
		RunInstancesRequestLoader.load(null);
	}

	@Test
	public void testLoad_nullAttributs() {
		RunInstancesRequest request = RunInstancesRequestLoader.load(new BitUpStartRequest());

		assertThat(request.getImageId(), nullValue());
		assertThat(request.getInstanceType(), nullValue());
		assertThat(request.getKeyName(), nullValue());
		assertThat(request.getSecurityGroupIds().isEmpty(), equalTo(true));
	}

	@Test
	public void testLoad() {
		BitUpStartRequest bitUpStartRequest = new BitUpRequestBuilder().withImageId("imageId")
				.withInstanceType("instanceType").withKeyName("keyName").withSecurityGroups("securityGroup").build();
		
		RunInstancesRequest request = RunInstancesRequestLoader.load(bitUpStartRequest);

		assertThat(request.getImageId(), equalTo("imageId"));
		assertThat(request.getInstanceType(), equalTo("instanceType"));
		assertThat(request.getKeyName(), equalTo("keyName"));
		assertThat(request.getSecurityGroupIds().get(0), equalTo("securityGroup"));
	}

}
