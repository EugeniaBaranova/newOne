import java.rmi.*;
import java.time.LocalTime;

public interface Addition extends Remote {
	
	public LocalTime addFiveHours(LocalTime time) throws RemoteException;
}
