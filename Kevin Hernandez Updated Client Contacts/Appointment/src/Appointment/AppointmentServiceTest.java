/**
 * File: AppointmentServiceTest.java
 * Author: [Kevin Hernandez]
 * Date: [9/25/23]
 * Version: 1.0
 * Description: This class is dedicated to unit testing the "AppointmentService" class, ensuring that the appointment management logic is functioning as expected. It uses the JUnit testing framework for writing and running tests.
 **/


package Appointment;
import org.junit.*;
import java.util.*;

public class AppointmentServiceTest {
	
	// Instance of the service to be tested
    AppointmentService service;

    /**
     * Setup method to initialize the service before each test.
     */
    
    @Before
    public void setup() {
        service = new AppointmentService();
    }

    /**
     * Test to ensure that an appointment can be added successfully.
     */
    
    @Test
    public void testAddAppointment() {
        Appointment appointment = new Appointment("validId", new Date(), "Valid description");
        service.addAppointment(appointment);
        Assert.assertEquals(appointment, service.getAppointment("validId"));
    }
    
    /**
     * Test to ensure that adding a duplicate appointment throws an exception.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateAppointment() {
        Appointment appointment1 = new Appointment("validId", new Date(), "Valid description");
        Appointment appointment2 = new Appointment("validId", new Date(), "Different description");
        service.addAppointment(appointment1);
        service.addAppointment(appointment2);
    }

    /**
     * Test to ensure that an appointment can be deleted successfully.
     */
    
    @Test
    public void testDeleteAppointment() {
        Appointment appointment = new Appointment("validId", new Date(), "Valid description");
        service.addAppointment(appointment);
        service.deleteAppointment("validId");
        Assert.assertNull(service.getAppointment("validId"));
    }

    /**
     * Test to ensure that deleting a nonexistent appointment throws an exception.
     */
    
    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNonexistentAppointment() {
        service.deleteAppointment("nonexistentId");
    }
}
