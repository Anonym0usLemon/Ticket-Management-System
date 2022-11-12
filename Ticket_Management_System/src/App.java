/******************************************************************* 
 * Name: Dominic DiModugno  
 * Date: October 29th, 2022 
 *  
 * Main application class. 
 */
import java.sql.Connection; 
import java.util.ArrayList; 
 
public class App { 
    public static void main(String[] args) throws Exception { 
        final String dbName = "Tickets.db"; 
        System.out.println("\nYour Name, Week 4 Project Database Implementation GP\n"); 
        Connection conn = SQLiteDatabase.connect(dbName); 
 
        if (conn != null) { 
            if (TicketDB.createTable(conn)) { 
                //Create 
                TicketDB.addTicket(conn, new Ticket(1, "Access Issue", "Access",
                 "User did not have an account in AD - Escalated to analyst support team", 1, false)); 
                TicketDB.addTicket(conn, new Ticket(2, "Server Error", "Internal Server Error",
                 "User unale to load webpage, Internal Server Error - Escalate to IT", 2, false)); 
                TicketDB.addTicket(conn, new Ticket(3, "2FA", "Two-Factor Auth",
                 "User could not recieve 2FA code. Verified info and turnned off 2FA", 4, true));  
                TicketDB.addTicket(conn, new Ticket(4, "PW Reset", "Forgotten IDs/Passwors",
                 "Verrified info, reset password", 4, true));  
 
                //Read 
                System.out.println("\nAll People in the Database"); 
                printTickets(TicketDB.getAllTickets(conn)); 
                System.out.println("\nGet a Ticket Using an Invalid ID"); 
                printTicket(TicketDB.getTicket(conn, -5)); 
 
                //Update 
                Ticket ticketToUpdate = new Ticket(0, "Null", "Nukk", "Null", 1, false); 
                TicketDB.updateTicket(conn, ticketToUpdate); 
                Ticket updatedTicket = TicketDB.getTicket(conn, ticketToUpdate.TicketNum); 
                System.out.println("\nUpdated Ticket"); 
                printTicket(updatedTicket); 
 
                //Delete 
                TicketDB.deleteTicket(conn, ticketToUpdate.TicketNum); 
                System.out.println("\nAll Tickets in the Database"); 
                printTickets(TicketDB.getAllTickets(conn)); 
            } 
        } 
    } 
 
    private static void printTickets(ArrayList<Ticket> tickets) { 
        for (Ticket p : tickets) { 
            printTicket(p); 
        } 
    } 
 
    private static void printTicket(Ticket t) { 
        System.out.print("Ticket " + t.TicketNum + ": "); 
        System.out.print(t.Description + " " + t.Subcategory + " " + t.Notes + " " + t.Priority + " " + t.Resolved + "\n"); 
    } 
}

