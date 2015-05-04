package com.issac.isoc;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}
    @RequestMapping(value = "/hibernate", method = RequestMethod.GET)
    public String configureHibernate(ModelMap model){
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        model.addAttribute("message", "Hibernate Configured");
        return "hello";
    }
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public String authenticate(ModelMap model){
        String response = null;

        return response;
    }
}