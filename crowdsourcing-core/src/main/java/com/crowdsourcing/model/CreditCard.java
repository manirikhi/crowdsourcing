package com.crowdsourcing.model;

import java.io.Serializable;

public class CreditCard implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String cardHolderName;
	private String cardNumber;
	private String expiryMonth;
	private String expiryYear;
	private String securityNumber;
	
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public String getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}
	public String getSecurityNumber() {
		return securityNumber;
	}
	public void setSecurityNumber(String securityNumber) {
		this.securityNumber = securityNumber;
	}
	@Override
	public String toString() {
		return "CreditCard [cardHolderName=" + cardHolderName + ", cardNumber="
				+ cardNumber + ", expiryMonth=" + expiryMonth + ", expiryYear="
				+ expiryYear + ", securityNumber=" + securityNumber + "]";
	}	
	
}
