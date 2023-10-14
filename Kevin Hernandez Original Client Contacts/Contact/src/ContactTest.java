import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("9876543210", contact.getPhone());
        assertEquals("123 Any Street", contact.getAddress());
    }

    @Test
    public void testContactCreationWithInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "9876543210", "123 Any Street"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Doe", "9876543210", "123 Any Street"));
    }

    @Test
    public void testContactCreationWithInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", null, "Doe", "9876543210", "123 Any Street"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "JohnJohnJohn", "Doe", "9876543210", "123 Any Street"));
    }

    @Test
    public void testContactCreationWithInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", null, "9876543210", "123 Any Street"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "DoeDoeDoeDoe", "9876543210", "123 Any Street"));
    }

    @Test
    public void testContactCreationWithInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", null, "123 Any Street"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", "123456789", "123 Any Street"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", "12345678901", "123 Any Street"));
    }

    @Test
    public void testContactCreationWithInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", "9876543210", null));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", "9876543210", "This address is definitely way too long to be accepted"));
    }

    @Test
    public void testSetFirstName() {
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    public void testSetFirstNameWithInvalidInput() {
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("JohnJohnJohn"));
    }

    @Test
    public void testSetLastName() {
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testSetLastNameWithInvalidInput() {
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("DoeDoeDoeDoe"));
    }

    @Test
    public void testSetPhone() {
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        contact.setPhone("1122334455");
        assertEquals("1122334455", contact.getPhone());
    }

    @Test
    public void testSetPhoneWithInvalidInput() {
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123456789"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345678901"));
    }

    @Test
    public void testSetAddress() {
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        contact.setAddress("456 Another Street");
        assertEquals("456 Another Street", contact.getAddress());
    }

    @Test
    public void testSetAddressWithInvalidInput() {
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("This address is definitely way too long to be accepted"));
    }

    @Test
    public void testContactCreationEdgeCase() {
        Contact contact = new Contact("1234567890", "JohnJohn1", "DoeDoeDoe1", "9876543210", "123456789012345678901234567890");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("JohnJohn1", contact.getFirstName());
        assertEquals("DoeDoeDoe1", contact.getLastName());
        assertEquals("9876543210", contact.getPhone());
        assertEquals("123456789012345678901234567890", contact.getAddress());
    }

    @Test
    public void testContactCreationOverLimit() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "JohnJohn11", "DoeDoeDoe11", "98765432100", "1234567890123456789012345678901"));
    }

    @Test
    public void testSetFirstNameOverLimit() {
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("JohnJohn11"));
    }

    @Test
    public void testSetLastNameOverLimit() {
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("DoeDoeDoeD1"));
    }

    @Test
    public void testSetPhoneOverLimit() {
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345678900"));
    }

    @Test
    public void testSetAddressOverLimit() {
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("1234567890123456789012345678901"));
    }

    @Test
    public void testEqualsAndHashCode() {
        Contact contact1 = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        Contact contact2 = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        assertEquals(contact1, contact2);
        assertEquals(contact1.hashCode(), contact2.hashCode());
    }

    @Test
    public void testToString() {
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        String expected = "Contact{id='1234567890', firstName='John', lastName='Doe', phone='9876543210', address='123 Any Street'}";
        assertEquals(expected, contact.toString());
    }

    @Test
    public void testNotEquals() {
        Contact contact1 = new Contact("1234567890", "John", "Doe", "9876543210", "123 Any Street");
        Contact contact2 = new Contact("0987654321", "John", "Doe", "9876543210", "123 Any Street");
        Contact contact3 = new Contact("1234567890", "Jane", "Doe", "9876543210", "123 Any Street");
        assertNotEquals(contact1, contact2);
        assertNotEquals(contact1, contact3);
        assertNotEquals(contact1, null);
        assertNotEquals(contact1, new Object());
    }

    @Test
    public void testContactCreationWithMinimumLength() {
        Contact contact = new Contact("0", "A", "B", "0123456789", "");
        assertEquals("0", contact.getContactId());
        assertEquals("A", contact.getFirstName());
        assertEquals("B", contact.getLastName());
        assertEquals("0123456789", contact.getPhone());
        assertEquals("", contact.getAddress());
    }

    @Test
    public void testContactCreationWithMaximumLength() {
        Contact contact = new Contact(
            "1234567890",
            "ABCDEFGHIJ",
            "KLMNOPQRST",
            "0123456789",
            "123456789012345678901234567890"
        );
        assertEquals("1234567890", contact.getContactId());
        assertEquals("ABCDEFGHIJ", contact.getFirstName());
        assertEquals("KLMNOPQRST", contact.getLastName());
        assertEquals("0123456789", contact.getPhone());
        assertEquals("123456789012345678901234567890", contact.getAddress());
    }

    @Test
    public void testContactCreationWithSpecialCharactersInName() {
        Contact contact = new Contact("1234567890", "John@!", "Doe123", "9876543210", "123 Any Street");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John@!", contact.getFirstName());
        assertEquals("Doe123", contact.getLastName());
        assertEquals("9876543210", contact.getPhone());
        assertEquals("123 Any Street", contact.getAddress());
    }

    @Test
    public void testContactCreationWithNonDigitCharactersInPhone() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", "9876-543210", "123 Any Street"));
    }

    @Test
    public void testContactCreationWithEmptyAddress() {
        Contact contact = new Contact("1234567890", "John", "Doe", "9876543210", "");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("9876543210", contact.getPhone());
        assertEquals("", contact.getAddress());
    }

    @Test
    public void testContactCreationWithLongAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(
            "1234567890",
            "John",
            "Doe",
            "9876543210",
            "This address is definitely way too long to be accepted. It exceeds the maximum length allowed."
        ));
    }
}



