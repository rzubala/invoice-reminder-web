package com.zubala.rafal.payment;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PaymentData {

	private int id;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")	
	private String name;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")	
	private String description;
	
	@NotNull(message="is required")
	private Date date;
	
	private String dateStr;

	public PaymentData() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

}
