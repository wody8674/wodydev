package hts.gis.common;

import java.sql.*;


public class GISConnectionManager {
	
	public static void disConnect(Connection con) throws SQLException {

		con.close();
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		//*
		// �����ͺ��̽� URL
		String url = "jdbc:oracle:thin:@10.10.84.139:1521:GISDB";
		// �����ID
		String user = "MZGSO2";
		// Password
		String password = "MZGSO2";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("����̹� �ε� ����!");
		//*/
		/*
		// �����ͺ��̽� URL
		String url = "jdbc:odbc:OracleDbCon";
		// �����ID
		String user = "MZGSO2";
		// Password
		String password = "MZGSO2";
		
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//*/
		
		return DriverManager.getConnection(url, user, password);
	}

}