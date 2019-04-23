import java.rmi.*;
import java.time.LocalDateTime;

public interface Addition extends Remote {
	
	public LocalDateTime addFiveHours(LocalDateTime dateTime) throws RemoteException;
}
