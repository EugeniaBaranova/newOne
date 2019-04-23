import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

public class ClientSide {
	
	private static Addition additionStub;

	public static void main(String[] args) 
		throws MalformedURLException, RemoteException, NotBoundException {
				
		additionStub = (Addition) Naming.lookup("//localhost/MyServer");
		
		String userResponse = JOptionPane.showInputDialog("Do you what to know what time will be in five hours?");
		if(userResponse != null && userResponse.equalsIgnoreCase("yes")) {
			LocalDateTime response = additionStub.addFiveHours(LocalDateTime.now());
			JOptionPane.showMessageDialog(null, response);
		} else {
			String secondUserResponse = JOptionPane.showInputDialog("Do you what to know what time will be in five hours from the entered time?");
			if(secondUserResponse != null && secondUserResponse.equalsIgnoreCase("yes")) {
				String inputedYear = JOptionPane.showInputDialog("Enter year (1990 - 2030)");
				String inputedMonth = JOptionPane.showInputDialog("Enter month (1-12)");
				String inputedDayOfMonth = JOptionPane.showInputDialog("Enter dayOfMonth (1-31)");
				String inputedHour = JOptionPane.showInputDialog("Enter hour (0-23)");
				String inputedMinute = JOptionPane.showInputDialog("Enter minute (0-59)");
				String inputedSecond = JOptionPane.showInputDialog("Enter second (0-59)");
				
				Integer year = convertToInt(inputedYear, 1990, 2030);
				Integer month = convertToInt(inputedMonth, 1, 12);
				Integer dayOfMonth = convertToInt(inputedDayOfMonth, 1, 31);
				Integer hour = convertToInt(inputedHour, 0, 23);
				Integer minute = convertToInt(inputedMinute, 0, 59);
				Integer second = convertToInt(inputedSecond, 0, 59);
				if(year!=null && month!=null && dayOfMonth!=null && hour!=null && minute!=null && second!=null) {
					LocalDateTime inputedDateTime = LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
					LocalDateTime response = additionStub.addFiveHours(inputedDateTime);
					JOptionPane.showMessageDialog(null, response);
				} else {
					JOptionPane.showMessageDialog(null, "You didn't enter valid information.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "You didn't enter 'yes'.");
			}
		}
	}
	
	public static Integer convertToInt(String stringValue, int minIntValue, int maxIntValue) {
		if(stringValue != null && !stringValue.isEmpty()) {
			int integerValue = Integer.valueOf(stringValue);
			if(integerValue>=minIntValue && integerValue<=maxIntValue) {
				return integerValue;
			}
		}
		return null;
	}

}
