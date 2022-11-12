/***************************************************************
 * Name: Dominic DiModugno
 * Date: October 22nd, 2022
 * 
 * Main class for users - Superclass for manager class
 */
public class Employee {
    protected String Name; 
    protected int Employee_id;
    Ticket Incident; 

    //constructor
    public Employee(String name, int employee_id) {
        Name = name;
        Employee_id = employee_id;
    }

    

    //getters and setters
    public int getEmployeeId() {
        return Employee_id;
    }
    public String getEmployeeName() {
        return Name; 
    }
    public Ticket getTicket(Ticket ticket) {
        return ticket; 
    }

    public void setEmployeeId(int id) {
        Employee_id = id;
    }
    public void setName(String name) {
        Name = name; 
    }
    public void createTicket(Ticket ticket) {
        Incident = ticket; 
    }

    //Method to print employee info
    public String getEmployeeInfo() {
        return String.format("Employee Information\n\tName: %s%n\tEmployee ID: %d%n", Name, Employee_id); 
    }

    public String toString() {
        return getEmployeeInfo();
    }
}
