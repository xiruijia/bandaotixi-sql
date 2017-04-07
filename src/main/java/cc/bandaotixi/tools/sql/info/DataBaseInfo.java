package cc.bandaotixi.tools.sql.info;

import java.io.Serializable;

public class DataBaseInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String dataBase;
	
	public DataBaseInfo(String dataBase) {
		super();
		this.dataBase = dataBase;
	}
	public String getDataBase() {
		return dataBase;
	}
	public void setDataBase(String dataBase) {
		this.dataBase = dataBase;
	}
	@Override
	public String toString() {
		return dataBase;
	}
}
