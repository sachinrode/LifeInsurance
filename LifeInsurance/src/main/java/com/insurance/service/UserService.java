package com.insurance.service;

import java.util.List;
import com.insurance.model.User;

public interface UserService {

	List<User> getAllUsers();

	User addUser(User user);

	User getUserById(long id);

	User updateUser(User user, long id);

	User deleteUser(long id);


}
