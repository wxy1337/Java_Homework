package com;

public class SelfException extends Exception{
	private String reason;
	
    public SelfException(){
        super();
    }
    
    public SelfException(String reason) {
    	this.reason = reason;
    	System.out.println("�����쳣 ԭ��"+ reason);
    }
    
    public String getReason() {
    	return reason;
    }
    
    
}