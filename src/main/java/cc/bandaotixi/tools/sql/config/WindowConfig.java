package cc.bandaotixi.tools.sql.config;

public interface WindowConfig {
	public static final String WINDOW_X="window.x";
	public static final Integer DEF_WINDOW_X = 600;
	
	public static final String WINDOW_Y="window.y";
	public static final Integer DEF_WINDOW_Y = 240;
	
	public static final String WINDOW_WIDTH="window.width";
	public static final Integer DEF_WINDOW_WIDTH = 500;//缺省值或最小值
	
	public static final String WINDOW_HEIGHT="window.height";
	public static final Integer DEF_WINDOW_HEIGHT = 400;//too
	
	public static final String WINDOW_HOME_SPLIT_DIVIDER_LOCATION="window.home.split.divider.location";
	public static final Integer DEF_WINDOW_HOME_SPLIT_DIVIDER_LOCATION=100;
	public static void setWindowX(Integer x) {
		BaseConfig.set(WINDOW_X, ""+x);
	}
	public static void setWindowY(Integer y) {
		BaseConfig.set(WINDOW_Y, ""+y);
	}
	public static void setWindowWidth(Integer width) {
		BaseConfig.set(WINDOW_WIDTH, ""+width);
	}
	public static void setWindowHeight(Integer height) {
		BaseConfig.set(WINDOW_HEIGHT, ""+height);
	}
	public static Integer getWindowX(){
		return SystemConfig.getInteger(WINDOW_X, DEF_WINDOW_X);
	}
	public static Integer getWindowY(){
		return SystemConfig.getInteger(WINDOW_Y, DEF_WINDOW_Y);
	}
	public static Integer getWindowWidth(){
		return SystemConfig.getInteger(WINDOW_WIDTH, DEF_WINDOW_WIDTH);
	}
	public static Integer getWindowHeight(){
		return SystemConfig.getInteger(WINDOW_HEIGHT, DEF_WINDOW_HEIGHT);
	}
	
	public static void setWindowHomeSplitDividerLocation(Integer left){
		BaseConfig.set(WINDOW_HOME_SPLIT_DIVIDER_LOCATION, ""+left);
	}
	public static Integer getWindowHomeSplitDividerLocation(){
		return SystemConfig.getInteger(WINDOW_HOME_SPLIT_DIVIDER_LOCATION, DEF_WINDOW_HOME_SPLIT_DIVIDER_LOCATION);
	}
}
