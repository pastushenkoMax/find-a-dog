package com.codingdojo.sp.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MessageEmail {
	
	private String toEmail;
	private String subject;
    @Size(min=0, max=200)
	private String body;
	@NotEmpty(message="Name is required!")
	private String fromName;
	@NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String fromEmail;
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	
	public MessageEmail() {}
	public MessageEmail(String toEmail, String subject, String body,String fromName, String fromEmail) {
		this.toEmail = toEmail;
		this.subject = subject;
		this.body = body;
		this.fromName = fromName;
		this.fromEmail = fromEmail;
	}
	
	
	
	
}
