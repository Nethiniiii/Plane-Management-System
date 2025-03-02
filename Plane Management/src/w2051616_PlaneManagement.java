/*"I confirm that I understand what plagiarism / collusion / contract cheating is and have read and
 understood the section on Assessment Offences in the Essential Information for Students.
 The work that I have submitted is entirely my own.
 Any work from other authors is duly referenced and acknowledged."
 Name : S. A. Nethini Pabodhya Perera
 Student ID : 20230282 / w2051616 */



import java.util.InputMismatchException;
import java.util.Scanner;
//Define a class.
public class w2051616_PlaneManagement {
    // Create a Scanner object for user inputs.
    public static Scanner input = new Scanner(System.in);

    // Create an arrays to represent seat rows A, B, C, and D.
    public static int[][] seatrow_A = {{0, 0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0, 0}};
    public static int[][] seatrow_B = {{0, 0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0}};
    public static int[][] seatrow_C = {{0, 0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0}};
    public static int[][] seatrow_D = {{0, 0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0, 0}};
    // Create an array to store Ticket objects.
    public static Ticket[] ticket_array = new Ticket[52];

    // A method to display seating rows.
    private static void seatrow_array(int[][] seatrow, String row) {
        System.out.print("    " + row + ": ");
        for (int p = 0; p < seatrow.length; p++) {
            System.out.print(" ");
            for (int r = 0; r < seatrow[p].length; r++) {
                if ((seatrow[p][r]) == 0) {      // A condition to display available seats.
                    System.out.print( Green+ " O" + Reset);
                } else if ((seatrow[p][r]) == 1) {     // A condition to display booked seats.
                    System.out.print(   Blue + " X" + Reset);
                }

            }
        }
        System.out.println(" \n ");
    }

    // A method to display the entire seating plan.
    private static void show_seating_plan() {
        //
        seatrow_array(seatrow_A, " A ");
        seatrow_array(seatrow_B, " B ");
        seatrow_array(seatrow_C, " C ");
        seatrow_array(seatrow_D, " D ");
    }

    // Variable declarations.
    public static String row_letter;
    public static int seat_number;
    public static double ticket_price;

    // A method to select a seat row.
    private static void select_seatrow() {
        System.out.print(" please enter a row letter as your seat row: ");
        row_letter = input.next();
        switch (row_letter) {
            case "A":
                break;
            case "B":
                break;
            case "C":
                break;
            case "D":
                break;
            default:
                System.out.println("Invalid Row Letter");
                select_seatrow();     // Recursive call if an invalid row letter is entered.
        }
    }

    // A method to select a seat number.
    private static void select_seatnumber() {
        while (true) {    // A while loop for recalling the same method.
            try {
                System.out.print(" Please enter a seat number: ");
                seat_number = input.nextInt();
                if ((row_letter.equals("A")) || (row_letter.equals("D"))) {
                    if ((seat_number > 0) && (seat_number <= 14)) {     // A condition to check the correct range.
                        break;
                    } else {
                        System.out.println("seat number is out of range");
                        continue;
                    }

                } else if ((row_letter.equals("B")) || (row_letter.equals("C"))) {
                    if ((seat_number > 0) && (seat_number <= 12)) {
                        break;
                    } else {
                        System.out.println("seat number is out of range");
                        continue;
                    }
                }
            } catch (InputMismatchException e) {     //exceptional handling for validations.
                System.out.println("Integer Required");
                input.nextLine();
            } catch (Exception e) {
                input.nextLine();
            }
        }
    }

    // Main method.
    public static void main(String[] args) {

        // Display welcome message and menu options.
        System.out.println( Green + "         Welcome to the Plane Management application!     " + Reset);
        System.out.println( Blue + "**************************************************************" + Reset);
        System.out.println( Blue + "*" + Reset + Green +"                        MENU OPTIONS                        "+ Reset + Blue +"*" + Reset);
        System.out.println( Blue + "**************************************************************" + Reset);
        System.out.println(" 1) Buy a seat ");
        System.out.println(" 2) Cancel a seat ");
        System.out.println(" 3) Find first available seat ");
        System.out.println(" 4) Show seating plan ");
        System.out.println(" 5) Print tickets information and total sales ");
        System.out.println(" 6) Search tickets ");
        System.out.println(" 0) Quit ");
        System.out.println( Blue + "**************************************************************" + Reset);
        System.out.print("Do you want to continue? please enter 'Y' for yes or 'O' for no: ");
        String decision = input.next();
        boolean Continue = true;
        while (Continue) {
            try {
                if (decision.equalsIgnoreCase("Y")) {
                    System.out.print(" Please select an option: ");   // Prompt user to select an option
                    String option = input.next();
                    switch (option) {
                        case ("1") :
                            buy_seat();
                            break;
                        case ("2") :
                            cancel_seat();
                            break;
                        case ("3") :
                            find_first_available();
                            break;
                        case ("4") :
                            show_seating_plan();
                            break;
                        case ("5") :
                            print_tickets_info();
                            break;
                        case ("6") :
                            search_ticket();
                            break;
                        case ("O") :                      // Quit the program
                            System.out.println(Blue + "END" + Reset);
                            Continue = false;
                            break;
                        default:
                            System.out.print( Green + " Invalid Option" + Reset +" \n Do you want to start again? please enter 'Y' for yes or 'O' for no: ");
                            decision = input.next();
                            break;
                    }

                } else if (decision.equalsIgnoreCase("O")) {
                    System.out.println(Blue + "END" + Reset);
                    Continue = false;
                    break;
                } else {
                    System.out.print(" Invalid \n  please enter 'Y' for yes or 'O' for no:");
                    decision = input.next();
                }
            } catch (InputMismatchException e) {
                System.out.println(Green + "Integer Required" + Reset);
                input.nextLine();
            } catch (Exception e) {
                input.nextLine();
            }
        }
    }

    // A method to prompt user to add details when adding a ticket
    private static void add_ticket() {
        input.nextLine();
        System.out.print("Please enter your name : ");
        String Name = input.nextLine();
        System.out.print("Please enter your surname : ");
        String Surname = input.nextLine();
        System.out.print("Please enter your Email-Address  : ");
        String Email = input.nextLine();

        // Create a Person object with person information.
        Person personInfo = new Person();
        personInfo.setName(Name);
        personInfo.setSurname(Surname);
        personInfo.setEmail(Email);

        // Create a Ticket object with seat and person information
        Ticket ticketInfo = new Ticket();
        ticketInfo.setRow(row_letter);
        ticketInfo.setSeat_number(seat_number);
        ticketInfo.setPerson_info(personInfo);
        ticketInfo.setTicket_price(ticket_price);

        // A loop to find an empty seat to add the ticket in ticket array
        for (int i = 0; i < ticket_array.length; i++) {
            if (ticket_array[i] == null) {
                ticket_array[i] = ticketInfo;   // Add the ticket to the first available seat in the ticket array.
                ticketInfo.write_info();   // Save ticket and person information to a file.
                 break;
            }
        }
    }

    // Method to display tickets information and total sales.
    private static void print_tickets_info() {
        double Total_Sales = 0;
        for (Ticket element : ticket_array) {    // Iterate through the ticket array
            if (element != null) {
                element.display_ticket_info();   // Display information of each ticket
                Total_Sales += element.getTicket_price();   // Add each ticket price to total sales
            }
        }
        System.out.println(Blue + "Total Sales of tickets : " + "£" + Total_Sales + Reset); // Display total sales.
    }


    private static void buy_seat() {     // Method to buy a seat
        select_seatrow();     //calling select seat row method.
        select_seatnumber();   //calling select seat number method.

        // Check which row the seat belongs to user inputs and calling if seat available method.
        if (row_letter.equals("A")) {
            if_seat_available(seatrow_A);
        } else if (row_letter.equals("B")) {
            if_seat_available(seatrow_B);
        } else if (row_letter.equals("C")) {
            if_seat_available(seatrow_C);
        } else if (row_letter.equals("D")) {
            if_seat_available(seatrow_D);
        }
    }

    // Method to check if the selected seat is available
    private static void if_seat_available(int[][] array) {
        if ((seat_number > 0) && (seat_number <= 5)) {
            if ((array[0][seat_number - 1]) == 0) {       // A condition to display that the seat is available.
                System.out.println(Green + " Seat is available" + Reset);
                (array[0][seat_number - 1]) = 1;    // Marked that available seat booked.
                ticket_price = 200;    // Assigning a value to ticket price.
                add_ticket();   //calling the method add ticket.
            } else {
                System.out.println(Blue + "Seat was already booked" + Reset);   // Display that the seat is already booked.
            }
        } else if ((seat_number > 5) && (seat_number <= 9)) {
            if ((array[1][seat_number - 6]) == 0) {
                System.out.println(Green + " Seat is available" + Reset);
                (array[1][seat_number - 6]) = 1;
                ticket_price = 150;
                add_ticket();
            } else {
                System.out.println(Blue + "Seat was already booked" + Reset);
            }
        } else if ((seat_number > 9) && (seat_number <= 14)) {
            if ((array[2][seat_number - 10]) == 0) {
                System.out.println(Green + " Seat is available" + Reset);
                (array[2][seat_number - 10]) = 1;
                ticket_price = 180;
                add_ticket();
            } else {
                System.out.println(Blue + "Seat was already booked" + Reset);
            }
        } else {
            System.out.println(Green + "seat number is out of range" + Reset);
        }
    }


    private static void cancel_seat() {    // Method to cancel a seat
        select_seatrow();     //calling select seat row method.
        select_seatnumber();   //calling select seat number method.

        // Check which row the seat belongs to user inputs and calling if seat already booked method.
        if (row_letter.equals("A")) {
            if_seat_alreadyBooked(seatrow_A);
        } else if (row_letter.equals("B")) {
            if_seat_alreadyBooked(seatrow_B);
        } else if (row_letter.equals("C")) {
            if_seat_alreadyBooked(seatrow_C);
        } else if (row_letter.equals("D")) {
            if_seat_alreadyBooked(seatrow_D);
        }
    }

    // Method to cancel a ticket and person information.
    private static void cancel_ticket() {
        for (int i = 0; i < ticket_array.length; i++) {
            if (ticket_array[i] != null && ticket_array[i].getRow().equals(row_letter) && (ticket_array[i].getSeat_number()) == seat_number) {
                ticket_array[i].deleteInfo_file();        // Delete ticket information that saved before to a file.
                ticket_array[i] = null;          // Remove ticket from array
                break;
            }
        }
    }

    // Method to check if the selected seat is already booked
    private static void if_seat_alreadyBooked(int[][] Array) {
        if ((seat_number > 0) && (seat_number <= 5)) {
            if ((Array[0][seat_number - 1]) == 1) {    // A condition to display that the seat is already booked.
                (Array[0][seat_number - 1]) = 0;      //Marked that booked seat is available.
                cancel_ticket();         //calling the method cancel ticket.
                System.out.println(Blue + " The seat has been successfully cancelled " + Reset);
            } else {
                System.out.println(Blue + "seat is already not available" + Reset);      // Display seat is already not available

            }
        } else if ((seat_number > 5) && (seat_number <= 9)) {
            if ((Array[1][seat_number - 6]) == 1) {
                (Array[1][seat_number - 6]) = 0;
                cancel_ticket();
                System.out.println(Blue + " The seat has been successfully cancelled " + Reset);
            } else {
                System.out.println(Blue + "seat is already not available" + Reset);
            }
        } else if ((seat_number > 9) && (seat_number <= 14)) {
            if ((Array[2][seat_number - 10]) == 1) {
                (Array[2][seat_number - 10]) = 0;
                cancel_ticket();
                System.out.println(Blue + " The seat has been successfully cancelled " + Reset);
            } else {
                System.out.println(Blue + "seat is already not available" + Reset);
            }
        } else {
            System.out.println(Green+ "seat number is out of range" + Reset);
        }

    }

    public static int k;   //variable declaration.
    public static int m;

    // Method to find the first available seat in a given seat row.
    private static void find_the_array(int[][] newarray) {

        // Loop through each row and column in the seat row.
        outerLoop:
        for (k = 0; k < 3; k++) {
            innerLoop:
            // Check if the seat is available (marked as 0).
            for (m = 0; m < newarray[k].length; m++) {
                if (newarray[k][m] == 0) {
                    statement = "available";     // Set the statement to indicate the availability.
                    break outerLoop;             // Break out of the outer loop once an available seat is found.
                } else {
                    statement = "not_available";     // If seat is not available, set the statement.
                }
            }
        }
    }

    // Method to display the found available seat.
    private static void found() {
        if (k == 0) {
            System.out.println(Blue + " The seat number is : " + (m + 1) + Reset);   // Display seat which starts numbering from 1
        } else if (k == 1) {
            System.out.println(Blue + " The first available seat number is : " + (m + 6) + Reset);  // Display seat which starts numbering from 6.
        } else if (k == 2) {
            System.out.println(Blue + " The first available seat number is : " + (m + 10) + Reset);  // Display seat which starts numbering from 10.
        }
    }

    public static String statement;   // variable declaration.
    public static String x;

    // Method to find the first available seat in any seat row.
    private static void find_first_available() {
        x = "True";       // Control variable
        if (x.equals("True")) {
            find_the_array(seatrow_A);    // Check Seat Row A available that seat.
            if (statement.equals("available")) {
                System.out.println(Blue + " The first available seat in Seat Row A" + Reset);
                found();    // Calling found method.
            } else if (statement.equals("not_available")) {
                find_the_array(seatrow_B);     // Check Seat Row B available that seat.
                if (statement.equals("available")) {
                    System.out.println(Blue + " The first available seat in Seat Row B" + Reset);
                    found();     // Calling found method.
                } else if (statement.equals("not_available")) {
                    find_the_array(seatrow_C);     // Check Seat Row C available that seat.
                    if (statement.equals("available")) {
                        System.out.println(Blue + " The first available seat in Seat Row C" + Reset);
                        found();     // Calling found method.
                    } else if (statement.equals("not_available")) {
                        find_the_array(seatrow_D);     // Check Seat Row D available that seat.
                        if (statement.equals("available")) {
                            System.out.println(Blue + " The first available seat in Seat Row D" + Reset);
                            found();     // Calling found method.
                        } else {    // Display that all the seats are booked.
                            System.out.println(Green + " SORRY \n All the seats are already booked in this plane" + Reset);
                        }
                    }
                }
            }
        }
    }

    // Method to search for a ticket.
    private static void search_ticket() {
        select_seatrow();     //calling select seat row method.
        select_seatnumber();     //calling select seat number method.
        if (row_letter.equals("A")) {
            search_if_booked(seatrow_A);     // Search if the seat is in Seat Row A is booked.
        } else if (row_letter.equals("B")) {
            search_if_booked(seatrow_B);     // Search if the seat in Seat Row B is booked.
        } else if (row_letter.equals("C")) {
            search_if_booked(seatrow_C);     // Search if the seat in Seat Row C is booked.
        } else if (row_letter.equals("D")) {
            search_if_booked(seatrow_D);     // Search if the seat in Seat Row D is booked.
        }
    }

    // Method to check if a seat is booked and display information.
    private static void search_if_booked(int[][] searcharray) {
        if ((seat_number > 0) && (seat_number <= 5)) {
            if ((searcharray[0][seat_number - 1]) == 1) {
                for (int i = 0; i < ticket_array.length; i++) {
                    if (ticket_array[i] != null && ticket_array[i].getRow().equals(row_letter) && (ticket_array[i].getSeat_number()) == seat_number) {
                        ticket_array[i].display_ticket_info();       // Display ticket information if the seat is booked.
                        break;
                    }
                }

            } else if ((searcharray[0][seat_number - 1]) == 0) {
                System.out.println( Blue +  "This seat is available" + Reset);        // If seat is not booked, indicate availability
            }
        } else if ((seat_number > 5) && (seat_number <= 9)) {
            if ((searcharray[1][seat_number - 6]) == 1) {
                for (int i = 0; i < ticket_array.length; i++) {
                    if (ticket_array[i] != null && ticket_array[i].getRow().equals(row_letter) && (ticket_array[i].getSeat_number()) == seat_number) {
                        ticket_array[i].display_ticket_info();
                        break;
                    }
                }

            } else if ((searcharray[1][seat_number - 6]) == 0) {
                System.out.println( Blue +  "This seat is available" + Reset);
            }
        } else if ((seat_number > 9) && (seat_number <= 14)) {
            if ((searcharray[2][seat_number - 10]) == 1) {
                for (int i = 0; i < ticket_array.length; i++) {
                    if (ticket_array[i] != null && ticket_array[i].getRow().equals(row_letter) && (ticket_array[i].getSeat_number()) == seat_number) {
                        ticket_array[i].display_ticket_info();
                        break;
                    }
                }

            } else if ((searcharray[2][seat_number - 10]) == 0) {
                System.out.println( Blue +  "This seat is available" + Reset);
            }
        }
    }
    public static String Green = "\u001B[32m";
    public static String Blue = "\u001B[34m";
    public static String Reset = "\u001B[0m";
}



