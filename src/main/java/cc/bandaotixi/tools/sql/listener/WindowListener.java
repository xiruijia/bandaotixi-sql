package cc.bandaotixi.tools.sql.listener;

import java.awt.event.WindowEvent;

import cc.bandaotixi.tools.sql.config.SystemConfig;

public class WindowListener implements java.awt.event.WindowListener{
	@Override
	public void windowOpened(WindowEvent e) {
		//初始化配置文件
		System.out.println("---初始化配置文件:"+SystemConfig.getProperties());
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
