package io.javabrains.springsecurityjpa;

import io.javabrains.springsecurityjpa.models.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;



    List<Appointment> appointments;
    public List<Appointment> getAppointments(String doctorName) {
        appointments = appointmentRepository.getAppointments(doctorName);
        return appointments;
    }



    public void save(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public Appointment get(long id) {
        return appointmentRepository.findById(id).get();
    }

    public void delete(long id) {
        appointmentRepository.deleteById(id);
    }
}
