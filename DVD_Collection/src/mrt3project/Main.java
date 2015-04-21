//Kapusta Jacob COSC4351 Spring 2015
//THIS IS ENTIRELY MY OWN WORK
//I UNDERSTAND THAT TURING IN ANOTHER'S WORK IS CHEATING
//I UNDERSTAND THAT ANY KIND OF DISSEMINATION OF THIS WORK IS CHEATING

package mrt3project;

import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Main {
    static void UCaddDVD(Collection collection1)
    {
            Scanner userInputScanner = new Scanner(System.in);
            String newtitle;
            String newgenre;
            String newruntime;
            int newyear;
            double newprice;

            System.out.println("New Title: ");
            newtitle = userInputScanner.nextLine();
            System.out.println("New Genre: ");
            newgenre = userInputScanner.nextLine();
            System.out.println("New Runtime: ");
            newruntime = userInputScanner.nextLine();
            System.out.println("New Year: ");
            newyear = userInputScanner.nextInt();
            System.out.println("New Price: ");
            newprice = userInputScanner.nextDouble();
            collection1.addDVD(newtitle, newgenre, newruntime, newyear, newprice);
    }
    static void UCremoveDVD(Collection collection1)
    {
            Scanner userInputScanner = new Scanner(System.in);
            String title;
            System.out.println("Title: ");
            title = userInputScanner.nextLine();
            collection1.removeDVD(title);
    }
    static void UCeditinfo(Collection collection1)
    {
            Scanner userInputScanner = new Scanner(System.in);
            String title;
            System.out.println("Title: ");
            title = userInputScanner.nextLine();
            collection1.editDVD(title);
    }
    static void UClistbycategory(Collection collection1)
    {
            Scanner userInputScanner = new Scanner(System.in);
            String category;
            System.out.println("Category: ");
            category = userInputScanner.nextLine();
            collection1.listDVDBYCATEGORY(category);
    }
    static void UCdisplayinfo(Collection collection1)
    {
            Scanner userInputScanner = new Scanner(System.in);
            String title;
            System.out.println("Title: ");
            title = userInputScanner.nextLine();
            collection1.displayDVDINFO(title);
    }
    static void UCdisplaybyyear(Collection collection1)
    {
            collection1.displayDVDBYYEAR();
    }
    static void UCdisplaybytitle(Collection collection1)
    {
            collection1.displayDVDBYTITLE();
    }
    
    public static void main(String[] args) {
        Scanner userInputScanner2 = new Scanner(System.in);
        Collection collection = new Collection();
        collection.loaddata();

        boolean terminate = true;
	String option;
	while(terminate == true)
	{
		System.out.println("A. Add new DVD to collection.");
		System.out.println("B. Remove DVD from collection.");
		System.out.println("C. Edit Information about a DVD in collection.");
		System.out.println("D. List all DVD's by a specific category.");
		System.out.println("E. Retrieve and Display the Information of a DVD Given its Title.");
		System.out.println("F. Display Collection Sorted by Year.");
		System.out.println("G. Display Collection Sorted by Title.");
		System.out.println("H. Nothing.");
		System.out.println("What would you like to do? (Please use only caps - A, B, C, D, E, F, G, or H) : ");
		option = userInputScanner2.nextLine();

		if(option.equals("A"))
		{
			UCaddDVD(collection);
		}
		if(option.equals("B"))
		{
			UCremoveDVD(collection);
		}
		if(option.equals("C"))
		{
			UCeditinfo(collection);
		}
		if(option.equals("D"))
		{
			UClistbycategory(collection);
		}
		if(option.equals("E"))
		{
			UCdisplayinfo(collection);
		}
		if(option.equals("F"))
		{
			UCdisplaybyyear(collection);
		}
		if(option.equals("G"))
		{
			UCdisplaybytitle(collection);
		}
		if(option.equals("H"))
		{
			terminate = false;
		}
	}
    }

}
