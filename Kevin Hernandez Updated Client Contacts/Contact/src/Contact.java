/**
 * File: Contact.java
 * Author: [Kevin Hernandez]
 * Date: [9/25/23]
 * Version: 1.0
 * Description: This class is structured to model a contact entity, encapsulating properties such as a unique identifier, first name, last name, phone number, and address of an individual contact.
 **/


public class Contact {
    // Unique identifier for the contact
    private final String contactId;
    // First name of the contact
    private String firstName;
    // Last name of the contact
    private String lastName;
    // Phone number of the contact
    private String phone;
    // Address of the contact
    private String address;
    
    /**
     * Constructor to initialize a Contact object.
     *
     * @param contactId  Unique identifier for the contact.
     * @param firstName  First name of the contact.
     * @param lastName   Last name of the contact.
     * @param phone      Phone number of the contact.
     * @param address    Address of the contact.
     * @throws IllegalArgumentException if any of the parameters do not meet the specified conditions.
     */

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID must be not null and length must be no longer than 10 characters");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First Name must not be null and length must be no longer than 10 characters");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last Name must not be null and length must be no longer than 10 characters");
        }
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone number must not be null and must be exactly 10 digits");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must not be null and length must be no longer than 30 characters");
        }
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }
    
 // Getter method for contactID
    
    public String getContactId() {
        return contactId;
    }
    
    /**
     * Setter method for firstName.
     *
     * @param firstName  New first name to be set.
     * @throws IllegalArgumentException if firstName is null or its length is greater than 10 characters.
     */
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First Name must not be null and length must be no longer than 10 characters");
        }
        this.firstName = firstName;
    }
    
 // Getter method for lastName
    
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Setter method for lastName.
     *
     * @param lastName  New last name to be set.
     * @throws IllegalArgumentException if lastName is null or its length is greater than 10 characters.
     */
    
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last Name must not be null and length must be no longer than 10 characters");
        }
        this.lastName = lastName;
    }
    
 // Getter method for phone

    public String getPhone() {
        return phone;
    }
    
    /**
     * Setter method for phone.
     *
     * @param phone  New phone number to be set.
     * @throws IllegalArgumentException if phone is null or its length is not exactly 10 digits.
     */

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone number must not be null and must be exactly 10 digits");
        }
        this.phone = phone;
    }
    
 // Getter method for address
    
    public String getAddress() {
        return address;
    }
    
    /**
     * Setter method for address.
     *
     * @param address  New address to be set.
     * @throws IllegalArgumentException if address is null or its length is greater than 30 characters.
     */

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must not be null and length must be no longer than 30 characters");
        }
        this.address = address;
    }

}
