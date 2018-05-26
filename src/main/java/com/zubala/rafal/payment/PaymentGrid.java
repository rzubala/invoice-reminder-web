package com.zubala.rafal.payment;

import java.util.List;

import com.zubala.rafal.entity.Payment;

public class PaymentGrid {
	
	private int draw;
	
	private int recordsTotal;
	
	private int recordsFiltered;
	
	private List<Payment> data;

	public List<Payment> getData() {
		return data;
	}

	public void setData(List<Payment> data) {
		this.data = data;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
}
