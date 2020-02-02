package object_class;

public class ObjectClass {
   
	int id;
	String name;
	public ObjectClass(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	void details(){
		
		System.out.println("name: "+name);
		System.out.println("id: "+id);
	}
	public int hashCode(){
		return id;
	} 
	
	public boolean equals (Object o){
		return this.hashCode()==o.hashCode();
	}
	
  	public String toString(){
		return name+" "+id+" toStringMethod";
	}
	
	protected void finalize(){
		
		System.out.println("Student Object is dereffered it is collected bt GC.");
	}
	
}
