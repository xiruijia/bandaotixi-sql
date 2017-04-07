package cc.bandaotixi.tools.mysql.panal;

import javax.swing.tree.DefaultMutableTreeNode;

import cc.bandaotixi.tools.sql.info.DataBaseInfo;
import cc.bandaotixi.tools.sql.info.MysqlConnection;

public class MysqlTreeView  extends DefaultMutableTreeNode{
	private static final long serialVersionUID = 1L;
	private MysqlConnection connectionInfo;
	public MysqlTreeView(MysqlConnection connectionInfo) {
		super(connectionInfo);
		this.connectionInfo = connectionInfo;
		DefaultMutableTreeNode database1=new MysqlDataBaseTreeView(new DataBaseInfo("连接中..."));
		add(database1);
	}
	
	public MysqlConnection getConnectionInfo() {
		return connectionInfo;
	}
	public void setConnectionInfo(MysqlConnection connectionInfo) {
		this.connectionInfo = connectionInfo;
	}
	
	
}
