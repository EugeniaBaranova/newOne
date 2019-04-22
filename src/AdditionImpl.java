import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalTime;

public class AdditionImpl extends UnicastRemoteObject implements Addition {

	private static final long serialVersionUID = 1L;

	protected AdditionImpl() throws RemoteException {
		super();
	}

	@Override
	public LocalTime addFiveHours(LocalTime time) throws RemoteException {
		System.out.println("Someone asked a time in five hours");
		return time.plusHours(5);
	}	

}
