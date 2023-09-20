package util;
import java.sql.Connection;
public class ConnectionSharing {
	private ThreadLocal<Connection> connectionSharing = new ThreadLocal<Connection>();
	private static ConnectionSharing instance = new ConnectionSharing();
	private ConnectionSharing() {}
	public static ConnectionSharing getInstance() {
		return instance;
	}
	public void set(Connection con) {
		connectionSharing.set(con);
	}
	public Connection get() {
		return connectionSharing.get();
	}
	public void remove() {
		connectionSharing.remove();
	}
}