/**
 * File: Appointment.java
 * Author: [Kevin Hernandez]
 * Date: [9/25/23]
 * Version: 1.0
 * Description: This class is designed to model an appointment entity, encapsulating properties such as a unique identifier, the date and time of the appointment, and a description or purpose of the appointment.
 */

package Appointment;

import java.util.Date;

public class Appointment {
    // Unique identifier for the appointment
    private final String appointmentId;
    
    // Date and time of the appointment
    private final Date appointmentDate;
    
    // Description or purpose of the appointment
    private final String description;

    /**
     * Constructor to create a new appointment.
     * 
     * @param appointmentId   Unique identifier for the appointment.
     * @param appointmentDate Date and time of the appointment.
     * @param description     Description or purpose of the appointment.
     */
    
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        // Validate the appointment ID
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        
        // Validate the appointment date (should not be in the past)
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        
        // Validate the description of the appointment
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

 // Getter method for appointment ID
    public String getAppointmentId() {
        return appointmentId;
    }

 // Getter method for appointment date
    public Date getAppointmentDate() {
        return appointmentDate;
    }

 // Getter method for appointment description
    public String getDescription() {
        return description;
    }

    /**
     * Setter method to update the description of the appointment.
     * 
     * @param string New description for the appointment.
     */
    
    public void setDescription(String string) {
        //nImplement the method to update the description
    }

    /**
     * Setter method to update the date of the appointment.
     * 
     * @param newDate New date for the appointment.
     */
    public void setAppointmentDate(Date newDate) {
        // Implement the method to update the appointment date
    }

    /**
     * Setter method to update the ID of the appointment.
     * 
     * @param string New ID for the appointment.
     */
    public void setAppointmentId(String string) {
        // Implement the method to update the appointment ID
    }
}