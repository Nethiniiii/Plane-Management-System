// A Java class which is named as "Person".
public class Person {
    private String name;  // Here are private instance variables which represent the name, surname, and email of the person.
    private String surname;
    private String email;


    // Here is a default constructor method with no parameters.
    public Person (){
        this.name = "Not Defined";
        this.surname = "Not Defined";
        this.email = "Not Defined";
    }

    // Here is a constructor method with parameters for name, surname, and email.
    public Person(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    // These are getter methods.
    // A method which returns the name of the person.
    public String getName(){
        return this.name;
    }

    // A method which returns the surname of the person.
    public String getSurname(){
        return this.surname;
    }

    // A method which returns the email of the person.
    public String getEmail(){
        return this.email;
    }

    // These are setter methods.
    // A method which sets the name of the person.
    public void setName(String name){
        this.name = name;
    }

    // A method which sets the surname of the person.
    public void setSurname(String surname){
        this.surname = surname;
    }

    // A method which sets the email of the person.
    public void setEmail(String email){
        this.email = email;
    }

    // A method which prints the information of the person.
    public void Person_information(){
        System.out.println("Name : " + getName());
        System.out.println("Surname : " + getSurname());
        System.out.println("Email : " + getEmail() );
    }
}