package Reflection;

public class ReflectionAPIUsage {

	public static void main(String[] args) {
		ReflectionAPIUsage reflectionUsage = new ReflectionAPIUsage();
		Class<?> c;
		try {
			c = Class.forName("java.util.HashMap");
			reflectionUsage.printClassesAndInterfaces(c);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method to print the super class of the mentioned class and interfaces
	 * that they implements
	 * 
	 * @param c
	 */
	public void printClassesAndInterfaces(Class<?> c) {
		do {
			System.out.println("Class: " + c);
			Class<?>[] interfaces = c.getInterfaces();
			if (interfaces != null && interfaces.length != 0) {
				System.out.println("Interfaces implemented: ");
				for (Class<?> interfaceName : interfaces) {
					System.out.println(interfaceName.getSimpleName());
				}
			} else {
				System.out.println("This class does not implement any interfaces");
			}
			c = c.getSuperclass();

		} while (c != null);

	}
	
}

/* Sample output:
Class: class java.util.HashMap
Interfaces implemented: 
Map
Cloneable
Serializable
Class: class java.util.AbstractMap
Interfaces implemented: 
Map
Class: class java.lang.Object
This class does not implement any interfaces

 */
