package io.bit.up.ec2;

import com.amazonaws.services.ec2.model.RunInstancesRequest;

import io.bit.up.pojo.BitUpRequest;

/**
 * A convertir en translator pattern.
 * 
 * @author atuffrea
 *
 */
public class RunIstancesRequestLoader {

	/** 
	 * Translate a BitUpRequest into an AWS's RunInstanceRequest.
	 * @param request the bit's up request
	 * @return the AWS request
	 */
	public static RunInstancesRequest load(BitUpRequest request) {
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
