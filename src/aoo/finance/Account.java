package aoo.finance;

public class Account {
	
	private int accountId;
	private double balance;
	private String accountType;
	private double limit;
	
	public Account(int accountId, double balance, String accountType) {
		this.accountId = accountId;
		this.balance = balance;
		this.accountType = accountType;
	}
	
	public Account(int accountId, double balance, String accountType, double limit) {
		this(accountId, balance, accountType);
		this.limit = limit;
	}
	
	public boolean deposit(double amount) {
		return (amount > 0 ? updateBalance(amount) : false);
	}
	
	public boolean withdraw(double amount) {
		return (amount > 0 && balance - amount > limit ? updateBalance(amount * -1) : false);
	}
	
	private boolean updateBalance(double amount) {
		this.balance += amount;
		return true;
	}

	public double getBalance() {
		return balance;
	}

}
