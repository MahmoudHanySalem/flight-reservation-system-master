package advanced2;

import java.sql.*;
import java.util.logging.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Mahmoud
 */
public class dbConn {
     public static Connection DBConnection() {
        
         Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
           
            conn = DriverManager.getConnection("jdbc:oracle:thin:Airplane Ticket Reservation/123@localhost:1521/XE");
//Airplane Ticket Reservation database name//123 password

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.toString());
        }
     
        return conn;
    
}
}