//package io.bit.up.handler;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.junit.Assert.assertThat;
//
//import org.junit.Before;
//import org.junit.Ignore;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.ExpectedException;
//
//import com.amazonaws.services.lambda.runtime.RequestHandler;
//
//import io.bit.up.handler.BitUp;
//import io.bit.up.pojo.BitUpRequest;
//import io.bit.up.test.builder.BitUpRequestBuilder;
//
//public class BitUpTest {
//
//	private RequestHandler<BitUpRequest, String> handler;
//
//	@Rule
//	public ExpectedException thrown = ExpectedException.none();
//
//	@Before
//	public void setUp() {
//		handler = new BitUp();
//	}
//
//	@Test
//	@Ignore
//	public void testHandler() {
//		assertThat(
//				handler.handleRequest(new BitUpRequestBuilder().withImageId("imageId").withInstanceType("instanceType")
//						.withKeyName("keyName").withSecurityGroups("secutyGroup").build(), null),
//				equalTo("Hello bitup !"));
//	}
//}
