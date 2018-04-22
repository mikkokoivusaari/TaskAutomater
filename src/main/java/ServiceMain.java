import TaskAutomater.DataAccess.ConnectionHandler;

public class ServiceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionHandler conn = new ConnectionHandler();
		try {
			conn.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
