package cc.bandaotixi.tools.sql.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JTree;
import javax.swing.tree.TreePath;

import cc.bandaotixi.tools.mysql.panal.MysqlDataBaseTreeView;
import cc.bandaotixi.tools.mysql.panal.MysqlTreeView;
import cc.bandaotixi.tools.sql.config.Log;
import cc.bandaotixi.tools.sql.info.DataBaseInfo;
import cc.bandaotixi.tools.sql.info.MysqlConnection;
import cc.bandaotixi.tools.sql.info.TableInfo;

public class TreeMouseListener implements MouseListener {
	private JTree tree;
	private String database;
	
	public TreeMouseListener(JTree tree) {
		super();
		this.tree = tree;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		TreePath tp = tree.getSelectionPath();
		Object view = tp.getLastPathComponent();
		if (e.getClickCount() == 2) {
			if (view instanceof MysqlTreeView) {
				MysqlTreeView mtv = (MysqlTreeView) view;
				MysqlConnection ci = mtv.getConnectionInfo();
				if(!ci.isConnectioned()){
					Connection con=ci.getConnection();
					Log.info("获取数据连接...");
					//获取数据库
					mtv.removeAllChildren();
					try {
						java.sql.ResultSet datas=con.createStatement().executeQuery("show databases");
						while(datas.next()){
							mtv.add(new MysqlDataBaseTreeView(new DataBaseInfo(datas.getString("database"))));
						}
					} catch (SQLException e1) {
						Log.error("数据库显示失败", e1);
					}
					mtv.getNextNode();
					tree.updateUI();
				}
			}else if(view instanceof MysqlDataBaseTreeView){
				MysqlDataBaseTreeView mdbt = (MysqlDataBaseTreeView) view;
				if(!mdbt.isHasTable()){
					MysqlTreeView mtv = (MysqlTreeView) mdbt.getParent();
					try {
						Connection con=mtv.getConnectionInfo().getConnection();
						String database=mdbt.getDataBaseInfo().getDataBase();
						this.database=database;
						con.createStatement().executeQuery("use `"+database+"`");
						java.sql.ResultSet datas=con.createStatement().executeQuery("show tables");
						List<TableInfo> tables=new ArrayList<>();
						while(datas.next()){
							tables.add(new TableInfo(datas.getString(1)));
						}
						mdbt.addTables(tables);
					} catch (SQLException e1) {
						Log.error("选择数据库",e1);
					}
				}
				//查询所有表
			}else if(view instanceof javax.swing.tree.DefaultMutableTreeNode){
				javax.swing.tree.DefaultMutableTreeNode dmtn=(javax.swing.tree.DefaultMutableTreeNode)view;
				Object user=dmtn.getUserObject();
				if(user instanceof TableInfo){
					TableInfo ti=(TableInfo)user;
					if(ti.isLeaf()){
						MysqlTreeView mtv =(MysqlTreeView) dmtn.getParent().getParent().getParent();
						Connection con=mtv.getConnectionInfo().getConnection();
						try {
							ResultSet rs=con.createStatement().executeQuery("select * from "+ti.getTableName());
							int columnNum=rs.getMetaData().getColumnCount();
							Map<Integer,String> columns=new HashMap<>();
							for(int i=1;i<=columnNum;i++){
								columns.put(i, rs.getMetaData().getColumnName(i));
								System.out.print(rs.getMetaData().getColumnName(i)+"|");
							}
							System.out.println();
							while(rs.next()){
								for(Entry<Integer,String> row:columns.entrySet()){
									System.out.print(rs.getString(row.getValue())+"|");
								}
								System.out.println();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		}
		if(e.getClickCount()==1){
			if(view instanceof MysqlDataBaseTreeView){
				Log.info("数据库:"+view);
				MysqlDataBaseTreeView mdbt = (MysqlDataBaseTreeView) view;
				if(mdbt.isHasTable()){
					String database=mdbt.getDataBaseInfo().getDataBase();
					this.database=database;
					Log.info("选择数据库:"+database);
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
