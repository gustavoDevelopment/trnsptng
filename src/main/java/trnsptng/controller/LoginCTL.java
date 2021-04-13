package trnsptng.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import trnsptng.DAO.GenericoDAO;
import trnsptng.model.Login;
import trnsptng.model.Rol;
import trnsptng.response.ResponseTrnsptngOperation;
import trnsptng.resquest.RequestTrnsptngLogin;

@RestController
@RequestMapping("${url.trnsptng.app-secure}")
public class LoginCTL {

	@Autowired
	GenericoDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/home/tt")
	public String startUp() {
		return "Welcome to app for transport";
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("${url.trnsptng.login-agregar}")
	public ResponseTrnsptngOperation agregarLogin(@RequestBody RequestTrnsptngLogin requestTrnsptngLogin) {
		try {			
			Login login=Login.builder().build();
			login.setPassword(passwordEncoder.encode(requestTrnsptngLogin.getPassword()));
			login.setNickName(requestTrnsptngLogin.getNickName());			
			login.setRoles(requestTrnsptngLogin.getRoles().stream().map(rol -> Rol.builder().codigo(rol.getCodigo()).nombre(rol.getNombre()).build()).collect(Collectors.toSet()));
			dao.save(login);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseTrnsptngOperation.builder().build();
	}
	
	@GetMapping("${url.trnsptng.login-consultar}")
	public Login consultarLogin(@PathVariable("nickname")String nickName) {		
		return Login.builder().build();
	}
}
