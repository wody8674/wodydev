package hts.gis.common;

import java.sql.*;


public class GISConnectionManager {
	
	public static void disConnect(Connection con) throws SQLException {

		con.close();
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		//*
		// 데이터베이스 URL
		String url = "jdbc:oracle:thin:@10.10.84.139:1521:GISDB";
		// 사용자ID
		String user = "MZGSO2";
		// Password
		String password = "MZGSO2";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로딩 성공!");
		//*/
		/*
		// 데이터베이스 URL
		String url = "jdbc:odbc:OracleDbCon";
		// 사용자ID
		String user = "MZGSO2";
		// Password
		String password = "MZGSO2";
		
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//*/
		
		return DriverManager.getConnection(url, user, password);
	}

}