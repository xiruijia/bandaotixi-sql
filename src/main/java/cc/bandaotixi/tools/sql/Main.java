package cc.bandaotixi.tools.sql;

import javax.swing.JFrame;

import cc.bandaotixi.tools.sql.config.SystemConfig;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		Main win=new Main();
		win.setVisible(true);
		win.setBounds(SystemConfig.getInteger("window.x",100), SystemConfig.getInteger("window.y",100), SystemConfig.getInteger("window.width",100),SystemConfig.getInteger("window.height",100));
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.addWindowListener(new cc.bandaotixi.tools.sql.listener.WindowListener());
	}
}
