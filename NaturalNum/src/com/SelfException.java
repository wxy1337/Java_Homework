package com;

public class SelfException extends Exception{
	private String reason;
	
    public SelfException(){
        super();
    }
    
    public SelfException(String reason) {
    	this.reason = reason;
    	System.out.println("输入异常 原因："+ reason);
    }
    
    public String getReason() {
    	return reason;
    }
    
    
}