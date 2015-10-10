package gamesrc;

public class Bank {
	private int accountAmount = 0;

	public Bank(int initAmount) {
		accountAmount = initAmount;
	}

	public void setAmount(int amount) {
		accountAmount = amount;
	}
	
	public void changeAmount(int amount){
		accountAmount += amount;
	}
	
	public int getAmount(){
		return accountAmount;
	}

}
