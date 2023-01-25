package com.gk.service;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DbService {
	private static final String URL ="jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String U_NAME = "system";
	private static final String PWORD = "gajukadtan2027";
	public static Connection openConn() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL,U_NAME,PWORD);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return con;
	}
	
}
