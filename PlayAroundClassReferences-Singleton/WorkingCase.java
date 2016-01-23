
public class WorkingCase {
 public static void main(String args[]){
	 MySingleton aObj = MySingleton.getInstance();
	 System.out.println("aObj hashcode::::: "+aObj.hashCode());
	 
	 aObj.close();
	 aObj = null;
	// MySingleton.printInstanceHashcode();
	 MySingleton bObj = MySingleton.getInstance();
	 System.out.println("bObj hashcode::::: "+bObj.hashCode());
	 MySingleton.printInstanceHashcode();
 }
}
