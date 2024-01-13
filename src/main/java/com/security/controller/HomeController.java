package com.security.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.entity.UserInfo;
import com.security.service.userService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private userService userService;

	
	@GetMapping("/normal")
	public ResponseEntity<String> normalUser() {
		return ResponseEntity.ok( "Hello, I am Normal user");
	}
	
	@GetMapping("/public")
	public ResponseEntity<String> publicUser() {
		return ResponseEntity.ok( "Hello, I am Public user");
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> adminUser() {
		return ResponseEntity.ok( "Hello, I am Admin user");
	}
	
	@PostMapping("/new")
	public String addNewUSer(@RequestBody UserInfo userInfo) {
		return userService.addUSer(userInfo);
	}
	
	
}
