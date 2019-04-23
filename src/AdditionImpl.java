import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;

public class AdditionImpl extends UnicastRemoteObject implements Addition {

	private static final long serialVersionUID = 1L;

	protected AdditionImpl() throws RemoteException {
		super();
	}

	@Override
	public LocalDateTime addFiveHours(LocalDateTime dateTime) throws RemoteException {
		System.out.println("Someone asked a date-time in five hours");
		return dateTime.plusHours(5);
	}	

}
