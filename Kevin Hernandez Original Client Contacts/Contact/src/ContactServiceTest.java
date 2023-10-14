import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        service.addContact(contact);
        assertEquals(contact, service.getContact("1234567890"));
    }

    @Test
    public void testAddDuplicateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        service.addContact(contact);
        service.deleteContact("1234567890");
        assertNull(service.getContact("1234567890"));
    }

    @Test
    public void testDeleteNonexistentContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("1234567890"));
    }

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

    @Test
    public void testUpdateNonexistentContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.updateContact("1234567890", "Jane", "Smith", "1122334455", "456 Another Street"));
    }

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

    @Test
    public void testGetAllContactsWhenEmpty() {
        ContactService service = new ContactService();
        List<Contact> contacts = service.getAllContacts();
        assertEquals(0, contacts.size());
    }

    @Test
    public void testGetContactWithInvalidId() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.getContact(null));
        assertThrows(IllegalArgumentException.class, () -> service.getContact(""));
    }

    @Test
    public void testGetContactWithNonexistentId() {
        ContactService service = new ContactService();
        assertNull(service.getContact("1234567890"));
    }
}
