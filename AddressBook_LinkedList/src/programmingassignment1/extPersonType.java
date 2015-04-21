// Programming Assignment 1
// AddressBook application using linked lists
// Jacob Kapusta
// 2/11/2013

package programmingassignment1;

/**
 *
 * @author Jacob
 */
public class extPersonType{
    private addressType address;
    private dateType DOB;
    private String phoneNumber;
    private String personStatus;
    private personType person;

    
    public extPersonType(String P, String PS, addressType A, dateType D, personType Per){
        phoneNumber = P;
        personStatus = PS;
        address = A;
        DOB = D;
        person = Per;
    }
    public addressType getAddress(){
        return address;
    }
    public dateType getDOB(){
        return DOB;
    }
    public personType getPersonType(){
        return person;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getPersonStatus(){
        return personStatus;
    }
}
