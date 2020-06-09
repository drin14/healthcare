package labcourse.healthcare;

;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private DoctorService service;

    // handler methods...

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Doctor> listDoctors= service.listAll();
        model.addAttribute("listDoctors", listDoctors);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewDoctorPage(Model model) {
        Doctor doctor = new Doctor();
        model.addAttribute("doctor", doctor);

        return "new_doctor";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveDoctor(@ModelAttribute("doctor") Doctor doctor) {
        service.save(doctor);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditDoctorPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_doctor");
        Doctor doctor = service.get(id);
        mav.addObject("doctor", doctor);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/doctors")
    public String showDoctorsSpecializations() {


        return "doctorsSpecializations";
    }





    //@ResponseBody
    @RequestMapping("/orthopedics")
    public String getOrthopedics(Model model) {

        List<Doctor> listOrthopedics = service.getOrthopedicsData();

        model.addAttribute("listOrthopedics", listOrthopedics);

        return "orthopedics";
    }

    @RequestMapping(value = "/patient", method = RequestMethod.GET)
    @ResponseBody
    public String showPatientPage(Principal principal) {

        return principal.getName();
       // return "patient";
    }



}