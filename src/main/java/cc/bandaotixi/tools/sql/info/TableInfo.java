package cc.bandaotixi.tools.sql.info;

import java.io.Serializable;

public class TableInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String tableName;
	private boolean leaf=true;
	
	public TableInfo(String tableName) {
		super();
		this.tableName = tableName;
	}
	
	public TableInfo(String tableName, boolean leaf) {
		super();
		this.tableName = tableName;
		this.leaf = leaf;
	}

	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	@Override
	public String toString() {
		return tableName;
	}
	
	
}
