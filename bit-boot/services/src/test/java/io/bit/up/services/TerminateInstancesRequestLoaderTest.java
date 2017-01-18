package io.bit.up.services;

import com.amazonaws.services.ec2.model.RunInstancesRequest;
import io.bit.up.pojo.BitUpStartRequest;
import io.bit.up.services.impl.RunInstancesRequestLoader;
import io.bit.up.test.builder.BitUpRequestBuilder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class TerminateInstancesRequestLoaderTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

}
