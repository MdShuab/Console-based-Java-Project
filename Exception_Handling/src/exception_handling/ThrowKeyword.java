package exception_handling;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class ThrowKeyword {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
			
				try {
					Throw.setAge(-12);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					//System.out.println( e.getMessage());
					e.printStackTrace();
					
				}
			
				
			
		
		Throw.getAge();

	}

}
class Throw{
	static int i;
	static void setAge(int a)throws FileNotFoundException{
		
							if(a>0)
							{
								i=a;
							}
							else {
								throw new FileNotFoundException("invalid Agenn");
							}
	           }
		static void getAge(){
			
			System.out.println("Age :"+i);
		}
	
	
}



