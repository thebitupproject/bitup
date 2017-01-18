package io.bit.up.services.impl;

import com.amazonaws.services.ec2.model.*;
import io.bit.up.pojo.BitUpStartRequest;
import io.bit.up.pojo.BitUpShutdownRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.ec2.AmazonEC2;

import io.bit.up.services.IEC2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements {@link IEC2Service} with AWS cloud service.<p>
 *
 * @author atuffrea
 */
@Service
public class EC2Service implements IEC2Service {

    private Logger LOG = LoggerFactory.getLogger(BitUpStartRequest.class);
    private AmazonEC2 amazonEC2;

    @Autowired
    public EC2Service(AmazonEC2 amazonEC2) {
        this.amazonEC2 = amazonEC2;
    }

    /**
     * Start EC2 instance
     *
     * @param request
     */
    public void up(BitUpStartRequest request) {
        LOG.info(String.format("Starting instance with parameters from request : %s", request));
        RunInstancesResult results = amazonEC2.runInstances(RunInstancesRequestLoader.load(request));
        Reservation reservation = results.getReservation();

        if (null != reservation) {

            //Get first instance as we are handling the start of one instance simultaneously for now
            List<Instance> startedInstances = reservation.getInstances();
            if (startedInstances.size() > 0) {
                Instance startedInstance = reservation.getInstances().get(0);
                LOG.info(String.format("Instance with public ip %s started", startedInstance.getPublicIpAddress()));
            }
        }
    }

    /**
     * Terminate EC2 instance
     *
     * @param request
     */
    public void shutdown(BitUpShutdownRequest request) {
        LOG.info(String.format("Shutting down instance with parameters from request : %s", request));
        TerminateInstancesResult results = amazonEC2.terminateInstances(ShutdownInstancesRequestLoader.load(request));

        //Get first instance as we are handling the termination of one instance simultaneously for now
        InstanceStateChange terminatedInstance = results.getTerminatingInstances().get(0);
        LOG.info(String.format("Instance with id %s terminated", terminatedInstance.getInstanceId()));
    }

}
