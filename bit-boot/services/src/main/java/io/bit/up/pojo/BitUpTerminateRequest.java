package io.bit.up.pojo;

import javax.validation.constraints.NotNull;

public class BitUpTerminateRequest {

	@NotNull
	private String instanceId;

    public String getInstanceId() {
        return instanceId;
    }

}
