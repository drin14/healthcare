package io.javabrains.springsecurityjpa;

import io.javabrains.springsecurityjpa.models.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Controller
public class HomeResource {

    @Autowired
    MyUserDetailsService userDetailsService;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }


    @GetMapping("/doctor")
    public String doctor() {
        return "doctor";
    }

    @RequestMapping("/patient")
    public String patient(Model model) {


        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
             username = principal.toString();
        }

        UserDetails currentUser;

        currentUser = userDetailsService.loadUserByUsername(username);
        model.addAttribute("currentUser", currentUser);

        Appointment appointment = new Appointment();

        model.addAttribute("appointment",appointment);
        /*
        String uri = "http://localhost:8080/patient";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(uri,currentUser,String.class);
        */

        return "patient";
    }



    @GetMapping("/admin")
    public String admin() {

        String uri = "http://localhost:8080/";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        return result;

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAppointment(@ModelAttribute("doctor") Appointment appointment) {
        appointmentService.save(appointment);

        return "appointmentCreated";
    }

    //@ResponseBody
    @RequestMapping("/appointment")
    public String getAppointments(Model model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String doctorName  = ((UserDetails)principal).getUsername();



        List<Appointment> listAppointments = appointmentService.getAppointments(doctorName);

        model.addAttribute("listAppointments", listAppointments);

        return "doctorsAppointments";
    }


}

