package multithreading_practice;

public class MyThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		    Runnable th=new My_Thread();
		    Thread t=new Thread (th);
		    t.setPriority(10);
		    t.setName("F1");
		  My_Thread2 th2=new My_Thread2();
		  Thread t2=new Thread (th2);
 		  t2.setName("F2");
 		  t.start();
	   
 		  t2.start();
 		  for(int i=0;i<4;i++)
 		  {
	    	System.out.println("Main Method :"+Thread.currentThread().getName());
 		  }
		
	}

}