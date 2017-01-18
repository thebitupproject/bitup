package io.bit.up.services.impl;

import com.amazonaws.services.ec2.model.TerminateInstancesRequest;
import io.bit.up.pojo.BitUpShutdownRequest;

/**
 * Created by ArthurBaudry on 17/01/17.
 */
public class ShutdownInstancesRequestLoader {

    /**
     * Translate a {@link BitUpShutdownRequest} into an AWS's {@link TerminateInstancesRequest}.
     *
     * @param request the bit's up request
     * @return the AWS request
     */
    public static TerminateInstancesRequest load(BitUpShutdownRequest request) {
        TerminateInstancesRequest terminateInstancesRequest = new TerminateInstancesRequest()
                .withInstanceIds(request.getInstanceId());

        return terminateInstancesRequest;
    }
}
