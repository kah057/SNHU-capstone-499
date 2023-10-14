/**
 * File: ContactService.java
 * Author: [Kevin Hernandez]
 * Date: [9/25/23]
 * Version: 1.0
 * Description: This class acts as a service layer for managing contact entities, providing functionalities such as adding, deleting, updating, and retrieving contacts. It uses a Map to store Contact objects, ensuring quick access using unique contact IDs.
 **/


import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ContactService {
	
	// A map to store contacts using their ID as the key.
	
    private Map<String, Contact> contacts;

    // Constructor initializes the contacts map.
    
    public ContactService() {
        this.contacts = new HashMap<>();
    }
    
    /**
     * Adds a new contact to the service.
     *
     * @param contact The contact to be added.
     * @throws IllegalArgumentException if a contact with the same ID already exists.
     */

    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID must be unique");
        }
        contacts.put(contact.getContactId(), contact);
    }
    
    /**
     * Deletes a contact from the service using its ID.
     *
     * @param contactId The ID of the contact to be deleted.
     */

    public void deleteContact(String contactId) {
        contacts.remove(contactId);
    }
    
    /**
     * Updates the details of an existing contact.
     *
     * @param contactId  The ID of the contact to be updated.
     * @param firstName  New first name for the contact.
     * @param lastName   New last name for the contact.
     * @param phone      New phone number for the contact.
     * @param address    New address for the contact.
     * @throws IllegalArgumentException if no contact with the given ID exists.
     */

    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
    }
    
    /**
     * Retrieves a contact by its ID.
     *
     * @param contactId The ID of the contact to be retrieved.
     * @return The contact with the given ID, or null if no such contact exists.
     */

	public Contact getContact(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
     * Retrieves all contacts stored in the service.
     *
     * @return A list of all contacts.
     */

	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		return null;
	}
}