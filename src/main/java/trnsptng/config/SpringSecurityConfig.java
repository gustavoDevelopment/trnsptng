package trnsptng.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	Environment env;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("LLamado al metodo configure... HttpSecurity for path "+env.getProperty("url.trnsptng.app-home"));		
		http.csrf().disable().authorizeRequests().antMatchers(env.getProperty("url.trnsptng.app-home")).fullyAuthenticated().and().httpBasic();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		log.info("LLamado al metodo configure... AuthenticationManagerBuilder");
		auth.inMemoryAuthentication().withUser("shark").password("124").roles("USER");
	}
	
	@Bean
	public BCryptPasswordEncoder endoderPassword() {
		return new BCryptPasswordEncoder();
	}
}
