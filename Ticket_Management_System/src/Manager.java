/***************************************************************
 * Name: Dominic DiModugno
 * Date: October 22nd, 2022
 * 
 * Subclass of employee - inherits some methods from Employee. 
 */
public class Manager extends Employee { 
    private int NumOfTicketsCaptured;
    private Ticket Incident;

    //constructor
    public Manager(String name, int id, int numTickets) {
        super(name, id);
        NumOfTicketsCaptured = numTickets;
    }

    @Override
    public String getEmployeeInfo() {
        return String.format("Manager Information\n\tName: %s%n\tEmployee ID: %d%n", Name, Employee_id); 
    }
}