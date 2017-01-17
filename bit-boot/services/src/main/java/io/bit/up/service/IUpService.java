package io.bit.up.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import io.bit.up.pojo.BitUpRequest;

/**
 * Process the requests to manage bit instances in the cloud.
 * <p>
 * 
 * @author atuffrea
 *
 */
@Validated
public interface IUpService {

	/**
	 * Enable to launch a new instance in bit's cloud.
	 * 
	 * @param request
	 *            the configuration of the instance to launch
	 */
	public void up(@NotNull @Valid BitUpRequest request);

}
