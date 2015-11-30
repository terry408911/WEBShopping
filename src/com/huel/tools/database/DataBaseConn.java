package com.huel.tools.database;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//���ݿ�����
public class DataBaseConn {
	public static Connection conn = null;
	public static String driverClass = "";
	public static String dbURL = "";
	public static String dbUser = "";
	public static String dbPwd = "";

	static {
		loadProperty();
	}

	public static boolean loadProperty() {
		Properties properties = new Properties();
		try {
			properties.load(DataBaseConn.class
					.getResourceAsStream("db.properties"));
			driverClass = properties.getProperty("drivername");
			dbURL = properties.getProperty("dburl");
			dbUser = properties.getProperty("username");
			dbPwd = properties.getProperty("password");
			System.out.println("pwd:" + dbPwd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("��ȡ�����ļ�ʧ��");
			return false;
		}
		return true;
	}

	public static void openConn() {
		try {
			Class.forName(driverClass).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("������û���ҵ�������ʧ��");
			return;
		}

		try {
			conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("����ʧ�ܣ�");
		}
	}
	public void closeConn() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}
	}
  
}
