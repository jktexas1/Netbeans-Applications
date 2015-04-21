// Programming Assignment 3
// Contact List Application using Link Based HashTable
// Jacob Kapusta
// 4/8/2013

package programmingassignment3;

/**
 *
 * @author Jacob
 */
public class Contact {
    private String firstName;
    private String lastName;
    private int key;
    private String PN1;
    private String PN2;

    public Contact(){
    }
    public Contact(String fn, String ln, String P1, String P2){
        firstName = fn;
        lastName = ln;
        key = ln.hashCode();
        PN1 = P1;
        PN2 = P2;
        if(key < 0) key *= -1;
        key = key%20;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setPN1(String pn1){
        PN1 = pn1;
    }
    public void setPN2(String pn2){
        PN2 = pn2;
    }
    public int getKey(){
        return key;
    }
    public String getPN1(){
        return PN1;
    }
    public String getPN2(){
        return PN2;
    }
}
