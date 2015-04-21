// Programming Assignment 1
// AddressBook application using linked lists
// Jacob Kapusta
// 2/11/2013

package programmingassignment1;

/**
 *
 * @author Jacob
 */
public class personType {
    private String firstName;
    private String lastName;

    public personType(String F, String L){
        firstName = F;
        lastName = L;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void PrintPersonType(){
        System.out.println("First Name: " + getFirstName() + "\n" + "Last Name: " + getLastName() + "\n");
    }
    public personType storePerson(personType P){
        return P;
    }
}
