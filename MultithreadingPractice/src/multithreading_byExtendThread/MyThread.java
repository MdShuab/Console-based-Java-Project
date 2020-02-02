package multithreading_byExtendThread;

public class MyThread  {
 
  public static void main(String[] args) {
	  Resource r=new Resource();
	  Demo d1=new Demo(r,2);
	  Demo d2=new Demo(r,3);
	  d1.setName("1st Thead: ");
      d2.setName("2nd Thead: ");
	  d1.start();
	  d2.start();
	 	  
  }	
}