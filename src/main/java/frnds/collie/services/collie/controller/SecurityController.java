package frnds.collie.services.collie.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import frnds.collie.services.collie.services.LogInService;
import frnds.collie.services.collie.utilities.Request;

@RestController
@CrossOrigin
public class SecurityController {

	@Autowired
	private LogInService logInService;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Request request) {
		String requestType = request.getRequestType();
		Map<String, String> requestParam = request.getRequestParam();

		String id = requestParam.get("id");

		String pwd = requestParam.get("pwd");

		String jwt = logInService.logIn(id, pwd);

		return ResponseEntity.ok(jwt);

	}

	@PostMapping("/userSignUp")
	public ResponseEntity saveUserLogInDetails(@RequestBody Request request) {
		if (request != null) {
			try {
				logInService.signUp(request);
			}catch (Exception e) {
				System.out.println("Error:"+e);
			}
		}
		return null;}
}
