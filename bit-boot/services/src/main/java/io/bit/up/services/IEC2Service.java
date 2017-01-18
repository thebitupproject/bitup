package io.bit.up.services;

import io.bit.up.pojo.BitUpStartRequest;
import io.bit.up.pojo.BitUpTerminateRequest;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Process the requests to manage bit instances in the cloud.
 * <p>
 *
 * @author atuffrea
 */
@Validated
public interface IEC2Service {

    /**
     * Enable to launch a new instance in bit's cloud.
     *
     * @param request the configuration of the instance to launch
     */
    void up(@NotNull @Valid BitUpStartRequest request);

//    void down(@NotNull @Valid BitUpTerminateRequest request);

    void shutdown(@NotNull @Valid BitUpTerminateRequest request);

//    void createUserSecurityGroup(@NotNull @Valid BitUpTerminateRequest request);
}
