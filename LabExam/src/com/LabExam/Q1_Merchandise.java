package com.LabExam;
class Merchandise{
	private String itemCode;
	private int quantity;
	private double unitPrice;
	
	Merchandise(String itemCode,int quantity, double unitPrice){
		this.itemCode=itemCode;
		this.quantity=quantity;
		this.unitPrice = unitPrice;
	}
	
	
	public String getCode() {
		return itemCode;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getPrice() {
		return unitPrice;
	}
	
	public void print() {
		System.out.println(itemCode +" " + quantity + " " + unitPrice);
	}
	
}
public class Q1_Merchandise {
	public static void main(String[] args) {
		
	}
	
}
