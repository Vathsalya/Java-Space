package ExceptionHandling;

import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.Random;

import com.sun.org.apache.xerces.internal.impl.xpath.XPathException;

public class NestedExceptionUsage {

	public static void main(String[] args) {
		NestedExceptionUsage ex = new NestedExceptionUsage();
		for (int i = 0; i < 10; i++)
			ex.method1();
	}

	private void method1() {
		method2();
	}

	private void method2() {
		method3();
	}

	private void method3() {
		try {
			method4();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (XPathException e) {
			e.printStackTrace();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	private void method4() throws RemoteException, ClassNotFoundException, XPathException, CloneNotSupportedException {
		try {
			method5();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			throw new RemoteException(e.getMessage());
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException(e.getMessage());
		} catch (XPathException e) {
			throw new XPathException(e.getMessage());
		} catch (CloneNotSupportedException e) {
			throw new CloneNotSupportedException(e.getMessage());
		} catch (Exception e){
			System.out.println("This is a unchecked exception: "+e.getMessage());
		}
	}

	private void method5() throws FileNotFoundException, ClassNotFoundException, XPathException, RemoteException,
			CloneNotSupportedException {
		Random r = new Random();

		switch (r.nextInt(9)) {
		case 0:
			throw new ArrayIndexOutOfBoundsException();
		case 1:
			throw new ClassCastException();
		case 2:
			throw new NumberFormatException();
		case 3:
			throw new NullPointerException();
		case 4:
			throw new StringIndexOutOfBoundsException();
		case 5:
			throw new FileNotFoundException();
		case 6:
			throw new ClassNotFoundException();
		case 7:
			throw new XPathException();
		case 8:
			throw new RemoteException();
		case 9:
			throw new CloneNotSupportedException();
		}
	}

}
