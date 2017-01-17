package io.bit.up.handler;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import io.bit.up.spring.BootApplication;
import io.bit.up.service.IUpService;
import io.bit.up.pojo.BitUpRequest;

/**
 * Class to handle AWS lambda Up request which launch a new running instance in
 * the AWS cloud.
 * <p>	
 * Created by ArthurBaudry and atuffreau on 29/11/16.
 */
public class BitUp implements RequestHandler<BitUpRequest, String> {

	/** Logger. */
	private static Logger LOG = Logger.getLogger(BitUp.class);

	/**
	 * Handle the AWS lambda Up requests.
	 * 
	 * @param input
	 *            the request parameters
	 * @param context
	 *            the AWS {@link Context}
	 * @return the String OK
	 */
	public String handleRequest(BitUpRequest input, Context context) {
		LOG.info("Bitup handleRequest() with input: " + input.getImageId());
		BitUp.runningRequest(input);
		return "OK";
	}

	/**
	 * Execute the bitup request to launch an new instance.
	 * 
	 * @param input
	 *            the instance configuration
	 */
	public static void runningRequest(BitUpRequest input) {
		LOG.info(String.format("handlingRequest() with input : %s", input));
		ApplicationContext springContext = new BootApplication().run();
		springContext.getBean(IUpService.class).up(input);
		LOG.info(String.format("runningRequest() with input : %s as ended", input));
	}

}
