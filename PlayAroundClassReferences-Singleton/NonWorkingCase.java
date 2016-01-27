
public class NonWorkingCase {
public static void main(String args[])
{
	 MySingleton a = MySingleton.getInstance();
	 System.out.println("a: "+a.hashCode());
	 
	 a.close();
	 
	
	 MySingleton b = MySingleton.getInstance();
	 System.out.println("b: "+b.hashCode());
	 MySingleton.printInstanceHashcode();
	 System.out.println("a: "+a.hashCode());
	 a.printInstanceHashcode();
	 b.close();
	// a.close();
	// MySingleton c = MySingleton.getInstance();
	// System.out.println("c: "+c.hashCode());
	// a.printInstanceHashcode();
	// b.printInstanceHashcode();
	 //c.printInstanceHashcode();

	 
}
}
