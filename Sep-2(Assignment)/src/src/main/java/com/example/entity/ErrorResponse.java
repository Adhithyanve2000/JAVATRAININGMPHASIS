package com.example.entity;

import java.time.LocalDateTime;

public class ErrorResponse {
	
	// Fields
	int status;
	String message;
	LocalDateTime timeStamp;
	
	// Getters & Setters
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

}
