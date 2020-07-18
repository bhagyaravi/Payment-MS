package com.test.quarkus.model;

import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;
@Entity
public class Payment extends PanacheEntityBase {

	@Id
	@GeneratedValue
	UUID id;
	
	String paymentType;
	String cardnumber;
	Date expiryDate;
	int cvvnumber;
	long amount;
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public UUID getPaymentId() {
		return this.id;
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
