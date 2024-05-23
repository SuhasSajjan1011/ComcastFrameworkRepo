
package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection conn=null;
	public void getDBConnection(String url,String username,String password) throws SQLException
	{
		try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection(url,username,password);
		}
		catch(Exception e)
		{
		}
		
	}
	public void getDBConnection() throws SQLException
	{
		try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection("jdbc:mySql://106.51.90.215:3333/projects", "root@%", "root");
		}
		catch(Exception e)
		{
		}
	}
	
	public void closeDbConnection() throws SQLException
	{
		try {
		conn.close();
		}catch(Exception e)
		{
			
		}
	}
	
	public ResultSet exceuteSelectQuery(String Query) throws Exception
	{
		ResultSet result = null;
		try {
		
		Statement stat=conn.createStatement();
		result=stat.executeQuery(Query);
		
		}catch(Exception e)
		{}
		
		return result;
	}
	public int executeNonSelectQuery(String Query) throws SQLException
	{
		int result=0;
		try {
		Statement stat=conn.createStatement();
		 result=stat.executeUpdate(Query);
		}
		catch(Exception e) {}
		return result;
	}

}
