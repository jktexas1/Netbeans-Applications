// Programming Assignment 3
// Contact List Application using Link Based HashTable
// Jacob Kapusta
// 4/8/2013

package programmingassignment3;

import java.util.Scanner;
public class LinkedList{
    private class Node
    {
        Contact value;
        Node next;

        Node(Contact val, Node n){
            value = val;
            next = n;
        }
        Node(Contact val){
            this(val, null);
        }
    }
    private Node first;
    private Node last;

    public LinkedList(){
        first = null;
        last = null;
    }
    public boolean UCisEmpty(){
        if(first == null){
            return true;
        }
        else
            return false;
    }
    public int UCsize(){
        int count = 0;
        Node p = first;
        while(p != null){
            count++;
            p = p.next;
        }
        return count;
    }
    public void UCsearch(String FN, String LN){
        boolean exists = false;
        Node ref = first;
        while(ref != null){
            if(ref.value.getFirstName().equals(FN) && ref.value.getLastName().equals(LN)){
                System.out.println(ref.value.getFirstName() + " " + ref.value.getLastName());
                System.out.println("Phone Numbers: "+ ref.value.getPN1()+" "+ref.value.getPN2());
                System.out.println();
                exists = true;
            }
            ref = ref.next;
        }
        if(exists == false){
            System.out.println("Contact does not exist");
        }
    }
    public Contact UCgetContact(String FN, String LN){
        boolean exists = false;
        Contact contact = new Contact();
        Node ref = first;
        while(ref != null){
            if(ref.value.getFirstName().equals(FN) && ref.value.getLastName().equals(LN)){
                exists = true;
                contact = ref.value;
            }
            ref = ref.next;
        }
        if(exists == false){
            System.out.println("Contact does not exist");
        }
        return contact;
    }
    public void UCsearchANDchange(String FN, String LN){
        Scanner input = new Scanner(System.in);
        boolean exists = false;
        Node ref = first;
        while(ref!=null){
            if(ref.value.getFirstName().equals(FN) && ref.value.getLastName().equals(LN)){
                exists = true;
                System.out.println("Enter new phone Number 1: ");
                String PN1 = input.next();
                System.out.println("Enter new Phone Number 2: ");
                String PN2 = input.next();
                ref.value.setPN1(PN1);
                ref.value.setPN2(PN2);
            }
            ref = ref.next;
        }
        if(exists == false) System.out.println("Contact does not exist.");
    }
    public void UCadd(Contact e){
        if(UCisEmpty()){
            first = new Node(e);
            last = first;
        }
        else{
            last.next = new Node(e);
            last = last.next;
        }
    }
    public boolean UCdelete(String f, String l){
        if(UCisEmpty())
            return false;
        if(first.value.getFirstName().equals(f) && first.value.getLastName().equals(l)){
            first = first.next;
            if(first == null){
                last = null;
            }
            return true;
        }
        Node pred = first;
        while(pred.next != null && !pred.next.value.getFirstName().equals(f) && !pred.next.value.getLastName().equals(l)){
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
}
