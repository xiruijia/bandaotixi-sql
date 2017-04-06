package cc.bandaotixi.tools.sql;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import cc.bandaotixi.tools.panal.ConnetcionList;
import cc.bandaotixi.tools.panal.ToolBar;
import cc.bandaotixi.tools.sql.config.SystemConfig;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final Integer DEF_WINDOW_X = 600;
	public static final Integer DEF_WINDOW_Y = 240;
	public static final Integer DEF_WINDOW_WIDHT = 500;
	public static final Integer DEF_WINDOW_HEIGHT = 400;

	public Main() {
		setTitle(SystemConfig.getTitle());
		addWindowFocusListener(cc.bandaotixi.tools.sql.listener.WindowListener.instantiation);
		addWindowListener(cc.bandaotixi.tools.sql.listener.WindowListener.instantiation);
		addWindowStateListener(cc.bandaotixi.tools.sql.listener.WindowListener.instantiation);
		addComponentListener(cc.bandaotixi.tools.sql.listener.WindowListener.instantiation);
		setBounds(SystemConfig.getInteger("window.x", DEF_WINDOW_X), SystemConfig.getInteger("window.y", DEF_WINDOW_Y), SystemConfig.getInteger("window.width", DEF_WINDOW_WIDHT),
				SystemConfig.getInteger("window.height", DEF_WINDOW_HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(DEF_WINDOW_WIDHT, DEF_WINDOW_HEIGHT));
		setLayout(new BorderLayout());

		JSplitPane jSplitPane1 = new JSplitPane();
		jSplitPane1.setDividerLocation(0.9);
		jSplitPane1.setOneTouchExpandable(true);
		jSplitPane1.add(new ConnetcionList(), JSplitPane.RIGHT);
		jSplitPane1.add(new ConnetcionList(), JSplitPane.LEFT);
		add(new ToolBar(), BorderLayout.NORTH);
		add(jSplitPane1);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}

}
