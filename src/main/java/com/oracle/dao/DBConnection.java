package com.oracle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class DBConnection {
	@Value("${driver.Class}")
	private  String driverClass="";
public static void main(String[] args) {
	//new DBConnection().connect();
}

//Estabilish the connection with the DB & return the connection instance
public  Connection connect() {
	String className="oracle.jdbc.driver.OracleDriver";
	Connection con=null;
	try {
		Class.forName(className);//load the driver class @ runtime
		System.out.println("Driver loaded successfully ....");
		//URL : http://google.com:80
		String url="jdbc:oracle:thin:@localhost:1521:ORCL";//default portno is 1521
		String uname="vamshiuser";
		String pwd="vamshi2311";
		 con=DriverManager.getConnection(url,uname,pwd);
		System.out.println("Connected with the Oracle DB");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}	
	return con;
}
}
