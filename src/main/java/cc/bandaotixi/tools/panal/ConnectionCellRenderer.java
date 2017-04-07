package cc.bandaotixi.tools.panal;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import cc.bandaotixi.tools.sql.info.DataBaseInfo;
import cc.bandaotixi.tools.sql.info.TableInfo;

public class ConnectionCellRenderer extends DefaultTreeCellRenderer {
	private static final long serialVersionUID = 1L;

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {

		DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
		Object user = node.getUserObject();
		if (user instanceof cc.bandaotixi.tools.sql.info.Connection) {
			cc.bandaotixi.tools.sql.info.Connection con=(cc.bandaotixi.tools.sql.info.Connection)user;
			
			setOpenIcon(new ImageIcon(ConnectionCellRenderer.class.getResource("/images/connectioned.png").getFile()));
			setLeafIcon(new ImageIcon(ConnectionCellRenderer.class.getResource("/images/connection_not.png").getFile()));
			if(con.isConnectioned()){
				setClosedIcon(new ImageIcon(ConnectionCellRenderer.class.getResource("/images/connectioned.png").getFile()));
			}else{
				setClosedIcon(new ImageIcon(ConnectionCellRenderer.class.getResource("/images/connection_not.png").getFile()));
			}
		}else if(user instanceof DataBaseInfo){
			setClosedIcon(new ImageIcon(ConnectionCellRenderer.class.getResource("/images/database_open_not.png").getFile()));
			setOpenIcon(new ImageIcon(ConnectionCellRenderer.class.getResource("/images/database_opened.png").getFile()));
			setLeafIcon(new ImageIcon(ConnectionCellRenderer.class.getResource("/images/database_open_not.png").getFile()));
		}else if(user instanceof TableInfo){
			setClosedIcon(new ImageIcon(ConnectionCellRenderer.class.getResource("/images/table.png").getFile()));
			setOpenIcon(new ImageIcon(ConnectionCellRenderer.class.getResource("/images/table.png").getFile()));
			setLeafIcon(new ImageIcon(ConnectionCellRenderer.class.getResource("/images/table.png").getFile()));
		}

		return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
	}
}
