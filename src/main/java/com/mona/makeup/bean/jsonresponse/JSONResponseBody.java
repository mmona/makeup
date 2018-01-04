package com.mona.makeup.bean.jsonresponse;

import org.apache.commons.lang.StringUtils;


public class JSONResponseBody {

	public static String SUCCESS="SUCCESS";
	public static String FAILED="FAILED";
	public static String ERROR="ERROR";
	public static String SESSION_TIMEOUT="SESSIONTIMEOUT";
	
	private String status;
	private String message;
	private String redirect;
	
	public JSONResponseBody(){
		this.status=FAILED;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		if(StringUtils.isBlank(message)){
			if(status.equals(SUCCESS)){
				message=SUCCESS;
			}else if(status.equals(FAILED)){
				message=FAILED;
			}else if(status.equals(ERROR)){
				message=ERROR;
			}
		}
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static JSONResponseBody error(String message){
		JSONResponseBody bean=new JSONResponseBody();
		bean.setMessage(message);
		bean.setStatus(ERROR);
		return bean;
	}

	public static JSONResponseBody failed(String message){
		JSONResponseBody bean=new JSONResponseBody();
		bean.setMessage(message);
		bean.setStatus(FAILED);
		return bean;
	}
	
	public static JSONResponseBody success(String message){
		JSONResponseBody bean=new JSONResponseBody();
		bean.setMessage(message);
		bean.setStatus(SUCCESS);
		return bean;
	}
	
	public JSONResponseBody setSuccess(){
		this.setStatus(SUCCESS);
		return this;
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}
	
}
