package trnsptng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import trnsptng.DAO.GenericoDAO;
import trnsptng.model.Login;

public class LoginDetailService implements UserDetailsService{

	@Autowired
	GenericoDAO dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Login login =dao.getByNickName(username);
		if(login!=null) {
			return LoginDetail.builder().login(login).build();
		}else {
			throw new UsernameNotFoundException("El usuario no existe: "+username);	
		}
	}
}
