package bank_transaction;

public class Account {
    int bal=500;
    int amt;
  synchronized	void withdraw(int amt){
		this.amt=amt;
		if(amt>bal){
			System.out.println("Insufficient Balance.");
			System.out.println("Hello! "+Thread.currentThread().getName()+" Wait for deposite.");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(bal>amt){
		bal=bal-amt;
		
		System.out.println(Thread.currentThread().getName()+" "+amt+" Withdraw!");
		System.out.println("Available bal "+bal);
		}
		else
			System.out.println("Sorry "+ Thread.currentThread().getName()+" Insufficient! Balance");
		
		
	}
  synchronized void deposite(int amt){
	  if(bal<this.amt){
	  bal=bal+amt;
	  System.out.println(Thread.currentThread().getName()+" Deposite Successfully!");
	  }
	  else if(bal>this.amt)
		  System.out.println("Hii! "+Thread.currentThread().getName()+" No need to deposite");
	  notify();
  }
	
}
