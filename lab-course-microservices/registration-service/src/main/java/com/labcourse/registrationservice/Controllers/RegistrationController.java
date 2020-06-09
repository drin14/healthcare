package com.labcourse.registrationservice.Controllers;

import com.labcourse.registrationservice.Model.User;
import com.labcourse.registrationservice.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class RegistrationController {

    @Autowired
    private UserService service;

    @RequestMapping("/new")
    public String showNewUserPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "new_user";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {



        service.save(user);




        return "user_registered";
    }

}
