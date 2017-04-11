package com.vasanth.client;

public class Country {

	private String id;
	private String code;
	private String paypalsupport;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String isPaypalsupport() {
		return paypalsupport;
	}
	public void setPaypalsupport(String paypalsupport) {
		this.paypalsupport = paypalsupport;
	}
	@Override
	public String toString() {
		return "Country [id=" + id + ", code=" + code + ", paypalsupport=" + paypalsupport + "]";
	}
	
	
	
}
