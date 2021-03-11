package trnsptng.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AppCTL {	
	@GetMapping("/")	
	public String startUp() {
		log.info("Llamado al metodo startUp");
		return "Welcome to app for transport";
	}
}
