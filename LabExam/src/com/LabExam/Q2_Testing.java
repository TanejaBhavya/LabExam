package com.LabExam;

public class Q2_Testing {
	public static void main(String[] args) {
        Date d1 = new Date(1, 1, 2026);
        System.out.print("Date object: ");
        d1.print();  // should print 1/1/2026

        // -----------------------------
        // Test Owner class
        // -----------------------------
        Owner o1 = new Owner("John", "123456789V", d1);
        System.out.print("Owner object: ");
        o1.print();

        // -----------------------------
        // Test Account class (using SavingAccount)
        // -----------------------------
        SavingAccount sa = new SavingAccount();
        sa.setBalance(10000);   // initial balance
        System.out.println("Saving Account balance before interest: " + sa.getBalance());

        sa.calculateAmount();   // apply interest
        System.out.println("Saving Account balance after interest: " + sa.getBalance());

        sa.deposit(5000);       // deposit
        System.out.println("Saving Account after deposit: " + sa.getBalance());

        sa.withdraw(2000);      // withdraw
        System.out.println("Saving Account after withdraw: " + sa.getBalance());

        sa.print();             // print full details

        // -----------------------------
        // Test CurrentAccount class
        // -----------------------------
        CurrentAccount ca = new CurrentAccount();
        ca.setBalance(8000);
        ca.input(); // set minimum balance

        System.out.println("\nCurrent Account balance before withdrawal: " + ca.getBalance());
        ca.withdraw(2500); // should be denied
        System.out.println("Balance after denied withdrawal: " + ca.getBalance());

        ca.withdraw(2000); // should be successful
        System.out.println("Balance after successful withdrawal: " + ca.getBalance());

        ca.print();

        // -----------------------------
        // Test calculateAmount for CurrentAccount
        // -----------------------------
        ca.setBalance(4000); // below minimum
        ca.calculateAmount(); // should deduct charges
        System.out.println("Balance after charges: " + ca.getBalance());
	}
}
