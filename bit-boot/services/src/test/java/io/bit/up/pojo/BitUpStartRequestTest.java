package io.bit.up.pojo;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BitUpStartRequestTest {

	private ObjectMapper mapper;

	@Before
	public void setUp() {
		mapper = new ObjectMapper();
	}

	@Test
	public void testPojo() throws JsonParseException, JsonMappingException, IOException {
		BitUpStartRequest request = mapper.readValue(
				new File(BitUpStartRequest.class.getResource("/").getFile() + "io/bit/up/pojo/bitUpRequest.json"),
				BitUpStartRequest.class);

		assertThat(request.getImageId(), equalTo("ami-9398d3e0"));
		assertThat(request.getInstanceType(), equalTo("t2.micro"));
		assertThat(request.getKeyName(), equalTo("bitup"));
		assertThat(request.getSecurityGroups(), equalTo("sg-8132a5e7"));
	}

}
