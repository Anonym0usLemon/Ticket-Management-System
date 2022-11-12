/***************************************************************
 * Name: Dominic DiModugno
 * Date: October 22nd, 2022
 * 
 * Ticket class for creating tickets to be stored in Database
 * Once implemented. Employee and Manager will be able to interact 
 * with objects of this class from there. 
 */
public class Ticket {
    public int TicketNum;
    public String Description;
    public String Subcategory;
    public String Notes;
    public int Priority; //1 = high : 4 = low    
    public boolean Resolved; 

    public Ticket(int ticketNum, String desc, String category, String notes, int pri, boolean resolved) {
        TicketNum = ticketNum;
        Description = desc;
        Subcategory = category;
        Notes = notes;
        //Validate input for priority
        if (pri  >= 1 && pri <= 4) {
            Priority = pri;
        } 
        else {
            System.out.println("Priority must be between 1 and 4! Please enter a valid priority level...");
        }
        
        Resolved = resolved;
    }

    public Ticket() {
        
    }

    //most getters omitted because the user will get all information fromm the ticket getTicketInfo() 
    
    //getter created for resolved to make the value useable in toString() method
    public String getResolved() {
        if (Resolved) {
            return "Yes";
        }
        else  {
            return "No"; 
        }
    }

    //Include setters in case changes need to be made to tickets. 
    public void setDescription(String desc) {
        Description = desc;
    }
    public void setSubcategory(String category) {
        Subcategory = category;
    }
    public void setNotes(String notes) {
        Notes = notes; 
    }
    public void setPriority(int pri) {
        if (Priority >= 1 && Priority <=4) {
            Priority = pri;
        } 
        else {
            System.out.println("Priority must be between 1 and 4! Please enter a valid priority level...");
        }
    }
    public void setResolved(boolean resolved) {
        Resolved = resolved;
    }


    public String getTicketInfo() {
        return String.format("Ticket Number: %s%nDescription: %s%nSubcategory: %s%nNotes: %s%nPriority: %d%nResolved? %s%n%n", 
                            TicketNum, Description, Subcategory, Notes, Priority, getResolved());
    }

    @Override
    public String toString() {
        return getTicketInfo(); 
    }
}
