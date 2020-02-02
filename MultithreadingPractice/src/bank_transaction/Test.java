package bank_transaction;

public class Test {

	public static void main(String[] args) {
		 Account ac=new Account();
		 Kaif k=new Kaif(ac,2000);
		 Shuaib s=new Shuaib(ac,22000);
		 k.setName("Kaif");
		 s.setName("Shuaib");
		 k.start();
		 s.start();
	}
}
