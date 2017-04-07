package cc.bandaotixi.tools.sql.info;

import java.io.Serializable;
import java.sql.SQLException;

import com.alibaba.druid.pool.DruidPooledConnection;

import cc.bandaotixi.tools.sql.config.Log;

public class MysqlConnection implements Serializable,cc.bandaotixi.tools.sql.info.Connection{
	private static final long serialVersionUID = 1L;
	private String name;
	private String host="127.0.0.1";
	private Integer port=3306;
	private String username;
	private String password;
	private volatile DruidPooledConnection dataPool;
	private volatile com.alibaba.druid.pool.DruidDataSource dataSource;
	private volatile boolean connectioned=false;
	private volatile java.sql.Connection connection;
	
	public MysqlConnection() {
		super();
	}
	
	public MysqlConnection(String name) {
		this();
		this.name = name;
	}
	
	public MysqlConnection(String host, Integer port, String username, String password) {
		this(host);
		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHost() {
		host="jdbc:mysql://"+host+":"+port+"?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true";
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isConnectioned() {
		if(connection==null)return false;
		return connectioned;
	}

	public void setConnectioned(boolean connectioned) {
		this.connectioned = connectioned;
	}

	@Override
	public String toString() {
		return name;
	}
	@Override
	public java.sql.Connection getConnection() {
		if(isConnectioned()){
			return connection;
		}
		if(dataSource==null){
			dataSource=new com.alibaba.druid.pool.DruidDataSource();
			dataSource.setUrl(getHost());
			dataSource.setUsername(getUsername());
			dataSource.setPassword(getPassword());
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			Log.info("初始化dataSource...");
		}
		try {
			if(dataPool==null){
				dataPool=dataSource.getConnection();
				Log.info("初始化dataPool...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		setConnectioned(true);
		connection= dataPool.getConnection();
		return connection;
	}

}
