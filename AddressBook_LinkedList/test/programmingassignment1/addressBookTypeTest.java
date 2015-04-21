// Programming Assignment 1
// AddressBook application using linked lists
// Jacob Kapusta
// 2/11/2013

package programmingassignment1;

import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jacob
 */
public class addressBookTypeTest {

    public addressBookTypeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of loadData method, of class addressBookType.
     */
    @Test
    public void testLoadData() {
        orderedLinkedList list = new orderedLinkedList();
        Scanner keyboard = new Scanner(System.in);
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

    /**
     * Test of searchLastName method, of class addressBookType.
     */
    @Test
    public void testSearchLastName() {
        personType PH = new personType("Jacob", "Kapusta");
        addressType A = new addressType("Main Street", "Houston", "Texas", 77401);
        dateType D = new dateType(1, 30, 1992);
        String PS = "Family";
        String PN = "713-555-4444";
        extPersonType Jacob = new extPersonType(PN, PS, A, D, PH);
        orderedLinkedList list = new orderedLinkedList();
        list.add(Jacob);
        list.searchLName("Kapusta");
    }

    /**
     * Test of printInfo method, of class addressBookType.
     */
    @Test
    public void testPrintInfo() {
        personType PH = new personType("Jacob", "Kapusta");
        addressType A = new addressType("Main Street", "Houston", "Texas", 77401);
        dateType D = new dateType(1, 30, 1992);
        String PS = "Family";
        String PN = "713-555-4444";
        extPersonType Jacob = new extPersonType(PN, PS, A, D, PH);
        orderedLinkedList list = new orderedLinkedList();
        list.add(Jacob);
        list.printInfoSpecific("Jacob", "Kapusta");
    }

    /**
     * Test of printAllOfBirthMonth method, of class addressBookType.
     */
    @Test
    public void testPrintAllOfBirthMonth() {
        personType PH = new personType("Jacob", "Kapusta");
        addressType A = new addressType("Main Street", "Houston", "Texas", 77401);
        dateType D = new dateType(1, 30, 1992);
        String PS = "Family";
        String PN = "713-555-4444";
        extPersonType Jacob = new extPersonType(PN, PS, A, D, PH);
        orderedLinkedList list = new orderedLinkedList();
        list.add(Jacob);
        list.printMonth(1);
    }

    /**
     * Test of printEnteredStatus method, of class addressBookType.
     */
    @Test
    public void testPrintEnteredStatus() {
        personType PH = new personType("Jacob", "Kapusta");
        addressType A = new addressType("Main Street", "Houston", "Texas", 77401);
        dateType D = new dateType(1, 30, 1992);
        String PS = "Family";
        String PN = "713-555-4444";
        extPersonType Jacob = new extPersonType(PN, PS, A, D, PH);
        orderedLinkedList list = new orderedLinkedList();
        list.add(Jacob);
        list.printStatus("Family");
    }

    /**
     * Test of addPerson method, of class addressBookType.
     */
    @Test
    public void testAddPerson() {
        orderedLinkedList list = new orderedLinkedList();
        personType PH = new personType("Jacob", "Kapusta");
        addressType A = new addressType("Main Street", "Houston", "Texas", 77401);
        dateType D = new dateType(1, 30, 1992);
        String PS = "Family";
        String PN = "713-555-4444";
        extPersonType Jacob = new extPersonType(PN, PS, A, D, PH);
        list.add(Jacob);
        
    }

    /**
     * Test of deletePerson method, of class addressBookType.
     */
    @Test
    public void testDeletePerson() {
        personType PH = new personType("Jacob", "Kapusta");
        addressType A = new addressType("Main Street", "Houston", "Texas", 77401);
        dateType D = new dateType(1, 30, 1992);
        String PS = "Family";
        String PN = "713-555-4444";
        extPersonType Jacob = new extPersonType(PN, PS, A, D, PH);
        orderedLinkedList list = new orderedLinkedList();
        list.add(Jacob);
        list.delete("Jacob", "Kapusta");
    }

    /**
     * Test of writeData method, of class addressBookType.
     */
    @Test
    public void testWriteData() {
        orderedLinkedList list = new orderedLinkedList();
        personType PH = new personType("Jacob", "Kapusta");
        addressType A = new addressType("Main Street", "Houston", "Texas", 77401);
        dateType D = new dateType(1, 30, 1992);
        String PS = "Family";
        String PN = "713-555-4444";
        extPersonType Jacob = new extPersonType(PN, PS, A, D, PH);
        list.add(Jacob);
        list.printContent();
    }

}