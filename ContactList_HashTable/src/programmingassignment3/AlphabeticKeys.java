// Programming Assignment 3
// Contact List Application using Link Based HashTable
// Jacob Kapusta
// 4/8/2013

package programmingassignment3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class AlphabeticKeys {
    private class Node
    {
        String value;
        String value2;
        Node next;

        Node(String val, String val2, Node n){
            value = val;
            value2 = val2;
            next = n;
        }
        Node(String val, String val2){
            this(val,val2, null);
        }
    }
    private Node first;
    private Node last;
    public void UCkadd(String f, String l){
        if(UCisEmpty()){
            first = new Node(f, l);
            last = first;
        }
        else{
            last.next = new Node(f, l);
            last = last.next;
        }
    }
    public void UCSortAndDisplay(LinkedList[] Contacts){
        //Selection Sort
        Node noderef1 = first;
        Node noderef2 = noderef1;
        Node noderef3 = noderef1;
        String temp, temp2;
        while(noderef1 != null){
            while(noderef2 != null){
                if(noderef2.value2.compareTo(noderef1.value2) < 0){
                    noderef3 = noderef2;
                }
                noderef2 = noderef2.next;
            }
            temp = noderef3.value;
            temp2 = noderef3.value2;
            noderef3.value = noderef1.value;
            noderef3.value2 = noderef1.value2;
            noderef1.value = temp;
            noderef1.value2 = temp2;
            noderef1 = noderef1.next;
            noderef2 = noderef1;
            noderef3 = noderef2;
        }
         
        noderef1 = first;
        while(noderef1 != null){
            int hashCode = noderef1.value2.hashCode();
            if(hashCode < 1) hashCode *= -1;
            hashCode = hashCode%20;
            Contacts[hashCode].UCsearch(noderef1.value, noderef1.value2);
            noderef1 = noderef1.next;
        }
    }
    public boolean UCdelete(String f, String l){
        if(UCisEmpty())
            return false;
        if(first.value.equals(l) && first.value2.equals(l)){
            first = first.next;
            if(first == null){
                last = null;
            }
            return true;
        }
        Node pred = first;
        while(pred.next != null && !pred.next.value.equals(l) && !pred.next.value2.equals(l)){
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
    public void UCwrite(LinkedList[] Contacts){
        Contact contact = new Contact();
        //Selection Sort
        Node noderef1 = first;
        Node noderef2 = noderef1;
        Node noderef3 = noderef1;
        String temp, temp2;
        while(noderef1 != null){
            while(noderef2 != null){
                if(noderef2.value2.compareTo(noderef1.value2) < 0){
                    noderef3 = noderef2;
                }
                noderef2 = noderef2.next;
            }
            temp = noderef3.value;
            temp2 = noderef3.value2;
            noderef3.value = noderef1.value;
            noderef3.value2 = noderef1.value2;
            noderef1.value = temp;
            noderef1.value2 = temp2;
            noderef1 = noderef1.next;
            noderef2 = noderef1;
            noderef3 = noderef2;
        }

        java.io.File file = new java.io.File("Programming Assignment 3 Data.txt");
        Node ref = first;
        try {
              FileWriter outFile = new FileWriter(file);
              PrintWriter out = new PrintWriter(outFile);

              while(ref != null){
                  int hashCode = ref.value2.hashCode();
                  if(hashCode < 1) hashCode *= -1;
                  hashCode = hashCode%20;
                  contact = Contacts[hashCode].UCgetContact(ref.value, ref.value2);
                  out.println(contact.getFirstName() + " " + contact.getLastName() + ": " + contact.getPN1() + ", " + contact.getPN2());
                  ref = ref.next;
              }
              out.close();
          } catch (IOException e){
              e.printStackTrace();
        }
    }
    public boolean UCisEmpty(){
        if(first == null){
            return true;
        }
        else
            return false;
    }
}
