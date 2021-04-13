package trnsptng.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure/auth")
public class AuthCTL {
	
	@GetMapping("/Authenticante")
	public String Authenticante() {
		return "Authenticante ..........."; 
	}


}
