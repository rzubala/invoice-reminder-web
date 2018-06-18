package com.zubala.rafal.payment;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.zubala.rafal.validation.PaymentAmount;

public class PaymentData {

	private int id;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")	
	private String name;
	
	private String description;
	
	@NotNull(message="is required")
	private Date date;
	
	private String dateStr;

	@NotNull(message="is required")
	@PaymentAmount(message="must be positive number")
	private Double amount;
	
	@NotNull(message="is required")
	private String currency;
	
	private Boolean paid;
	
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

}
