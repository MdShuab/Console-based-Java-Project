package multithreading_byExtendThread;

public class Resource {

	 public void  print(int n) 
	{  
		for(int i=1;i<=5;i++)
		{
			System.out.println(Thread.currentThread().getName()+"Print "+n+" table: "+i*n);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
}
