// Programming Assignment 1
// AddressBook application using linked lists
// Jacob Kapusta
// 2/11/2013
package programmingassignment1;

import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboardMain = new Scanner(System.in);

        addressBookType addressBook = new addressBookType();
        addressBook.loadData();

        


        System.out.println("All dates are in number Form. Please only enter numbers. EX: 1/2/1955");
        String option = "A";
        while(!option.equals("G")){
            System.out.println("What would you like to do?");
            System.out.println("A. Check if someone exists in the address book.");
            System.out.println("B. Get someone's information.");
            System.out.println("C. Show everyone born on a specific month.(1-12)");
            System.out.println("D. Show everyone of a specific status.");
            System.out.println("E. Add someone to the address book.");
            System.out.println("F. Delete someone from the address book");
            System.out.println("G. Nothing.");
            option = keyboardMain.nextLine();
            if(option.equals("A")){
                addressBook.searchLastName();
            }
            if(option.equals("B")){
                addressBook.printInfo();
            }
            if(option.equals("C")){
                addressBook.printAllOfBirthMonth();
            }
            if(option.equals("D")){
                addressBook.printEnteredStatus();
            }
            if(option.equals("E")){
                addressBook.addPerson();
            }
            if(option.equals("F")){
                addressBook.deletePerson();
            }
            System.out.println("\n");
        }
        addressBook.writeData();
    }
}
