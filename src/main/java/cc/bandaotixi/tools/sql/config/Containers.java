package cc.bandaotixi.tools.sql.config;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

import cc.bandaotixi.tools.panal.ConnectionList;
import cc.bandaotixi.tools.panal.HomeSplitPane;
import cc.bandaotixi.tools.panal.ToolBar;
import cc.bandaotixi.tools.sql.Main;

public class Containers {
	private static JFrame home;
	private static JSplitPane homeSplit;
	private static JToolBar toolBar;
	private static ConnectionList connetcionList;
	private static Font font=new Font("宋体",Font.BOLD,16);
	
	public static ConnectionList getConnetcionList() {
		if(connetcionList==null)connetcionList=new ConnectionList();
		return connetcionList;
	}

	public static JToolBar getToolBar() {
		if(toolBar==null)toolBar=new ToolBar();
		return toolBar;
	}

	public static JSplitPane getHomeSplit() {
		if(homeSplit==null)homeSplit=new HomeSplitPane();
		return homeSplit;
	}

	public static JFrame getHome() {
		if(home==null)home=new Main();
		return home;
	}

	public static Font getFont() {
		return font;
	}
	
}
