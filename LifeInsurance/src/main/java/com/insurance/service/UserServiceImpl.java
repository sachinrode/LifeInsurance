package com.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insurance.exception.ResourceNotFoundException;
import com.insurance.model.User;
import com.insurance.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(long id) {
		return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));
	}

	@Override
	public User updateUser(User user, long id) {
		User users=userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));;
		users.setName(user.getName());
		users.setEmail(user.getEmail());
		users.setAddress(user.getAddress());
		users.setDateOfBirth(user.getDateOfBirth());
		users.setPolicyNumber(user.getPolicyNumber());
		return userRepository.save(users);
		}

	@Override
	public User deleteUser(long id) {
		User users=userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));
		userRepository.delete(users);
		return users;
	}
	

}
