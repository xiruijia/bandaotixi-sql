package cc.bandaotixi.tools.panal;

import javax.swing.JSplitPane;

import cc.bandaotixi.tools.sql.config.Containers;
import cc.bandaotixi.tools.sql.config.WindowConfig;

public class HomeSplitPane extends JSplitPane{
	private static final long serialVersionUID = 1L;
	public HomeSplitPane() {
		super();
		setDividerLocation(WindowConfig.getWindowHomeSplitDividerLocation());
		setLeftComponent(Containers.getConnetcionList());
	}
}
