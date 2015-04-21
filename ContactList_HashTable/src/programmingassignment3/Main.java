// Programming Assignment 3
// Contact List Application using Link Based HashTable
// Jacob Kapusta
// 4/8/2013

package programmingassignment3;

import java.util.Scanner;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        ContactList contacts = new ContactList();
        boolean close = false;
        int option;
        
        contacts.UCloadData();
        
        
        while(close != true){
            System.out.println("What would you like to do?");
            System.out.println("1. Add or change an entry.");
            System.out.println("2. Look up an entry.");
            System.out.println("3. Remove an entry.");
            System.out.println("4. Display contents.");
            System.out.println("5. Nothing.");
            option = keyboard.nextInt();

            if(option == 1){
                contacts.UCaddOrChangeEntry();
            }
            else if(option == 2)
            {
                contacts.UClookUpEntry();
            }
            else if(option == 3)
            {
                contacts.UCremoveEntry();
            }
            else if(option == 4)
            {
                contacts.UCdisplay();
            }
            else if(option == 5){
                close = true;
            }
            else{
                System.out.println("Not a valid option.");
            }
        }
        contacts.UCwriteData();
    }

}
