package com.LabExam;

import java.util.Scanner;



abstract class Account{
		private Owner owner;
		protected float balance ;
		private String number;
		
		public Account(){
			this.owner = new Owner();
			this.balance = 0;
			this.number = "12345678";			
		}
		
		public Account(Owner owner, String number, float balance) {
			this.owner = owner;
			this.number=number;
			this.balance=balance;
		}
		public Account(Account A) {
			this.owner = A.owner;
			this.number=A.number;
			this.balance=A.balance;
		}
		public float getBalance() {
			return balance;
		}
		public void setBalance (float balance) {
			this.balance = balance;
		}
		public void input() {
			Scanner scan = new Scanner(System.in);

			System.out.print("Enter Owner's details: ");
			this.owner = new Owner();
			owner.input();
			
			System.out.print("Enter balance: ");
			this.balance = scan.nextFloat();
			scan.nextLine();
			System.out.print("Enter number: ");
			this.number = scan.nextLine();
		
		}
		
		public void print() {
//			System.out.println(name + " - " );
			owner.print();
			System.out.println("balance is: " + getBalance());
			System.out.println("Account number is : " +number);
			System.out.println("-----------------------------------");
		}
		public void deposit(float amount) {
//			if(amount < 0) throw new NegativeInputException("Amount to be deposited can't be negative");
			balance = balance+amount;
		}
		
		public void withdraw(float amount) {
			balance = balance- amount;
		}
		abstract public void calculateAmount();
		
}


class SavingAccount extends Account{
	private float interestRate;
	
	public SavingAccount() {
		super();
		interestRate = 5;
	}
	public SavingAccount(SavingAccount SA) {
		super(SA);
		this.interestRate= SA.interestRate;
	}
	public float getInterest() {
		return interestRate;
	}
	@Override
	public void input() {
		super.input();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter interest rate: ");
        this.interestRate = scan.nextFloat();
	}
	@Override
	public void print() {
		super.print();
		System.out.println("Interest rate is : " +interestRate);
		System.out.println("----------------------------------------");
	}
	
	@Override
	public void deposit(float amount) {
//			throws NegativeInputException
	
//		if(amount < 0) throw new NegativeInputException("Amount to be deposited can't be negative");
		balance = balance+amount;
	}
	@Override
	public void calculateAmount(){
		setBalance(balance + (balance * interestRate/100));
	}
	
	
}


class CurrentAccount extends Account{
	private float minimumBalance;
	final private float charges= 1000;
	public CurrentAccount() {
		super();
		minimumBalance= 5000;
	}
	public CurrentAccount(CurrentAccount CA) {
		super(CA);
		this.minimumBalance= CA.minimumBalance;
	}
	public float getCharges() {
		return charges;
	}
	@Override
	public void input() {
		super.input();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter minimumBalance : ");
        this.minimumBalance = scan.nextFloat();
	}
	@Override
	public void print() {
		super.print();
		System.out.println("Minimum balance required is : " + minimumBalance);
		System.out.println("----------------------------------------");
	}

	@Override
	public void withdraw(float amount) {
	    if (amount <= getBalance() - minimumBalance) {
	        setBalance(getBalance() - amount);
	    } else {
	        System.out.println("Withdrawal denied! Minimum balance must remain.");
	    }
	}

	@Override
	public void calculateAmount() {
	    if (getBalance() < minimumBalance) {
	        setBalance(getBalance() - charges);
	    }
	}

}



public class Q2_Account {
	
}
