// Programming Assignment 1
// AddressBook application using linked lists
// Jacob Kapusta
// 2/11/2013

package programmingassignment1;

/**
 *
 * @author Jacob
 */
public class addressType {
    private String streetAddress;
    private String city;
    private String state;
    private int zipCode;

    public addressType(){
    }
    public addressType(String A, String C, String S, int Z){
        streetAddress = A;
        city = C;
        state = S;
        zipCode = Z;
    }
    public String getStreetAddress(){
        return streetAddress;
    }
    public String getCity(){
        return city;
    }
    public String getState(){
        return state;
    }
    public int getZipCode(){
        return zipCode;
    }
    public void printAddress(){
        System.out.println("Street Address: " + getStreetAddress() + "\n" +
                "City: " + getCity() + "\n" + "State: " + getState() + "\n" +
                "Zip Code: " + getZipCode());
    }
    public addressType storeAddress(addressType A){
        return A;
    }
}
