package cc.bandaotixi.tools.panal;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar {
	private static final long serialVersionUID = 1L;
	private JButton connection=new JButton("连接");
	private JButton users=new JButton("用户");
	public ToolBar() {
		super();
        add(connection);
        add(users);
	}
	
}
