package cc.bandaotixi.tools.sql.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseConfig {
	private static final String CONFIG_PATH = System.getProperty("java.io.tmpdir") + "bandaotixi.sql.properties";
	private static Properties properties;
	
	public static void init() {
		File configFile = new File(CONFIG_PATH);
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream(configFile));
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			Log.error("读取配置文件异常:可删除配置文件:"+CONFIG_PATH, e);
		}
		properties = pro;
	}

	public static Properties getProperties() {
		if (properties == null)
			init();
		return properties;
	}

	public static void set(String key, String value) {
		getProperties().put(key, value);
	}

	public static String get(String key) {
		return getProperties().getProperty(key);
	}

	public static Integer getInteger(String key, Integer def) {
		try {
			return Integer.parseInt(getProperties().getProperty(key));
		} catch (NumberFormatException e) {
			getProperties().put(key, ""+def);
			return def;
		}
	}

	public static void save() {
		Properties pro = getProperties();
		gether();
		FileOutputStream fos;
		try {
			Log.info("保存配置文件:"+CONFIG_PATH);
			Log.info(pro.toString());
			fos = new FileOutputStream(new File(CONFIG_PATH));
			pro.store(fos, "bandaotixi");
		} catch (FileNotFoundException e1) {
			Log.error("读取配置文件异常:可删除配置文件:"+CONFIG_PATH, e1);
		} catch (IOException e1) {
			Log.error("读取配置文件异常:可删除配置文件:"+CONFIG_PATH, e1);
		}
	}
	/**
	 * 收集需要保存的信息
	 */
	public static void gether(){
		//窗口信息
		WindowConfig.setWindowX(Containers.getHome().getX());
		WindowConfig.setWindowY(Containers.getHome().getY());
		WindowConfig.setWindowWidth(Containers.getHome().getWidth());
		WindowConfig.setWindowHeight(Containers.getHome().getHeight());
		WindowConfig.setWindowHomeSplitDividerLocation(Containers.getHomeSplit().getDividerLocation());
	}
}
