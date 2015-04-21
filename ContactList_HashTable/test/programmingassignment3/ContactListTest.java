/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package programmingassignment3;

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
public class ContactListTest {

    public ContactListTest() {
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
    @Test
    public void testUCaddOrChangeEntry() {
        Contact contact = new Contact("Jacob", "Kapusta", "721-555-5555", "281-444-3333");
        System.out.println("UCaddOrChangeEntry");
        LinkedList[] table = new LinkedList[1];
        for(int i = 0; i<1; i++) table[i] = new LinkedList();
        table[0].UCadd(contact);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    @Test
    public void testUClookUpEntry() {
        Contact contact = new Contact("Jacob", "Kapusta", "721-555-5555", "281-444-3333");
        System.out.println("UClookUpEntry");
        ContactList instance = new ContactList();
        LinkedList[] list = new LinkedList[1];
        list[0] = new LinkedList();
        list[0].UCadd(contact);
        list[0].UCsearch(contact.getFirstName(), contact.getLastName());
    }
    @Test
    public void testUCremoveEntry() {
        System.out.println("UCremoveEntry");
        ContactList instance = new ContactList();
        Contact contact = new Contact("Jacob", "Kapusta", "721-555-5555", "281-444-3333");
        LinkedList[] list = new LinkedList[1];
        list[0] = new LinkedList();
        list[0].UCadd(contact);
        list[0].UCdelete(contact.getFirstName(), contact.getLastName());
    }
    @Test
    public void testUCdisplay() {
        System.out.println("UCdisplay");
        ContactList instance = new ContactList();
        instance.UCloadData();
        instance.UCdisplay();
    }
}