/**
 * File: AppointmentServiceTest.java
 * Author: [Kevin Hernandez]
 * Date: [9/25/23]
 * Version: 1.0
 * Description: This class is dedicated to unit testing the "AppointmentService" class, ensuring that the appointment management logic is functioning as expected. 
 * It uses the JUnit testing framework for writing and running tests.
 **/

package Appointment;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	
	// Map to store appointments with their IDs as keys
    private final Map<String, Appointment> appointments;

    /**
     * Constructor to initialize the AppointmentService.
     * Initializes the appointments map.
     */
    public AppointmentService() {
        appointments = new HashMap<>();
    }

    /**
     * Adds a new appointment to the map.
     * 
     * @param appointment The appointment object to be added.
     * @throws IllegalArgumentException if an appointment with the same ID already exists.
     */
    
    public void addAppointment(Appointment appointment) {
        String appointmentId = appointment.getAppointmentId();
        if (appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment with the same ID already exists");
        }
        appointments.put(appointmentId, appointment);
    }
    
    /**
     * Deletes an appointment from the map using its ID.
     * 
     * @param appointmentId The ID of the appointment to be deleted.
     * @throws IllegalArgumentException if the appointment with the given ID is not found.
     */
    
    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment not found");
        }
        appointments.remove(appointmentId);
    }
    
    /**
     * Retrieves an appointment from the map using its ID.
     * 
     * @param appointmentId The ID of the appointment to be retrieved.
     * @return The appointment object if found, otherwise null.
     */

    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }

	
}
