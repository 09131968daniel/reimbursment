package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
public static String url="jdbc:postgresql://localhost:5432/postgres";
public static String username="postgres";
public static String password="G@briela12345";
public  static final String user = java.lang.System.getenv("DB_USERNAME");
public  static final String pass = java.lang.System.getenv("DB_PASSWORD");
public static Connection getConnection()  {
	Connection conn=null;
	try {
		Class.forName("org.postgresql.Driver");
		conn=DriverManager.getConnection(url,user,pass);

	}
	catch(SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	} 
	return conn;
}
}
