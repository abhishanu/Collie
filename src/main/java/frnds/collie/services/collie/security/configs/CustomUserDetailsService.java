package frnds.collie.services.collie.security.configs;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import frnds.collie.services.collie.dao.Login;
import frnds.collie.services.collie.dao.UserDetailsImpl;
import frnds.collie.services.collie.repo.LogInRepositry;
import frnds.collie.services.collie.repo.UserDetailsRepositry;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	LogInRepositry logInRepositry;

	@Autowired
	UserDetailsRepositry userDetailsRepositry;

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		Login login = logInRepositry.findByUserId(usernameOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException("User Name not found"));

		UserDetailsImpl user = userDetailsRepositry.findByUserName(usernameOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException("User Name not found"));

		return UserPrincipal.create(login, user);
	}

	// This method is used by JWTAuthenticationFilter
	@Transactional
	public UserDetails loadUserById(String id) {
		Login login = logInRepositry.findByUserId(id)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with id : " + id));

		UserDetailsImpl user = userDetailsRepositry.findByUserName(login.getUserId())
				.orElseThrow(() -> new UsernameNotFoundException("User Name not found"));

		return UserPrincipal.create(login, user);
	}

}
