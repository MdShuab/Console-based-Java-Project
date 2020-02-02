package multithreading_practice;

public class My_Thread2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
			
			
				System.out.println("1 :"+Thread.currentThread().getName()+"  "+Thread.currentThread().getPriority());
				System.out.println("2 :"+Thread.currentThread().getName()+"  "+Thread.currentThread().getPriority());
				System.out.println("3 :"+Thread.currentThread().getName()+"  "+Thread.currentThread().getPriority());
				System.out.println("4 :"+Thread.currentThread().getName()+"  "+Thread.currentThread().getPriority());
				
	}

}
