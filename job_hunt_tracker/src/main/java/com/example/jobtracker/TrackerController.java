package com.example.jobtracker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TrackerController {

	@GetMapping("/trackerdetails")
	public String greetingForm(Model model) {
		model.addAttribute("Tracker", new Tracker());
		return "application_detail";
	}

	@PostMapping("/trackersubmit")
	public String greetingSubmit(@ModelAttribute Tracker tracker, Model model) {
//    model.addAttribute("greeting", greeting);
//    return "result";
		return null;
	}

}