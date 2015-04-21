// Programming Assignment 1
// AddressBook application using linked lists
// Jacob Kapusta
// 2/11/2013

package programmingassignment1;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

public class addressBookType{
    
    private orderedLinkedList list = new orderedLinkedList();
    
    Scanner keyboard = new Scanner(System.in);

    public void loadData(){
        java.io.File file = new java.io.File("Programming Assignment 1 Data.txt");
        String data[] = new String[8];
        int index = 0;
        try{
            Scanner input = new Scanner(file);
            while(input.hasNext()){
                String grabber = input.nextLine();
                data[index] = grabber;
                if(index == 7){
                    //personType
                    String[] result = data[0].split("\\s");
                    personType p1 = new personType(result[0], result[1]);
                    //dateType
                    String[] result2 = data[1].split("\\s");
                    dateType d1 = new dateType(Integer.parseInt(result2[0]), Integer.parseInt(result2[1]), Integer.parseInt(result2[2]));
                    //addressType
                    addressType a1 = new addressType(data[2], data[3], data[4], Integer.parseInt(data[5]));
                    //extPersonType
                    extPersonType ept = new extPersonType(data[6], data[7], a1, d1, p1);
                    index = 8;
                    list.add(ept);
                }
                if(index != 8) index++;
                if(index == 8) index = 0;
            }
        }
        catch(FileNotFoundException e){
            System.err.format("File does not exist. \n");
        }

    }
    public void searchLastName(){
        System.out.println("Enter Last Name: ");
        String LastName;
        LastName = keyboard.next();
        list.searchLName(LastName);
    }
    public void printInfo(){
        String FName;
        String LName;
        System.out.println("Enter First Name: ");
        FName = keyboard.next();
        System.out.println("Enter Last Name: ");
        LName = keyboard.next();
        //System.out.println("Address:");
        list.printInfoSpecific(FName, LName);
    }
    public void printAllOfBirthMonth(){
        int month;
        System.out.println("Enter Month: ");
        month = keyboard.nextInt();
        list.printMonth(month);
    }
    public void printEnteredStatus(){
        String status;
        System.out.println("Enter Status: ");
        status = keyboard.next();
        list.printStatus(status);
    }
    public void addPerson(){
        //Enter Street Address
        String SA;
        System.out.println("Enter Street Address: ");
        SA = keyboard.nextLine();
        //Enter City
        String city;
        System.out.println("Enter City: ");
        city = keyboard.nextLine();
        //Enter last name
        String LName;
        System.out.println("Enter Last Name: ");
        LName = keyboard.next();
        //Enter first name
        String FName;
        System.out.println("Enter First Name: ");
        FName = keyboard.next();
        //Enter Month
        int month;
        System.out.println("Enter Birth Month: ");
        month = keyboard.nextInt();
        //Enter day D;
        int day;
        System.out.println("Enter Day of Birth: ");
        day = keyboard.nextInt();
        //Enter Year
        int year;
        System.out.println("Enter Birth Year: ");
        year = keyboard.nextInt();
        //Enter State
        String state;
        System.out.println("Enter State: ");
        state = keyboard.next();
        //Enter Zip Code
        int ZC;
        System.out.println("Enter Zip Code: ");
        ZC = keyboard.nextInt();
        //Enter Person Status
        String PS;
        System.out.println("Enter Person Status: ");
        PS = keyboard.next();
        //Enter Phone Number
        String PN;
        System.out.println("Enter Phone Number ");
        PN = keyboard.next();

        
        dateType D = new dateType(month, day, year);
        addressType A = new addressType(SA, city, state, ZC);
        personType P = new personType(FName, LName);
        extPersonType person = new extPersonType(PN, PS, A, D, P);
                
        list.add(person);
    }
    public void deletePerson(){
        System.out.println("Enter First Name: ");
        String FName = keyboard.next();
        System.out.println("Enter Last Name: ");
        String LName = keyboard.next();
        list.delete(FName, LName);
        System.out.println(LName + ", " + FName + " has been deleted");
    }
    public void writeData(){
        list.printContent();
    }
}
