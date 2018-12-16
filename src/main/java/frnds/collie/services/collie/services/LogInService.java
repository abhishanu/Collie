package frnds.collie.services.collie.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import frnds.collie.services.collie.dao.Login;
import frnds.collie.services.collie.dao.Role;
import frnds.collie.services.collie.enums.RoleName;
import frnds.collie.services.collie.exception.AppException;
import frnds.collie.services.collie.repo.LogInRepositry;
import frnds.collie.services.collie.repo.RoleRepository;
import frnds.collie.services.collie.security.configs.JwtTokenProvider;
import frnds.collie.services.collie.utilities.Request;

@Service
public class LogInService {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenProvider tokenProvider;
	
	@Autowired
	LogInRepositry logInRepositry;

	@Autowired
	RoleRepository roleRepository;

	public String logIn(String id, String pwd) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(id, pwd));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		return tokenProvider.generateToken(authentication);
	}

	public void signUp(@Valid Request signUpRequest) {
		Login login = new Login();
		Map<String, String> requestParam = signUpRequest.getRequestParam();

		if (signUpRequest.getRequestType().equalsIgnoreCase("signUp")) {
			if (requestParam.size() != 0) {
				String email = requestParam.get("id");
				String pwd = requestParam.get("pwd");
				String logInType = requestParam.get("logInType");
				String roleId = requestParam.get("roleId");

				// Validate the request
				if (email == null || email.equals("")) {
				}

				login.setIsActive("1");

				// Validating Email
				// boolean isValidEmail = EmailValidator.validateEmail(email);
				// if (!isValidEmail) {
				// }

				login.setLoginTypeId(logInType);
				login.setPass(pwd);
				login.setUserId(email);
				Role userRole = null;
				
				if (roleId != null) {
					userRole = roleRepository.findByRoleId(Integer.parseInt(roleId))
							.orElseThrow(() -> new AppException("User Role not set."));
				} else {
					// default userRole id User
					userRole = roleRepository.findByName(RoleName.ROLE_USER)
							.orElseThrow(() -> new AppException("User Role not set."));
				}
				
				login.setRoles(Collections.singleton(userRole));
				String details = saveLogInDetails(login);

				if (details.equalsIgnoreCase("-1")) {

				}
				if (details.equalsIgnoreCase("0")) {
				
				}
				
				if (details.equalsIgnoreCase("1")) {
					Map<String, String> map = new HashMap<>();

					map.put("fName", requestParam.get("fName"));
					map.put("lName", requestParam.get("lName"));
					map.put("gender", requestParam.get("gender"));
					map.put("roleId", requestParam.get("roleId"));
					map.put("email", requestParam.get("email"));

				}
			}
		} else {

		}

	}

	public String saveLogInDetails(Login login) {
		String base64Pass = passwordEncoder.encode(login.getPass());
		login.setPass(base64Pass);
		if (!logInRepositry.exists(login.getUserId())) {
			//String passwordHistory = maintainPasswordHistory(base64Pass, login).toString();
			//login.setPasswordHistory(passwordHistory);
			Login save = logInRepositry.save(login);
			if (save != null) {
				return "1";
			} else {
			//	logger.info("Unable to save the record");
				return "-1";
			}
		}
		return "0";
	}
}
