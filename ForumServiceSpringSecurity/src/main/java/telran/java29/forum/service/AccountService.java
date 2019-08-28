package telran.java29.forum.service;

import java.util.Set;


import telran.java29.forum.dto.UserEditDto;
import telran.java29.forum.dto.UserProfileDto;

import telran.java29.forum.dto.UserRegDto;

public interface AccountService {

	UserProfileDto addUser(UserRegDto userRegDto);

	UserProfileDto edit(UserEditDto userEditDto, String name);

	UserProfileDto remove(String name);

	Set<String> addRole(String id, String role);

	UserProfileDto findUserById(String id);

	void changePassword(String login, String password);

	Set<String> removeRole(String id, String role);

}
