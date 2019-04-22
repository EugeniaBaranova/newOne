import java.rmi.Naming;

public class AdditionServer {
	
	public static void main (String[] argv) {
		 try {			   
			   Addition addition = new AdditionImpl();			   		   			 
			   Naming.rebind("//localhost/MyServer", addition);
			   System.out.println("Addition Server is ready.");
		 }catch (Exception e) {
			 	System.out.println("Addition Server failed: " + e);
		 }
	}
}
