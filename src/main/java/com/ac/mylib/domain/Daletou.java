package com.ac.mylib.domain;

import java.util.List;

public class Daletou {

	private String numberId;
	private List<String> frontFiveNumber;
	private List<String> backTwoNumber;
	
	public String getNumberId() {
		return numberId;
	}
	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}
	public List<String> getFrontFiveNumber() {
		return frontFiveNumber;
	}
	public void setFrontFiveNumber(List<String> frontFiveNumber) {
		this.frontFiveNumber = frontFiveNumber;
	}
	public List<String> getBackTwoNumber() {
		return backTwoNumber;
	}
	public void setBackTwoNumber(List<String> backTwoNumber) {
		this.backTwoNumber = backTwoNumber;
	}
	
	@Override
	public String toString() {
		return "Daletou [numberId=" + numberId + ", frontFiveNumber=" + frontFiveNumber + ", backTwoNumber="
				+ backTwoNumber + "]";
	}
	
}
