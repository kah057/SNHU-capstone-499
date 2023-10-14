/**
 * File: ContactServiceTest.java
 * Author: [Kevin Hernandez]
 * Date: [9/25/23]
 * Version: 1.0
 * Description: This class is dedicated to unit testing the "ContactService" class, ensuring that each of its methods functions correctly. 
 * It uses the JUnit 5 framework, as indicated by the imports and annotations, to conduct various test cases.
 **/




import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ContactServiceTest {

	// Test adding a contact and then retrieving it.
    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        service.addContact(contact);
        assertEquals(contact, service.getContact("1234567890"));
    }

 // Test adding a contact and then trying to add the same contact again.
    @Test
    public void testAddDuplicateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }
// Test adding and then deleting a contact.
    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        service.addContact(contact);
        service.deleteContact("1234567890");
        assertNull(service.getContact("1234567890"));
    }

 // Test trying to delete a contact that doesn't exist.
    @Test
    public void testDeleteNonexistentContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("1234567890"));
    }

 // Test updating the details of an existing contact.
    @Test
    public void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        service.addContact(contact);
        service.updateContact("1234567890", "Jane", "Smith", "1122334455", "456 Another Street");
        Contact updatedContact = service.getContact("1234567890");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("1122334455", updatedContact.getPhone());
        assertEquals("456 Another Street", updatedContact.getAddress());
    }

 // Test trying to update a contact that doesn't exist.
    @Test
    public void testUpdateNonexistentContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.updateContact("1234567890", "Jane", "Smith", "1122334455", "456 Another Street"));
    }
    
 // Test retrieving all contacts from the service.
    @Test
    public void testGetAllContacts() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        Contact contact2 = new Contact("0987654321", "Jane", "Smith", "1122334455", "456 Another Street");
        service.addContact(contact1);
        service.addContact(contact2);
        List<Contact> contacts = service.getAllContacts();
        assertEquals(2, contacts.size());
        assertTrue(contacts.contains(contact1));
        assertTrue(contacts.contains(contact2));
    }
    
 // Test retrieving all contacts when the service is empty.
    @Test
    public void testGetAllContactsWhenEmpty() {
        ContactService service = new ContactService();
        List<Contact> contacts = service.getAllContacts();
        assertEquals(0, contacts.size());
    }

 // Test trying to retrieve a contact with an invalid ID.
    @Test
    public void testGetContactWithInvalidId() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.getContact(null));
        assertThrows(IllegalArgumentException.class, () -> service.getContact(""));
    }

 // Test trying to retrieve a contact that doesn't exist.  
    @Test
    public void testGetContactWithNonexistentId() {
        ContactService service = new ContactService();
        assertNull(service.getContact("1234567890"));
    }
}
