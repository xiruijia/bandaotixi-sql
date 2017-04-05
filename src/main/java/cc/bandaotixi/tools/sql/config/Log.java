package cc.bandaotixi.tools.sql.config;

public class Log {
	public static void info(String msg,Exception e){
		System.out.println(msg);
		e.printStackTrace();
	}
	public static void info(String msg){
		System.out.println(msg);
	}
	
	public static void error(String msg,Exception e){
		System.err.println(msg);
		e.printStackTrace();
	}
	public static void error(String msg){
		System.err.println(msg);
	}
}
