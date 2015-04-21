// Programming Assignment 1
// AddressBook application using linked lists
// Jacob Kapusta
// 2/11/2013

package programmingassignment1;

/**
 *
 * @author Jacob
 */
public class dateType {
    private int month;
    private int day;
    private int year;

    public dateType(int M, int D, int Y){
        month = M;
        day = D;
        year = Y;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    public int getYear(){
        return year;
    }
    public void printDate(){
        System.out.println("Month: " + getMonth() + "\n" + "Day: " + getDay() + "\n" +
                "Year: " + getYear() + "\n");
    }
}
