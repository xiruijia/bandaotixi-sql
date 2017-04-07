package cc.bandaotixi.tools.sql.info;

public interface Connection {
	java.sql.Connection getConnection();
	String getHost();
	Integer getPort();
	String getUsername();
	String getPassword();
	boolean isConnectioned();
}
