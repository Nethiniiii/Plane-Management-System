import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
// A Java class which is named as Ticket
public class Ticket {
    private String Row;    // Here are private instance variables which represent the seat row, seat number, ticket price and person information.
    private int Seat_number;
    private double Ticket_price;
    private Person person_info;

    // Here is a default constructor method with no parameters.
    public Ticket() {
        this.Row = "Not defined";
        this.Seat_number = 0;
        this.Ticket_price = 0;
        this.person_info = null;
    }

    // Here is a constructor method with parameters for seat row, seat number, ticket price and person information.
    public Ticket(String Row, int Seat_number, double Ticket_price, Person person_info) {
        this.Row = Row;
        this.Seat_number = Seat_number;
        this.Ticket_price = Ticket_price;
        this.person_info = person_info;
    }

    // These are getter methods.
    // A method which returns the name of the ticket row.
    public String getRow() {
        return this.Row;
    }

    // A method which returns the name of the ticket seat number.
    public int getSeat_number() {
        return this.Seat_number;
    }

    // A method which returns the name of the ticket price.
    public double getTicket_price() {
        return this.Ticket_price;
    }

    // Here is a setter method for retrieving the person information associated with the ticket.
    public Person getPerson_info() {
        return this.person_info;
    }

    // Here is a setter method for setting the seat row.
    public void setRow(String Row) {
        this.Row = Row;
    }

    // Here is a setter method for setting the seat number.
    public void setSeat_number(int Seat_number) {
        this.Seat_number = Seat_number;
    }

    // Here is a setter method for setting the ticket price.
    public void setTicket_price(double Ticket_price) {
        this.Ticket_price = Ticket_price;
    }

    // Here is a setter method for setting the person information.
    public void setPerson_info(Person person_info) {
        this.person_info = person_info;
    }

    // A method to display information about the ticket and the person.
    public void display_ticket_info() {
        getPerson_info().Person_information();
        System.out.println("Seat Row : " + getRow());
        System.out.println("Seat number : " + getSeat_number());
        System.out.println("Ticket Price : " + getTicket_price());
        System.out.println();
    }

    // A method to write ticket information to a text file when ticket is booked.
    public void write_info() {
        try {
            FileWriter file_save = new FileWriter("C:\\Users\\ASUS\\Desktop\\Viva\\"+ getRow() + getSeat_number() + ".txt");
            file_save.write("Seat row :  " + this.getRow() + "\n");
            file_save.write("Seat number : " + this.getSeat_number() + "\n");
            file_save.write("Ticket price : " + this.getTicket_price() + "\n");
            file_save.write("Name : " + this.getPerson_info().getName() + " " + this.getPerson_info().getSurname() + "\n");
            file_save.write("Email Address : " + getPerson_info().getEmail() + "\n");
            file_save.close();
            System.out.println("successfully saved");
        } catch (IOException e) {
            System.out.println("Error occurred " + e.getMessage());
        }

    }

    // A method to delete the ticket information file if ticket canceled.
    public void deleteInfo_file() {
            File folder = new File("C:\\Users\\ASUS\\Desktop\\Viva\\"+ getRow() + getSeat_number() + ".txt");
        try {
            if (folder.exists()) {
                folder.delete();
                System.out.println("successfully deleted the ticket information");
            } else {
                System.out.println("Folder does not exist");
            }
        } catch (Exception e) {
            System.out.println("Error occurred ");
        }

    }
}