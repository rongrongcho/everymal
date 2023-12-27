package com.myspring.stsproject.hosMyReplyInfo.vo;

import org.springframework.stereotype.Component;

@Component("replyVO")
public class ReplyVO {
	private int q_code;      
    private String q_date;    
    private String user_id;  
    private String q_title;  
    private String q_text;   
    private int a_code;      
    private String a_date;     
    private String a_title;  
    private String a_text;   
    private String user_code;
    private String hos_name; 
    private String petrace;  
    private String hos_id;   
    
    

    public ReplyVO() {
		
	}

 

    
    
    
	public int getQ_code() {
		return q_code;
	}




	public void setQ_code(int q_code) {
		this.q_code = q_code;
	}





	public String getUser_id() {
		return user_id;
	}



	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}



	public String getQ_title() {
		return q_title;
	}



	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}



	public String getQ_text() {
		return q_text;
	}



	public void setQ_text(String q_text) {
		this.q_text = q_text;
	}



	public int getA_code() {
		return a_code;
	}



	public void setA_code(int a_code) {
		this.a_code = a_code;
	}







	public String getQ_date() {
		return q_date;
	}

	public void setQ_date(String q_date) {
		this.q_date = q_date;
	}

	public String getA_date() {
		return a_date;
	}

	public void setA_date(String a_date) {
		this.a_date = a_date;
	}

	public String getA_title() {
		return a_title;
	}



	public void setA_title(String a_title) {
		this.a_title = a_title;
	}



	public String getA_text() {
		return a_text;
	}



	public void setA_text(String a_text) {
		this.a_text = a_text;
	}



	public String getUser_code() {
		return user_code;
	}



	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}



	public String getHos_name() {
		return hos_name;
	}



	public void setHos_name(String hos_name) {
		this.hos_name = hos_name;
	}



	public String getPetrace() {
		return petrace;
	}



	public void setPetrace(String petrace) {
		this.petrace = petrace;
	}



	public String getHos_id() {
		return hos_id;
	}



	public void setHos_id(String hos_id) {
		this.hos_id = hos_id;
	}
    
    
   



	


    
    
    
}
