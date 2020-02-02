package multithreading_byExtendThread;

public class Demo extends Thread{
	Resource r; int n;
	Demo(Resource r,int n){
		this.r=r;
		this.n=n;
	}
	 public void run(){
	       
		 r.print(n);
     }  
	  
	

}
