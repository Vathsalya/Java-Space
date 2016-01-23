public class MySingleton {

	private MySingleton(){
		
	}
	private static MySingleton instance = null; 
	
	public static MySingleton getInstance(){
		if(instance==null){
			instance = new MySingleton();
		}
		printInstanceHashcode();
		//System.out.println("hashcode: "+instance.hashCode());
		return instance;
	}
	
	public void close(){
		System.out.println("Close instance with hashcode::::"+instance.hashCode());
		instance = null;
	}
	
	
	
	public static void printInstanceHashcode(){
		System.out.println("MySingleton::::instance-hashcode: "+instance.hashCode());
		
	}

}
