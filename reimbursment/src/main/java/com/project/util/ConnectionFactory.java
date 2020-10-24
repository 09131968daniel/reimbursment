package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
public static String url="jdbc:postgresql://localhost/postgres";
public static String username="postgres";
public static String password="G@briela12345";

public static Connection getConnection()  {
	Connection conn=null;
	try {
		Class.forName("org.postgresql.Driver");
		conn=DriverManager.getConnection(url,username,password);

	}
	catch(SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	} 
	return conn;
}
}
