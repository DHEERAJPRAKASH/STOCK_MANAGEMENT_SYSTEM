package inventory.management.system;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBCONNECTION {
    public static Connection connect()
    {
        Connection con = null;
       try
       {
           Class.forName("org.sqlite.JDBC");
           con = DriverManager.getConnection("jdbc:sqlite:INVENTORY_MANAGEMENT_SYSTEM_DATABASE.db");
           //System.out.println("CONNECTED");
       }
       catch(ClassNotFoundException | SQLException e)
               {
                   JOptionPane.showMessageDialog(null,"DATABASE ERROR \nRETRY AGAIN");
               }
       return con;
    } 
}
