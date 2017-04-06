package cc.bandaotixi.tools.sql.config;

public interface WindowConfig {
	public static final String WINDOW_X="window.x";
	public static final String WINDOW_Y="window.y";
	public static final String WINDOW_WIDTH="window.width";
	public static final String WINDOW_HEIGHT="window.height";
	public static void setWindowX(Integer x) {
		BaseConfig.set(WINDOW_X, ""+x);
	}
	public static void setWindowY(Integer y) {
		BaseConfig.set(WINDOW_Y, ""+y);
	}
	public static void setWindwoWidth(Integer width) {
		BaseConfig.set(WINDOW_WIDTH, ""+width);
	}
	public static void setWindowHeight(Integer height) {
		BaseConfig.set(WINDOW_HEIGHT, ""+height);
	}
}
