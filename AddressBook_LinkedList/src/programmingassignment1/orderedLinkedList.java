// Programming Assignment 1
// AddressBook application using linked lists
// Jacob Kapusta
// 2/11/2013

package programmingassignment1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



/**
 *
 * @author Jacob
 */
public class orderedLinkedList{
    private class Node
    {
        extPersonType value;
        Node next;

        Node(extPersonType val, Node n){
            value = val;
            next = n;
        }
        Node(extPersonType val){
            this(val, null);
        }
    }
    private Node first;
    private Node last;

    public orderedLinkedList(){
        first = null;
        last = null;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public int size(){
        int count = 0;
        Node p = first;
        while(p != null){
            count++;
            p = p.next;
        }
        return count;
    }
    public void add(extPersonType e){
        if(isEmpty()){
            first = new Node(e);
            last = first;
        }
        else{
            last.next = new Node(e);
            last = last.next;
        }
    }
    public boolean delete(String f, String l){
        if(isEmpty())
            return false;
        if(first.value.getPersonType().getFirstName().equals(f) && first.value.getPersonType().getLastName().equals(l)){
            first = first.next;
            if(first == null){
                last = null;
            }
            return true;
        }
        Node pred = first;
        while(pred.next != null && !pred.next.value.getPersonType().getFirstName().equals(f) && !pred.next.value.getPersonType().getLastName().equals(l)){
            pred = pred.next;
        }
        if(pred.next == null){
            return false;
        }
        pred.next = pred.next.next;
        if(pred.next == null){
            last = pred;
        }
        return true;
    }
    public void printStatus(String PS){
        Node ref = first;
        while(ref != null){
            if(ref.value.getPersonStatus().equals(PS)){
                System.out.println(ref.value.getPersonType().getFirstName() + " " + ref.value.getPersonType().getLastName() + "\n");
            }
            ref = ref.next;
        }
    }
    public void printMonth(int m){
        Node ref = first;
        while(ref != null){
            if(ref.value.getDOB().getMonth() == m) {
                System.out.println(ref.value.getPersonType().getFirstName() + " " + ref.value.getPersonType().getLastName() + "\n");
            }
            ref = ref.next;
        }
    }
    public void printInfoSpecific(String f, String l){
        Node ref = first;
        while(ref != null){
            if(ref.value.getPersonType().getFirstName().equals(f) && ref.value.getPersonType().getLastName().equals(l)){
                ref.value.getAddress().printAddress();
                System.out.println("Phone Number: " + ref.value.getPhoneNumber());
                System.out.println("Date of Birth: " + ref.value.getDOB().getMonth() + " ," + ref.value.getDOB().getDay() +
                    ", " + ref.value.getDOB().getYear());
            }
            ref = ref.next;
        }
    }
    public void searchLName(String LN){
        boolean DNE = true;
        Node ref = first;
        while(ref != null){
            if(ref.value.getPersonType().getLastName().equals(LN)){
                System.out.println("The person exists in the system.");
                DNE = false;
                break;
            }
            ref = ref.next;
        }
        if(DNE == true){
            System.out.println("Person does not exist.");
        }
    }
    public void printContent(){
        java.io.File file = new java.io.File("Programming Assignment 1 Data.txt");
        Node ref = first;
        try {
              FileWriter outFile = new FileWriter(file);
              PrintWriter out = new PrintWriter(outFile);

              while(ref != null){
                  out.println(ref.value.getPersonType().getFirstName() + " " + ref.value.getPersonType().getLastName());
                  out.println(ref.value.getDOB().getMonth() + " " + ref.value.getDOB().getDay() + " " + ref.value.getDOB().getYear());
                  out.println(ref.value.getAddress().getStreetAddress());
                  out.println(ref.value.getAddress().getCity());
                  out.println(ref.value.getAddress().getState());
                  out.println(ref.value.getAddress().getZipCode());
                  out.println(ref.value.getPhoneNumber());
                  out.println(ref.value.getPersonStatus());
                  ref = ref.next;
              }
              out.close();
          } catch (IOException e){
              e.printStackTrace();
        }
    }
    
}
