package com.roytechworld.test;

import java.sql.Connection;

/**
 * @author Pradipto roy
 *
 */
public class SingeltonSqlLiteConnector {
	
	  private static SingeltonSqlLiteConnector connectorobj;  
	  private Connection connection;
	  private SingeltonSqlLiteConnector()
	  { 
		connection=DBConnectionDriver.intializeConnection();      
	  }
	  
	  public static SingeltonSqlLiteConnector GetInstance()
      {
          if (connectorobj == null) //check if  an instance has been created else  can create a new instance
          {
        	  connectorobj = new SingeltonSqlLiteConnector();
          }
          return connectorobj;
      }
	  
	  public Connection getConnection()
	  {
		  return connection;
	  }
	  
}
