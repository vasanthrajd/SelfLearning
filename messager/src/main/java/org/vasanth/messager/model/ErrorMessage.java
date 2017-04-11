package org.vasanth.messager.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private String errMsg;
	private int errCode;
	private String documentation;
	public ErrorMessage(String errMsg, int errCode, String documentation) {
		super();
		this.errMsg = errMsg;
		this.errCode = errCode;
		this.documentation = documentation;
	}
	
	public ErrorMessage(){
		
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
	
}
