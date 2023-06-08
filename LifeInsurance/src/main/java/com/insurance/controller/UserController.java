package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.insurance.model.User;
import com.insurance.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User users = userService.addUser(user);
		return ResponseEntity.ok().body(users);
	}

	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return ResponseEntity.ok().body(users);
	}

	@GetMapping("/getUserById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable long id) {
		User user = userService.getUserById(id);
		return ResponseEntity.ok().body(user);

	}

	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateEmployee(@RequestBody User user, @PathVariable("id") long id) {
		User users = userService.updateUser(user, id);
		return ResponseEntity.ok().body(users);
	}

	@DeleteMapping("deleteUser/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
		User users = userService.deleteUser(id);
		return ResponseEntity.ok().body(users);
	}

}
