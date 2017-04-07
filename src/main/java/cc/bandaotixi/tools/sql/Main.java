package cc.bandaotixi.tools.sql;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.UIManager;

import cc.bandaotixi.tools.sql.config.Containers;
import cc.bandaotixi.tools.sql.config.SystemConfig;
import cc.bandaotixi.tools.sql.config.WindowConfig;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setMinimumSize(new Dimension(WindowConfig.DEF_WINDOW_WIDTH, WindowConfig.DEF_WINDOW_HEIGHT));
		setTitle(SystemConfig.getTitle());
		addWindowFocusListener(cc.bandaotixi.tools.sql.listener.WindowListener.instantiation);
		addWindowListener(cc.bandaotixi.tools.sql.listener.WindowListener.instantiation);
		addWindowStateListener(cc.bandaotixi.tools.sql.listener.WindowListener.instantiation);
		addComponentListener(cc.bandaotixi.tools.sql.listener.WindowListener.instantiation);
		setBounds(WindowConfig.getWindowX(), WindowConfig.getWindowY(), WindowConfig.getWindowWidth(), WindowConfig.getWindowHeight());

		add(Containers.getToolBar(), BorderLayout.NORTH);
		add(Containers.getHomeSplit(), BorderLayout.CENTER);
		
		java.util.Enumeration<?> keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()){
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource){
				UIManager.put(key, Containers.getFont());
			}
		}
		
		setVisible(true);
	}

	public static void main(String[] args) {
		Containers.getHome();
	}

}
