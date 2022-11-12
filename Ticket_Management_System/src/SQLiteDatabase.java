/*****************************************************************
 * Name: Dominic DiModugno
 * Date: October 27th, 2022
 * 
 * Class to handle databse interactions with SQLite databse. The 
 * connect method will either connect to an existing databse or
 * create the databse if the databse doesn't exist.
 */
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
 
public class SQLiteDatabase { 
    public static Connection connect(String database) { 
        String url = "jdbc:sqlite:" + database; 
        Connection conn = null; 
 
        try { 
            conn = DriverManager.getConnection(url); 
        } catch (SQLException e) { 
            System.out.println(e.getMessage()); 
        } 
 
        return conn; 
    } 
}
