package object_class;

public class MainClasss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ObjectClass ob1=new ObjectClass(12,"Shuaib");
		ObjectClass ob2=new ObjectClass(12,"Shuaib");
		
		System.out.println(ob1.hashCode());
		System.out.println(ob2.hashCode());
		System.out.println(ob1.equals(ob2));
		System.out.println(ob1);
		System.out.println(ob2);
		
		ob1=null;
		ob2=null;
		
		System.gc();
		
		
		System.out.println(ob1);
		System.out.println(ob2);
		
		
	}

}
