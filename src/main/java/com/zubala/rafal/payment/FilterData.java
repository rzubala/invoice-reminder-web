package com.zubala.rafal.payment;

import java.util.Date;

public class FilterData {
	private Boolean showPaid;
	
	private Date showFrom;
	
	private String filter;

	public Boolean getShowPaid() {
		return showPaid;
	}

	public void setShowPaid(Boolean showPaid) {
		this.showPaid = showPaid;
	}

	public Date getShowFrom() {
		return showFrom;
	}

	public void setShowFrom(Date showFrom) {
		this.showFrom = showFrom;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
}
