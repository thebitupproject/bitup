package io.bit.up.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.RunInstancesResult;

import io.bit.up.pojo.BitUpRequest;
import io.bit.up.service.IUpService;

/**
 * Implements {@link IUpService} with AWS cloud service.<p>
 * @author atuffrea
 *
 */
@Service
public class EC2Service implements IUpService {
	
	/** Logger. */
	private Logger LOG = LoggerFactory.getLogger(BitUpRequest.class);
	
	/** Amazon EC2 lcient. */
	private AmazonEC2 amazonEC2;
	
	public void up(BitUpRequest request) {
		LOG.info(String.format("Process() with request: %s", request));
		RunInstancesResult results = amazonEC2.runInstances(RunIstancesRequestLoader.load(request));
		Reservation reservation = results.getReservation();
		LOG.info(String.format("Process with request: %s ended", request));
	}
	
	@Autowired
	public EC2Service(AmazonEC2 amazonEC2) {
		this.amazonEC2 = amazonEC2;
	}

}
