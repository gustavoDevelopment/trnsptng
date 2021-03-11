package trnsptng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import trnsptng.DAO.GenericoDAO;
import trnsptng.model.Rol;
import trnsptng.response.ResponseTrnsptngOperation;

@RestController
public class RolCTL {


	@Autowired
	GenericoDAO dao;

	@PostMapping("${url.trnsptng.rol-agregar}")
	public ResponseTrnsptngOperation agregarRol(Rol rol) {
		try {
			dao.save(rol);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseTrnsptngOperation.builder().build();
	}
	
	@GetMapping("${url.trnsptng.rol-consultar}")
	public Rol consultarRol(@PathVariable("nombre")String nombre) {		
		return Rol.builder().build();
	}
}
