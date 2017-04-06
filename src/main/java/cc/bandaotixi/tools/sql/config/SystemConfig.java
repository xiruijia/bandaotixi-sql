package cc.bandaotixi.tools.sql.config;

import java.util.Properties;

public class SystemConfig extends BaseConfig {
	public static final String KEY_TITLE = "title";
	public static String getTitle(){
		Properties pro=getProperties();
		if(!pro.containsKey(KEY_TITLE)){
			pro.put(KEY_TITLE, "半导体");
		}
		return pro.getProperty(KEY_TITLE);
	}
}
