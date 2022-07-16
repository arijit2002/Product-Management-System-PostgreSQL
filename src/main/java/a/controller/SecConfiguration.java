package a.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecConfiguration extends WebSecurityConfigurerAdapter {
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().
			 passwordEncoder(passwordEncoder).withUser("arijit")
			.password(passwordEncoder.encode("@r1j1t")).roles("user")
			.and()
			.passwordEncoder(passwordEncoder).withUser("admin")
			.password(passwordEncoder.encode("root")).roles("admin");
	}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http
			.authorizeRequests()
			.antMatchers("/","/acccessdenied","/login").permitAll()
			.antMatchers("/user").hasAnyRole("user","admin")
			.antMatchers("/admin").hasRole("admin")
			.antMatchers("/testing").hasAnyRole("user","admin")
			.anyRequest().authenticated()
			.and()
			.formLogin();
	}
}
