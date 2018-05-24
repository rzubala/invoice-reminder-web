package com.zubala.rafal.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="payment")
public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date;
	
	@Transient
	private String dateStr;

	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private CustomUser user;

	public Payment() {		
	}	
	
	public Payment(int id, String name, String description, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
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

	public CustomUser getUser() {
		return user;
	}

	public void setUser(CustomUser user) {
		this.user = user;
	}

	public String getDateStr() {
		if (date == null) {
			return "";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		return dateFormat.format(date);
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", name=" + name + ", description=" + description + ", date=" + date + "]";
	}
}
