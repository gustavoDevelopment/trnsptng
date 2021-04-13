package trnsptng.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure/home/")
public class HomeCTL {
	
	@GetMapping("/process")
	public String process() {
		return "Procesando ..........."; 
	}

}
