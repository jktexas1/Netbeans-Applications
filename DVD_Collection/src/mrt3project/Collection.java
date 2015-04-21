package mrt3project;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.*;
public class Collection {



private	int noDVDs;
private	DVD collection[] = new DVD[100];


public void loaddata()
{
        java.io.File file = new java.io.File("datafile.txt");
	noDVDs = 0;
	int i = 0;
	String data[] = new String[5];
	
        try{
            Scanner input = new Scanner(file);
            while(input.hasNext()){
                String grabber = input.nextLine();
                String[] result = grabber.split("\\s*,\\s*");
                //System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3] + " " + result[4]);
                collection[noDVDs] = new DVD();
                collection[noDVDs].setTitle(result[0]);
                collection[noDVDs].setGenre(result[1]);
                collection[noDVDs].setRuntime(result[2]);
                collection[noDVDs].setYear(Integer.parseInt(result[3]));
                collection[noDVDs].setPrice(Double.parseDouble(result[4]));
                noDVDs++;
            }
        }
        catch(FileNotFoundException e){
            System.err.format("File does not exist. \n");
        }
		
}
public void addDVD(String title, String category, String runningtime, int year, double price)
{
                collection[noDVDs] = new DVD();
		collection[noDVDs].setTitle(title);
		collection[noDVDs].setGenre(category);
		collection[noDVDs].setRuntime(runningtime);
		collection[noDVDs].setYear(year);
		collection[noDVDs].setPrice(price);
		noDVDs = noDVDs + 1;
}
public void removeDVD(String title)
{
	for(int i = 0; i<noDVDs; i++)
	{
		if(collection[i].getTitle().equals(title))
		{
			for(int j = i; j<noDVDs; j++)
			{
				collection[j] = collection[j+1];
			}
			noDVDs -= 1;
		}
	}
}
public void editDVD(String title)
	{
                Scanner userInputScanner = new Scanner(System.in);
		String newtitle;
		String newgenre;
		String newruntime;
		int newyear;
		double newprice;
		for(int i=0; i<noDVDs; i++)
		{
			if(collection[i].getTitle() == title)
			{
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
				collection[i].setTitle(newtitle);
				collection[i].setGenre(newgenre);
				collection[i].setRuntime(newruntime);
				collection[i].setYear(newyear);
				collection[i].setPrice(newprice);
			}
		}
	}
public void listDVDBYCATEGORY(String category)
{
	for(int i=0; i<noDVDs; i++)
	{
		if(collection[i].getGenre().equals(category))
		{
                    System.out.println(collection[i].getTitle() + ", " + collection[i].getGenre() + ", " + collection[i].getRuntime() +
                            ", " + collection[i].getYear() + ", " + collection[i].getPrice());
		}
	}
}
public void displayDVDINFO(String title)
{
	for(int i=0; i<noDVDs; i++)
	{
		if(collection[i].getTitle().equals(title))
		{
			System.out.println(collection[i].getTitle() + ", " + collection[i].getGenre() + ", " + collection[i].getRuntime() +
                            ", " + collection[i].getYear() + ", " + collection[i].getPrice());
			break;
		}
	}
}
public void displayDVDBYYEAR()
{
	//Bubble Sort
	for(int iEND = noDVDs - 1; iEND > 0; iEND--)
	{
		for(int iINDEX = 0; iINDEX < iEND; iINDEX++)
		{
			if(collection[iINDEX].getYear() > collection[iINDEX + 1].getYear())
			{
                            DVD temp = collection[iINDEX];
                            collection[iINDEX] = collection[iINDEX + 1];
                            collection[iINDEX + 1] = temp;
			}
		}
	}
	//display by year
        for(int i = 0; i < noDVDs; i++)
	{
		System.out.println(collection[i].getTitle() + ", " + collection[i].getGenre() + ", " + collection[i].getRuntime() +
                            ", " + collection[i].getYear() + ", " + collection[i].getPrice());
	}
}
public	void displayDVDBYTITLE()
{
	//Bubble Sort
        int result;
	for(int iEND = noDVDs - 1; iEND > 0; iEND--)
	{
		for(int iINDEX = 0; iINDEX < iEND; iINDEX++)
		{
                        result = collection[iINDEX].getTitle().compareTo(collection[iINDEX + 1].getTitle());
			if(result > 0)
			{
                                DVD temp = collection[iINDEX];
                                collection[iINDEX] = collection[iINDEX + 1];
                                collection[iINDEX + 1] = temp;
			}
		}
	}
	//display by title
	for(int i = 0; i < noDVDs; i++)
	{
		System.out.println(collection[i].getTitle() + ", " + collection[i].getGenre() + ", " + collection[i].getRuntime() +
                            ", " + collection[i].getYear() + ", " + collection[i].getPrice());
	}
}
}
