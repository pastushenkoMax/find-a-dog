package com.codingdojo.sp.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.sp.models.LoginUser;
import com.codingdojo.sp.models.User;
import com.codingdojo.sp.repository.UserRepository;


@Service
public class UserService {
    
	@Autowired
    private UserRepository uRepository;
    public UserService(UserRepository uRepository) {
		this.uRepository = uRepository;
    }
    
    public User registerUser(User createUser, BindingResult result) {
    	
    	Optional<User> tempUser = uRepository.findByEmail(createUser.getEmail());
    	
    	if(tempUser.isPresent()) {
    		result.rejectValue("email","Matches","Email is alredy taken");
    	}
    	if(!createUser.getPassword().equals(createUser.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
    	if(result.hasErrors()) {
    		return null;
    	}
    	String hashed = BCrypt.hashpw(createUser.getPassword(), BCrypt.gensalt());
    	createUser.setPassword(hashed);
		return uRepository.save(createUser);
    	
    }
    public User loginUser(LoginUser logUser, BindingResult result) {
        
    	Optional<User> tempUser = uRepository.findByEmail(logUser.getEmail());
    	if(result.hasErrors()) {
    		return null;
    	}
    	if(!tempUser.isPresent()) {
    		result.rejectValue("email", "Matches", "User not exist!");
    		return null;
    	}
    	if(!BCrypt.checkpw(logUser.getPassword(), tempUser.get().getPassword())) {
    		result.rejectValue("password", "Matches", "Invalid Password!");
    		return null;
    	}
    	
    	return tempUser.get();
    }
}
