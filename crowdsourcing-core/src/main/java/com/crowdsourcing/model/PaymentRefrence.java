package com.crowdsourcing.model;

import java.io.Serializable;

public class PaymentRefrence implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private CreditCard creditCard;
	private PayPalAccount payPalAccount;
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	public PayPalAccount getPayPalAccount() {
		return payPalAccount;
	}
	public void setPayPalAccount(PayPalAccount payPalAccount) {
		this.payPalAccount = payPalAccount;
	}
	@Override
	public String toString() {
		return "PaymentRefrence [creditCard=" + creditCard + ", payPalAccount="
				+ payPalAccount + "]";
	}
		
}
