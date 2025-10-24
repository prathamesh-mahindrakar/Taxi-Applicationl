package com.taxi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.taxi.model.BookingForm;
import com.taxi.model.ContactForm;
import com.taxi.model.ServiceForm;
import com.taxi.services.BookingFormService;
import com.taxi.services.ContactFormService;
import com.taxi.services.ServiceFormService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class MyController {

	private ContactFormService contactFormService;
	
	private BookingFormService bookingFormService;
	
	private ServiceFormService serviceFormService;
	
	
	@Autowired
	public void setServiceFormService(ServiceFormService serviceFormService) {
		this.serviceFormService = serviceFormService;
	}

	@Autowired
	public void setBookingFormService(BookingFormService bookingFormService) {
		this.bookingFormService = bookingFormService;
	}

	@Autowired
	public void setContactFormService(ContactFormService contactFormService) {
		this.contactFormService = contactFormService;
	}

	@GetMapping(path = { "/", "home", "welcome", "index" })
	public String welcomeview(HttpServletRequest request, Model model) {
		String requestURI = request.getRequestURI();
		model.addAttribute("mycurrentpage", requestURI);
		model.addAttribute("bookingForm", new BookingForm());
		return "index";
	}

	@GetMapping("about")
	public String aboutUs(HttpServletRequest request, Model model) {
		String requestURI = request.getRequestURI();
		model.addAttribute("mycurrentpage", requestURI);
		return "about"; // maps to about.html
	}

	@GetMapping("cars")
	public String cars(HttpServletRequest request, Model model) {
		String requestURI = request.getRequestURI();
		model.addAttribute("mycurrentpage", requestURI);
		return "cars"; // maps to cars.html
	}

	@GetMapping("contact")
	public String contactUs(HttpServletRequest request, Model model) {
		String requestURI = request.getRequestURI();
		model.addAttribute("mycurrentpage", requestURI);
		model.addAttribute("contactForm", new ContactForm());
		return "contacts"; // maps to contacts.html
	}

	@GetMapping("services")
	public String service(HttpServletRequest request, Model model) {
		String requestURI = request.getRequestURI();
		model.addAttribute("mycurrentpage", requestURI);
		
		//Data Collect
		List<ServiceForm> allServices = serviceFormService.reallAllServices();
		model.addAttribute("allservices", allServices);
		return "services"; // maps to services.html
	}

	@PostMapping("contactform")
	public String contactForm(@Valid @ModelAttribute ContactForm contactForm, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("bindingResult", bindingResult);
			return "contacts";
		}

		ContactForm saveContactForm = contactFormService.saveContactFormService(contactForm);

		if (saveContactForm != null) {
			redirectAttributes.addFlashAttribute("message", "Message Send Successfully");
		} else {
			redirectAttributes.addFlashAttribute("message", "Something Went Wrong");

		}

		return "redirect:/contact";
	}

	@PostMapping("bookingform")
	public String bookingForm(
	    @Valid @ModelAttribute BookingForm bookingForm, 
	    BindingResult bindingResult,  // immediately after @Valid param
	    Model model,
	    RedirectAttributes redirectAttributes
	) {

	    if (bindingResult.hasErrors()) {
	        return "index"; // return form if validation fails
	    }
	    
	    // Save to DB if needed
	    
	    BookingForm saveBookingFormService = bookingFormService.saveBookingFormService(bookingForm);
	    
	    if(saveBookingFormService != null) {
		    redirectAttributes.addFlashAttribute("message", "Booking submitted successfully!");
	    } else {
		    redirectAttributes.addFlashAttribute("message", "Something Went Wrong");

		}
	    
	    return "redirect:/";
	}
	
	@GetMapping("/login")
	public String adminLoginView() {
		return "adminlogin";
		
	}


}
