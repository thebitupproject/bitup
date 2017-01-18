package io.bit.up.pojo;

import javax.validation.constraints.NotNull;

public class BitUpShutdownRequest {

	@NotNull
	private String instanceId;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }
}
