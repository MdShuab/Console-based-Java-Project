package multithreading_practice;

public class My_Thread implements Runnable {
	
		public void run() {
			System.out.println("A :"+Thread.currentThread().getName()+"  "+Thread.currentThread().getPriority());
			System.out.println("B :"+Thread.currentThread().getName()+"  "+Thread.currentThread().getPriority());
			System.out.println("C :"+Thread.currentThread().getName()+"  "+Thread.currentThread().getPriority());
			System.out.println("D :"+Thread.currentThread().getName()+"  "+Thread.currentThread().getPriority());
		
		}
}

 
