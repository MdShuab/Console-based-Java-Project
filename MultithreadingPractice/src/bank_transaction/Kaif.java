package bank_transaction;

public class Kaif extends Thread{
    Account k;
    int amt;
    Kaif(Account a,int amt){
    	this.k=a;
    	this.amt=amt;
    }
	public void run(){
		k.withdraw(amt);
		
		
	}
}
