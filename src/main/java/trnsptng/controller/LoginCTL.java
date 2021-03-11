package trnsptng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import trnsptng.DAO.GenericoDAO;
import trnsptng.model.Login;
import trnsptng.response.ResponseTrnsptngOperation;

@RestController
public class LoginCTL {

	@Autowired
	GenericoDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@PostMapping("${url.trnsptng.login-agregar}")
	public ResponseTrnsptngOperation agregarLogin(Login login) {
		try {
			login.setPassword(passwordEncoder.encode(login.getPassword()));
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
