package cc.bandaotixi.tools.mysql.panal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.tree.DefaultMutableTreeNode;

import cc.bandaotixi.tools.panal.ConnectionList;
import cc.bandaotixi.tools.sql.info.DataBaseInfo;
import cc.bandaotixi.tools.sql.info.TableInfo;

public class MysqlDataBaseTreeView extends DefaultMutableTreeNode {
	private static final long serialVersionUID = 1L;
	private DataBaseInfo dataBaseInfo;
	private DefaultMutableTreeNode table=new DefaultMutableTreeNode(new TableInfo("表",false));
	private Map<String,DefaultMutableTreeNode> tables=new HashMap<>();
	private boolean hasTable=false;
	
	public MysqlDataBaseTreeView(DataBaseInfo dataBaseInfo) {
		super(dataBaseInfo);
		this.dataBaseInfo = dataBaseInfo;
		add(table);
	}
	public DataBaseInfo getDataBaseInfo() {
		return dataBaseInfo;
	}
	public void setDataBaseInfo(DataBaseInfo dataBaseInfo) {
		this.dataBaseInfo = dataBaseInfo;
	}
	
	public void addTables(List<TableInfo> ts){
		this.tables.clear();
		for(TableInfo ti :ts){
			DefaultMutableTreeNode dmtn=new DefaultMutableTreeNode(ti);
			tables.put(ti.getTableName(), dmtn);
			table.add(dmtn);
		}
		ConnectionList.getTree().updateUI();
		hasTable=true;
	}
	public boolean isHasTable() {
		return hasTable;
	}
	
}
