package io.bit.up.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Bitup properties container component.
 * 
 * @author atuffrea
 *
 */
@Component
public class BootConfiguration {

	/** Bitup's default region to AWS services */
	@Value("${aws.region}")
	private String region;

	/**
	 * Getter of the region attribute.
	 * 
	 * @return the AWS default region for bitup
	 */
	public String getRegion() {
		return region;
	}

}
