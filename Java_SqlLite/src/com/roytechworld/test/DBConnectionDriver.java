package com.roytechworld.test;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author Pradipto Roy
 *
 */
public class DBConnectionDriver {
	
    public static Connection intializeConnection()
    {
    	Connection conn = null;
    	Path currentRelativePath = Paths.get("");
    	String s = currentRelativePath.toAbsolutePath().toString();
    	s=s+"/royTecworldTest.db";
    	System.out.println("Current relative path is: " + s);
    	
   		try{ 
   		Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:"+s;
        conn = DriverManager.getConnection(url);
        System.out.println("Connection to SQLite has been established.");
        
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    
    } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    	
    	return conn;
    }
	
	
}
