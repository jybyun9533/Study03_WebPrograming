package util;
/*
 * JNDI API를 이용해서 DataSource를 하나 반환 받아온다.
 * 싱글톤 구사
 */

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceManager {
	private DataSource ds;

	private static DataSourceManager instance = new DataSourceManager();

	private DataSourceManager() {
		try { // Naming Service
			Context ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/mysql"); // 외부이름 접근법
			System.out.println("DataSource Lookup OK");
		} catch (NamingException e) {
			System.out.println("DataSource Lookup Fail");
		}
	}

	public static DataSourceManager getInstance() {
		return instance;
	}
	
	// 추가 DataSource를 하나 받환받아옴
	public DataSource getConnection() {
		return ds;
	}
	
}
