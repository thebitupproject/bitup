package io.bit.up.services.impl;

import com.amazonaws.services.ec2.model.RunInstancesRequest;

import io.bit.up.pojo.BitUpStartRequest;

/**
 * A convertir en translator pattern.
 * 
 * @author atuffrea
 *
 */
public class RunInstancesRequestLoader {

	/** 
	 * Translate a BitUpStartRequest into an AWS's RunInstanceRequest.
	 * @param request the bit's up request
	 * @return the AWS request
	 */
	public static RunInstancesRequest load(BitUpStartRequest request) {
		RunInstancesRequest runInstancesRequest = new RunInstancesRequest()
				.withImageId(request.getImageId())
		        .withInstanceType(request.getInstanceType())
		        .withMinCount(1)
		        .withMaxCount(1)
		        .withKeyName(request.getKeyName());
		
		if (null != request.getSecurityGroups() && !request.getSecurityGroups().isEmpty()) {
			runInstancesRequest.withSecurityGroupIds(request.getSecurityGroups());  
		}
		
		return runInstancesRequest;
	}
}
