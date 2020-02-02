package pattern_programming;

public class Pattern1 {
     
	public static void m1(){
		
		for(int i=1;i<=5;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}

class Pattern2{
/*	1 
	2 2 
	3 3 3 
	4 4 4 4 
	5 5 5 5 5 */
	public static void m2(){
		int k=1;
		for(int i=1;i<=5;i++)     
		{
			for(int j=1;j<=i;j++)
			{ 
				System.out.print(k+" ");
			}
			System.out.println();
			k++;
		}
	}
}

class Pattern3{
	
	public static void m3(int n){
		 int k=0;
		
		 for(int i=1;i<=n;i++){
			
			for(int j=1;j<=k;j++)
			{ 
				System.out.print(j+" ");
			}
			System.out.println();
			
			if(i<=n/2)
			{
				k++;
			}
			else
				k--;
		}
	}
}

class Pattern4{
	
	public static void m4(int n){
		int k=n/2;
		for(int i=1;i<=n;i++)
		{System.out.print("Line No. "+i+" : ");
			for(int j=1;j<=k;j++)
			{
				System.out.print(" "+j+" ");
				
			}
			
			if(i<n/2)
				 k--;
			else if (i>n/2)
				k++;
			System.out.println();
			
		}
	}
}


class Pattern5{
	
	public static void m5(){
		int k=10/2;
		for(int i=1;i<=10;i++){
			
			for(int j=k;j>=1;j--)
				System.out.print(j+" ");
		
		if(i<10/2)
			k--;
		else if(i>10/2)
			k++;
		System.out.println();
		}
	}
}