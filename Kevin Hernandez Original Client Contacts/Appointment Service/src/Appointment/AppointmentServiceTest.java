package Appointment;
import org.junit.*;

import java.util.*;

public class AppointmentServiceTest {
    AppointmentService service;

    @Before
    public void setup() {
        service = new AppointmentService();
    }

    @Test
    public void testAddAppointment() {
        Appointment appointment = new Appointment("validId", new Date(), "Valid description");
        service.addAppointment(appointment);
        Assert.assertEquals(appointment, service.getAppointment("validId"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateAppointment() {
        Appointment appointment1 = new Appointment("validId", new Date(), "Valid description");
        Appointment appointment2 = new Appointment("validId", new Date(), "Different description");
        service.addAppointment(appointment1);
        service.addAppointment(appointment2);
    }

    @Test
    public void testDeleteAppointment() {
        Appointment appointment = new Appointment("validId", new Date(), "Valid description");
        service.addAppointment(appointment);
        service.deleteAppointment("validId");
        Assert.assertNull(service.getAppointment("validId"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNonexistentAppointment() {
        service.deleteAppointment("nonexistentId");
    }
}
