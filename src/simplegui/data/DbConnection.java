/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplegui.data;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;


/**
 *
 * @author shakeel
 */
public class DbConnection {
    
    public Connection getConnection(){
        String connectionString = "jdbc:mysql://localhost:3306/swingaddressbook";
        String username = "root";
        String password = "root";
        Connection con = null;
        try 
        {
           Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e1) 
        {
           // TODO Auto-generated catch block
           e1.printStackTrace();
       }

        try 
        {
            con = (Connection) DriverManager.getConnection(connectionString, username, password);
        } 
        catch (Exception e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       return con;
       }
   
}
