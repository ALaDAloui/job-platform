package com.itgate.demo.models;

import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Mail {

	
	private String from;
	private String to;
	private String subject;
	private String content;
	private String url ;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date date ;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh-mm AA")
	private String time ;
	
	
	 

	

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Mail() {
	}

	

	public Mail(String from, String to, String subject, String content, String url, Date date, String time) {
		super();
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.content = content;
		this.url = url;
		this.date = date;
		this.time = time;
	}

	public String getFrom() {
	    return from;
	}

	public void setFrom(String from) {
	    this.from = from;
	}

	public String getTo() {
	    return to;
	}

	public void setTo(String to) {
	    this.to = to;
	}

	public String getSubject() {
	    return subject;
	}

	public void setSubject(String subject) {
	    this.subject = subject;
	}

	public String getContent() {
	    return content;
	}

	public void setContent(String content) {
	    this.content = content;
	}

	@Override
	public String toString() {
		return "Mail [from=" + from + ", to=" + to + ", subject=" + subject + ", content=" + content + ", url=" + url
				+ ", date=" + date + ", time=" + time + "]";
	}

	

}
