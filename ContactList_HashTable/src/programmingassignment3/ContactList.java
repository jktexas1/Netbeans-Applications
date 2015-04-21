// Programming Assignment 3
// Contact List Application using Link Based HashTable
// Jacob Kapusta
// 4/8/2013

package programmingassignment3;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
public class ContactList implements ContactListInterface{
    private LinkedList[] contacts = new LinkedList[20];
    private AlphabeticKeys keys = new AlphabeticKeys();

    public ContactList(){
        for(int i = 0; i<20; i++){
            contacts[i] = new LinkedList();
        }
    }
    public void UCaddOrChangeEntry(){
        Scanner input = new Scanner(System.in);
        String option;
        System.out.println("Add or Change?");
        option = input.next();
        if(option.equals("Add")){
            System.out.println("First Name: ");
            String FN = input.next();
            System.out.println("Last Name: ");
            String LN = input.next();
            System.out.println("Phone Number 1: ");
            String PN1 = input.next();
            System.out.println("Phone Number 2: ");
            String PN2 = input.next();
            Contact contact = new Contact(FN, LN, PN1, PN2);
            contacts[contact.getKey()].UCadd(contact);
            keys.UCkadd(FN, LN);
        }
        if(option.equals("Change")){
            System.out.println("First Name: ");
            String FN = input.next();
            System.out.println("Last Name: ");
            String LN = input.next();
            int hashCode = LN.hashCode();
            if(hashCode < 0) hashCode *= -1;
            hashCode = hashCode%20;
            contacts[hashCode].UCsearchANDchange(FN, LN);
        }
    }
    public void UClookUpEntry(){
        Scanner input = new Scanner(System.in);
        System.out.println("First Name: ");
        String FN = input.next();
        System.out.println("Last Name: ");
        String LN = input.next();
        int hashCode = LN.hashCode();
        if(hashCode < 0) hashCode *= -1;
        hashCode = hashCode%20;
        contacts[hashCode].UCsearch(FN, LN);
    }
    public void UCremoveEntry(){
        Scanner input = new Scanner(System.in);
        System.out.println("First Name: ");
        String FN = input.next();
        System.out.println("Last Name: ");
        String LN = input.next();
        int hashCode = LN.hashCode();
        if(hashCode < 0) hashCode *= -1;
        hashCode = hashCode%20;
        contacts[hashCode].UCdelete(FN, LN);
        keys.UCdelete(FN, LN);
    }
    public void UCloadData(){
        java.io.File file = new java.io.File("Programming Assignment 3 Data.txt");
        try{
            Scanner input = new Scanner(file);
            while(input.hasNext()){
                String grabber = input.nextLine();
                String[] result = grabber.split("\\s");
                Contact contact = new Contact(result[0], result[1].substring(0, result[1].length()-1), result[2].substring(0, result[2].length()-1), result[3]);
                contacts[contact.getKey()].UCadd(contact);
                keys.UCkadd(contact.getFirstName(), contact.getLastName());
            }
        }
        catch(FileNotFoundException e){
            System.err.format("File does not exist. \n");
        }
    }
    public void UCdisplay(){
        keys.UCSortAndDisplay(contacts);
    }
    public void UCwriteData(){
        keys.UCwrite(contacts);
    }
}
