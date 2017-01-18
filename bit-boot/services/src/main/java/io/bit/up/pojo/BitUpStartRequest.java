package io.bit.up.pojo;

import javax.validation.constraints.NotNull;

public class BitUpStartRequest {

	@NotNull
	private String imageId;

	@NotNull
	private String instanceType;

	@NotNull
	private String keyName;

	@NotNull
	private String securityGroups;

	public String getImageId() {
		return imageId;
	}

	public String getInstanceType() {
		return instanceType;
	}

	public String getKeyName() {
		return keyName;
	}

	public String getSecurityGroups() {
		return securityGroups;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public void setInstanceType(String instanceType) {
		this.instanceType = instanceType;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public void setSecurityGroups(String securityGroups) {
		this.securityGroups = securityGroups;
	}

}
