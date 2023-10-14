package Appointment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class AppointmentTest {
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidIdLength() {
        new Appointment("12345678901", new Date(), "Valid description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullId() {
        new Appointment(null, new Date(), "Valid description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullDate() {
        new Appointment("validId", null, "Valid description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDateInPast() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        new Appointment("validId", calendar.getTime(), "Valid description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullDescription1() {
        new Appointment("validId", new Date(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLongDescription() {
        new Appointment("validId", new Date(), "This is a very long description that exceeds the maximum length of fifty characters");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidIdLength1() {
        new Appointment("longerThanTenCharacters", new Date(), "Valid description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullId1() {
       new Appointment(null, new Date(), "Valid description");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testPastDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);  // Set date to yesterday
        new Appointment("validId", calendar.getTime(), "Valid description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullDate1() {
        new Appointment("validId", null, "Valid description");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDescriptionLength() {
        new Appointment("validId", new Date(), "This description is definitely longer than fifty characters.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullDescription() {
        new Appointment("validId", new Date(), null);
    }
    @Test
    public void testValidAppointment() {
        Appointment appointment = new Appointment("validId", new Date(), "Valid description");
        assertNotNull(appointment);
    }

    @Test
    public void testGetters() {
        Date date = new Date();
        Appointment appointment = new Appointment("validId", date, "Valid description");
        assertEquals("validId", appointment.getAppointmentId());
        assertEquals(date, appointment.getAppointmentDate());
        assertEquals("Valid description", appointment.getDescription());
    }

    @Test
    public void testEqualsAndHashCode() {
        Appointment appointment1 = new Appointment("validId", new Date(), "Valid description");
        Appointment appointment2 = new Appointment("validId", new Date(), "Valid description");
        assertEquals(appointment1, appointment2);
        assertEquals(appointment1.hashCode(), appointment2.hashCode());
    }

    @Test
    public void testNotEquals() {
        Appointment appointment1 = new Appointment("validId", new Date(), "Valid description");
        Appointment appointment2 = new Appointment("invalidId", new Date(), "Valid description");
        Appointment appointment3 = new Appointment("validId", new Date(), "Different description");

        assertTrue(!appointment1.equals(appointment2));
        assertTrue(!appointment1.equals(appointment3));
        assertTrue(!appointment1.equals(null));
        assertTrue(!appointment1.equals(new Object()));
    }

    @Test
    public void testAppointmentCreationWithMidnightTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.getTime();
    }
        

    @Test
    public void testAppointmentCreationWithNonMidnightTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.getTime();

       
    }

    @Test
    public void testSetAppointmentId() {
        Appointment appointment = new Appointment("validId", new Date(), "Valid description");
        appointment.setAppointmentId("newId");
        assertEquals("newId", appointment.getAppointmentId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNullAppointmentId() {
        Appointment appointment = new Appointment("validId", new Date(), "Valid description");
        appointment.setAppointmentId(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidAppointmentIdLength() {
        Appointment appointment = new Appointment("validId", new Date(), "Valid description");
        appointment.setAppointmentId("12345678901");
    }

    @Test
    public void testUpdateAppointmentDate() {
        Appointment appointment = new Appointment("validId", new Date(), "Valid description");
        Date newDate = new Date();
        appointment.setAppointmentDate(newDate);

        assertEquals(newDate, appointment.getAppointmentDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateAppointmentDateToNull() {
        Appointment appointment = new Appointment("validId", new Date(), "Valid description");
        appointment.setAppointmentDate(null);
    }

    @Test
    public void testUpdateAppointmentDescription() {
        Appointment appointment = new Appointment("validId", new Date(), "Valid description");
        appointment.setDescription("New description");

        assertEquals("New description", appointment.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateAppointmentDescriptionToNull() {
        Appointment appointment = new Appointment("validId", new Date(), "Valid description");
        appointment.setDescription(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateAppointmentDescriptionToLongDescription() {
        Appointment appointment = new Appointment("validId", new Date(), "Valid description");
        appointment.setDescription("This is a very long description that exceeds the maximum length of fifty characters");
    }
}
