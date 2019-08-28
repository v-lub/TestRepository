package telran.java29.forum.controller;

//import java.security.Principal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import telran.java29.forum.dto.UserEditDto;
import telran.java29.forum.dto.UserProfileDto;

import telran.java29.forum.dto.UserRegDto;

import telran.java29.forum.service.AccountService;

@RestController

@RequestMapping("/account")

public class AccountManagmentController {

	@Autowired

	AccountService accountService;

	@PostMapping

	public UserProfileDto register(@RequestBody UserRegDto userRegDto) {

		return accountService.addUser(userRegDto);

	}

	@PostMapping("/{id}")
	// @PreAuthorize("#id == authentication.name and hasAnyRole('ADMIN','MODERATOR','USER') ")
	public UserProfileDto userLogin(@PathVariable String id) {

		return accountService.findUserById(id);

	}

	@PutMapping
	public UserProfileDto edit(@RequestBody UserEditDto userEditDto, Authentication authentication) {

		return accountService.edit(userEditDto, authentication.getName());

	}

	@DeleteMapping
	public UserProfileDto remove(Authentication authentication) {

		return accountService.remove(authentication.getName());

	}

	@PutMapping("/{id}/{role}")
	public Set<String> addRole(@PathVariable String id, @PathVariable String role) {

		return accountService.addRole(id, role);
	}

	@DeleteMapping("/{id}/{role}")
	public Set<String> removeRole(@PathVariable String id, @PathVariable String role) {

		return accountService.removeRole(id, role);
	}

	@PutMapping("/password")
	public void changePassword(Authentication authentication, @RequestHeader("X-Password") String password) {
		accountService.changePassword(authentication.getName(), password);
	}

}