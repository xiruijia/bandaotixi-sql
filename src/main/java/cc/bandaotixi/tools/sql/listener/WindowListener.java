package cc.bandaotixi.tools.sql.listener;

import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;

import cc.bandaotixi.tools.sql.config.SystemConfig;
import cc.bandaotixi.tools.sql.config.WindowConfig;

public class WindowListener implements java.awt.event.WindowListener,java.awt.event.WindowStateListener,java.awt.event.WindowFocusListener,java.awt.event.ComponentListener{
	
	public static final WindowListener instantiation=new WindowListener();
	
	@Override
	public void windowOpened(WindowEvent e) {
		//初始化配置文件
		System.out.println("---初始化配置文件:"+SystemConfig.getProperties());
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// 点击关闭窗口是触发
		SystemConfig.save();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("closed");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// 最小化触发
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// 窗口最小化还原
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// 窗口激活时触发
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// 后台运行时触发
	}

	@Override
	public void windowStateChanged(WindowEvent e) {
		// 最大化最,小化触发,窗口还原
	}

	@Override
	public void windowGainedFocus(WindowEvent e) {
		// 窗口获取焦点
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		// 窗口失去焦点
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// 改变大小
		WindowConfig.setWindwoWidth(e.getComponent().getWidth());
		WindowConfig.setWindowHeight(e.getComponent().getHeight());
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// 移动窗口位置
		WindowConfig.setWindowX(e.getComponent().getX());
		WindowConfig.setWindowY(e.getComponent().getY());
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
