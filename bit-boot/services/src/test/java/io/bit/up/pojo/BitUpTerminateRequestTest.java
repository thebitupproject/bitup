package io.bit.up.pojo;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BitUpTerminateRequestTest {

	private ObjectMapper mapper;

	@Before
	public void setUp() {
		mapper = new ObjectMapper();
	}

	@Test
	public void testPojo() throws JsonParseException, JsonMappingException, IOException {

	}

}
