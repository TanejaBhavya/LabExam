package com.LabExam;

import java.util.Scanner;

class Date {
	private int day;
	private int month;
	private int year;

	public Date() {

	}

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public Date(Date d) {
		this.day = d.day;
		this.month = d.month;
		this.year = d.year;
	}

	public void input() {
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter day: ");
		this.day = scan.nextInt();

		System.out.print("Enter month: ");
		this.month = scan.nextInt();

		System.out.print("Enter year: ");
		this.year = scan.nextInt();
	}

	public void print() {
		System.out.println(day + "/" + month + "/" + year);
	}
}

class Owner {
	private String name;
	private Date DOB;
	private String nic;
	public Owner() {
		this.name= "N/A";
		this.DOB = new Date(1,1,2026);
		this.nic ="N/A";
		
	}
	public Owner(String name,String nic, Date DOB) {
		this.DOB = DOB;
		this.name = name;
		this.nic = nic;
	}
	
	public Owner(Owner o) {
		this.DOB=o.DOB;
		this.name=o.name;
		this.nic=o.nic;
	}
	public void input() {
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter name: ");
		this.name= scan.nextLine();

		System.out.print("Enter Date: ");
		this.DOB = new Date();
		this.DOB.input();

		System.out.print("Enter year: ");
		this.nic = scan.nextLine();
	}
	public void print() {
		System.out.println(name + " - " );
		DOB.print();
		System.out.println("-" + nic);
		System.out.println("-----------------------------------");
	}
}

public class Q2_UMLDiagram {

}
