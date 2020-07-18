package com.test.quarkus.model;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.util.Date;

@Entity
public class Payment extends PanacheEntity {

	long paymentId;
	String paymentType;
	String cardnumber;
	Date expiryDate;
	int cvvnumber;
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public int getCvvnumber() {
		return cvvnumber;
	}
	public void setCvvnumber(int cvvnumber) {
		this.cvvnumber = cvvnumber;
	}
	
	
	
}
