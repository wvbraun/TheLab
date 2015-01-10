using System;

enum AccountState {
	New, 
	Active,
	UnderAudit,
	Frozen,
	Closed
};

struct Account {
	public AccountState State;
	public string Name;
	public string Address;
	public int AccountNumber;
	public int Balance;
	public int Overdraft;
};

class Bank {
	public void PrintAccount (Account a) {
		Console.WriteLine("Name: " + a.Name);
		Console.WriteLine("Overdraft: " + a.Overdraft);
	}

	public static void Main() {
		Account bp;
		bp.State = AccountState.Active;
		bp.Name = "Brandon Peavler";
		bp.Address = "Home";
		bp.AccountNumber = 1234;
		bp.Balance = 0;
		bp.Overdraft = -1000;
		Console.WriteLine("Name is: " + bp.Name);
		Console.WriteLine("Balance is: " + bp.Balance);
		PrintAccount(bp);
	}

	
}
