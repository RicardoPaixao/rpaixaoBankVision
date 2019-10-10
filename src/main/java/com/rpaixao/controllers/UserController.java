package com.rpaixao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpaixao.models.User;
import com.rpaixao.services.UserService;

@RestController
@RequestMapping(path = "/Import")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping(value = "/reqres")
	public ResponseEntity<?> save() {
		List<User> userList = userService.importReqRes();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
}
