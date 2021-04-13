package trnsptng.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	Environment env;
	
	@Autowired
	private UserDetailsService loginDetail;
	
	@Value("${url.trnsptng.app-home}")
	private String urlPatternsAuthorizeBeforeAutenticate;
	
	@Value("${url.trnsptng.app-secure}")
	private String urlPatternsAutenticate;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("LLamado al metodo configure... HttpSecurity for path "+urlPatternsAutenticate+ " - "+urlPatternsAuthorizeBeforeAutenticate);		
		http.csrf().disable();
		
		http
        .authorizeRequests()
            .antMatchers("/secure/**").permitAll()
            .and()
        .authorizeRequests()
            .antMatchers("/home/**").hasAnyRole("ADMIN")
            .anyRequest().authenticated()
            .and()
         .logout().logoutUrl("/logout").invalidateHttpSession(true)
         .and()
        .formLogin()
            .permitAll();
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		log.info("LLamado al metodo configure... AuthenticationManagerBuilder");
		auth.userDetailsService(loginDetail).passwordEncoder(encoderPassword());
	}
	
	@Bean
	public BCryptPasswordEncoder encoderPassword() {
		return new BCryptPasswordEncoder();
	}
}
