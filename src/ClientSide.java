import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalTime;

import javax.swing.JOptionPane;

public class ClientSide {
	
	private static Addition addition;

	public static void main(String[] args) 
		throws MalformedURLException, RemoteException, NotBoundException {
				
		addition = (Addition) Naming.lookup("//localhost/MyServer");
		String userResponse = JOptionPane.showInputDialog("Do you what to know what time will be in five hours?");
		if(userResponse != null && userResponse.equalsIgnoreCase("yes")) {
			LocalTime response = addition.addFiveHours(LocalTime.now());
			JOptionPane.showMessageDialog(null, response);
		} else {
			JOptionPane.showMessageDialog(null, "You didn't entered 'yes'.");
		}
	}

}
