/*****************************************************************
 * Name: Dominic DiModugno
 * Date: October 27th, 2022
 * 
 * Class to handle all inreractions with the Tickets table in the 
 * database, including creating the table if it doesn't exist and all
 * CRUD (Create, Read, Update, Delete) operations on the Tickets table. 
 * Note that the interactions are all done using standard SQL syntax
 * that is then executed by the SQLite JDBC library
 */
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList; 
 
public class TicketDB { 
     
    public static boolean createTable(Connection conn) { 
        // SQL statement for creating a new table 
        String sql =  
            "CREATE TABLE IF NOT EXISTS Tickets (\n" 
            + "   TicketNum integer PRIMARY KEY\n" 
            + "   ,Description varchar(200)\n" 
            + "   ,Subcategory varchar(40)\n" 
            + "   ,Notes varchar(200)\n"
            + "   ,Priority integer\n"
            + "   ,Resolved boolean\n);"; 
 
        System.out.println(sql); 
 
        try { 
            Statement stmt = conn.createStatement(); 
            stmt.execute(sql); 
            return true; 
        } catch (SQLException e) { 
            System.out.println(e.getMessage()); 
            return false; 
        } 
    } 
 
    public static void addTicket(Connection conn, Ticket t) { 
        String sql =  
            "INSERT INTO Tickets(Description, Subcategory, Notes, Priority, Resolved) VALUES(?,?,?,?,?)"; 
        try { 
            PreparedStatement pst = conn.prepareStatement(sql); 
            pst.setString(1, t.Description); 
            pst.setString(2, t.Subcategory);
            pst.setString(3, t.Notes);
            pst.setInt(4, t.Priority);
            pst.setBoolean(5, t.Resolved); 
            pst.executeUpdate(); 
        } catch(SQLException e) { 
            System.out.println(e.getMessage()); 
        } 
    } 
 
    public static void updateTicket(Connection conn, Ticket t) { 
        String sql =  
            "UPDATE Tickets SET Description=?, Subcategory=?, Notes=?, Priority=?, Resolved=? WHERE TicketNum=?"; 
        try { 
            PreparedStatement pst = conn.prepareStatement(sql); 
            pst.setString(1, t.Description); 
            pst.setString(2, t.Subcategory); 
            pst.setString(3, t.Notes); 
            pst.setInt(4, t.Priority);
            pst.setBoolean(5, t.Resolved); 
            pst.setInt(6, t.TicketNum); 
            pst.executeUpdate(); 
        } catch(SQLException e) { 
            System.out.println(e.getMessage()); 
        } 
    } 
 
    public static void deleteTicket(Connection conn, int id) { 
        String sql = "DELETE from Tickets WHERE TicketNum=?"; 
        try { 
            PreparedStatement pst = conn.prepareStatement(sql); 
            pst.setInt(1, id); 
            pst.executeUpdate(); 
        } catch (SQLException e) { 
            System.out.println(e.getMessage()); 
        } 
    } 
 
    public static ArrayList<Ticket> getAllTickets(Connection conn) { 
        ArrayList<Ticket> tickets = new ArrayList<Ticket>(); 
        String sql = "SELECT * FROM Tickets"; 
 
        try { 
            Statement stmt = conn.createStatement(); 
            ResultSet rs = stmt.executeQuery(sql); 
 
            while (rs.next()) { 
                Ticket t = new Ticket(rs.getInt("TicketNum"), rs.getString("Description"), 
                    rs.getString("Subcategory"), rs.getString("Notes"), rs.getInt("Priority"),
                    rs.getBoolean("Resolved")); 
                tickets.add(t); 
            } 
        } catch (SQLException e) { 
            System.out.println(e.getMessage()); 
        } 
 
        return tickets; 
    } 
 
    public static Ticket getTicket(Connection conn, int id) { 
        Ticket t = new Ticket(); 
        String sql = "SELECT * FROM Ticket WHERE ID=?"; 
 
        try { 
            PreparedStatement pst = conn.prepareStatement(sql); 
            pst.setInt(1, id); 
            ResultSet rs = pst.executeQuery(); 
            if (rs.next()) { 
                t.TicketNum = rs.getInt("TicketNum"); 
                t.Description = rs.getString("Description"); 
                t.Subcategory = rs.getString("Subcategory"); 
                t.Notes = rs.getString("Notes"); 
                t.Priority = rs.getInt("Priority"); 
                t.Resolved = rs.getBoolean("Resolved"); 
            } else { 
                t.TicketNum = id; 
                t.Description = "Not"; 
                t.Subcategory = "Found"; 
                t.Notes = "999"; 
                t.Priority = 1;
                t.Resolved = false;  
            } 
        } catch (SQLException e) { 
            System.out.println(e.getMessage()); 
        } 
 
        return t; 
    } 
}