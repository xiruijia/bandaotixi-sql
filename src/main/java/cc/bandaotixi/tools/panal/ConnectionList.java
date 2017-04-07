package cc.bandaotixi.tools.panal;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import cc.bandaotixi.tools.mysql.panal.MysqlTreeView;
import cc.bandaotixi.tools.sql.info.MysqlConnection;
import cc.bandaotixi.tools.sql.listener.TreeMouseListener;

public class ConnectionList  extends JScrollPane{
	private static final long serialVersionUID = 1L;
	private static JTree tree=new JTree(new DefaultMutableTreeNode("root"));
	public static JTree getTree() {
		return tree;
	}
	public ConnectionList() {
		super(tree);
		tree.setRootVisible(false);
		tree.setCellRenderer(new ConnectionCellRenderer());
		tree.addMouseListener(new TreeMouseListener(tree));
		init();
		setVisible(true);
	}
	public void init(){
		DefaultMutableTreeNode lx=(DefaultMutableTreeNode)tree. getModel().getRoot();
		MysqlConnection ci=new MysqlConnection("bandaotixi");
		ci.setHost("www.bandaotixi.cc");
		ci.setUsername("root");
		ci.setPassword("10020525Xi.");
        lx.add(new MysqlTreeView(ci));
        tree.expandPath(new TreePath(tree.getModel().getRoot()));
	}
}
