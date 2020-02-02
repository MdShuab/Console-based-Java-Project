package bank_transaction;

public class Shuaib extends Thread{
   
	 Account k;
	    int amt;
	    Shuaib(Account a,int amt){
	    	this.k=a;
	    	this.amt=amt;
	    }
		public void run(){
			k.deposite(amt);
			
			
		}
}
