package io.bit.up.test.builder;

import io.bit.up.pojo.BitUpStartRequest;

public class BitUpRequestBuilder {
	
	private String securityGroups;
	private String keyName;
	private String imageId;
	private String instanceType;
	
	public BitUpRequestBuilder withSecurityGroups(String secutyGroups) {
		this.securityGroups = secutyGroups;
		return this;
	}
	
	public BitUpRequestBuilder withKeyName(String keyName) {
		this.keyName = keyName;
		return this;
	}
	
	public BitUpRequestBuilder withImageId(String imageId) {
		this.imageId = imageId;
		return this;
	}
	
	public BitUpRequestBuilder withInstanceType(String instanceType) {
		this.instanceType = instanceType;
		return this;
	}
	
	public BitUpStartRequest build() {
		BitUpStartRequest request = new BitUpStartRequest();
		request.setSecurityGroups(this.securityGroups);
		request.setKeyName(this.keyName);
		request.setImageId(this.imageId);
		request.setInstanceType(this.instanceType);
		
		return request;
	}
}
