package br.com.professorisidro.authapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.professorisidro.authapi.model.User;
import br.com.professorisidro.authapi.security.MyToken;
import br.com.professorisidro.authapi.service.IUserService;

@RestController
public class UserController {
	
	private IUserService service;
	
	
	public UserController(IUserService service) {
		super();
		this.service = service;
	}


	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody User user){
		return ResponseEntity.status(201).body(service.addUser(user));
	}
	
	@PostMapping("/login")
	public ResponseEntity<MyToken> loging(@RequestBody User user){
		return ResponseEntity.ok(service.userLogin(user));
	}

}
