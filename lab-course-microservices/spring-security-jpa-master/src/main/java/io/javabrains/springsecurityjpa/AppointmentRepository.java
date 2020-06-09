package io.javabrains.springsecurityjpa;

import io.javabrains.springsecurityjpa.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {



    @Query("select a from Appointment a where a.doctorName = :doctorName")
    List<Appointment> getAppointments(@Param("doctorName")String doctorName);
}
