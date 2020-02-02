package exception_handling;

public class MultipleException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n1=20,n2=5,r=0;
		int x[]={2,0,4,6};
		System.out.println("Hello");
		exit(0);
		try{
			
			r=n1/n2;
			System.out.println("Division= "+r);
			System.out.println("Hii");
			System.out.println(x[2]);
			
		}
		catch(ArithmeticException|ArrayIndexOutOfBoundsException e){
			
			e.printStackTrace();
		    System.out.println("Catch Block"); 
		}
		finally{
			System.out.println("finally Block");
		}
		
		System.out.println("end of try Block");
		

	}

	private static void exit(int i) {
		// TODO Auto-generated method stub
		
	}

}
