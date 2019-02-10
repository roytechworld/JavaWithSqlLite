package com.roytechworld.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author Pradipto Roy
 *
 */
public class ExtractOutput {
	
	  private static  Logger logger = Logger.getLogger("MyLog");  
	  private static FileHandler fh; 
	
	public static void main(String[] args)
	{
		    Connection conn = null;
		    PreparedStatement prSt = null;
			ResultSet rs = null;
			String query = "select * from studentmaster";
			try
			{
			conn=SingeltonSqlLiteConnector.GetInstance().getConnection();
            prSt = conn.prepareStatement(query);
            rs = prSt.executeQuery();
        
            fh = new FileHandler("d:/myfile.log");  
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);  
        
            while(rs.next())
           {
            System.out.println(rs.getString("name"));
            logger.info(rs.getString("name"));
           }
        
			}
			catch(Exception e)
			{
				System.out.println("exception occur"+e);
			}
		
		
	}
	

}
