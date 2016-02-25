/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplegui.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shakeel
 */
public class ListModel {
    public void fillTable(JTable table, String query){
    try
    {
        Connection con = new DbConnection().getConnection();
        Statement stat = con.createStatement();
        ResultSet rs = stat.executeQuery(query);

        //To remove previously added rows and columns
        while(table.getRowCount() > 0) 
        {
            ((DefaultTableModel) table.getModel()).removeRow(0);
            ((DefaultTableModel) table.getModel()).setColumnCount(0);
        }
        int columns = rs.getMetaData().getColumnCount();
        
       
        while(rs.next())
        {  
            Object[] row = new Object[columns];
            for (int i = 1; i <= columns; i++)
            {  
                row[i - 1] = rs.getObject(i);
                ((DefaultTableModel) table.getModel()).addColumn(rs.getMetaData().getColumnName(i));
            }
            
            ((DefaultTableModel) table.getModel()).setColumnCount(columns);
            
            ((DefaultTableModel) table.getModel()).insertRow(rs.getRow()-1,row);
            
        }

        rs.close();
        stat.close();
        con.close();
    }
    catch(SQLException e)
    {
        
    }
    
    }
    
}
