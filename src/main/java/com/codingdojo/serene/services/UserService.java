package com.codingdojo.serene.services;

import java.util.Optional; 

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.serene.models.LoginUser;
import com.codingdojo.serene.models.User;
import com.codingdojo.serene.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User register(User newUser, BindingResult result) {
    	String passwordEntered = newUser.getPassword();
    	Optional<User> user = userRepo.findByEmail(newUser.getEmail());
    	
    	if(user.isPresent()) {
    		result.rejectValue("email", "Matches", "An account with that email already exists!");
    	}
    	
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
    	
    	if(result.hasErrors()) {
    		return null;
    	}
    
    	String hashed = BCrypt.hashpw(passwordEntered, BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	return userRepo.save(newUser);
    	
    }
    
    public User login(LoginUser newLogin, BindingResult result) {
    	String passwordEntered = newLogin.getPassword();
    	
    	Optional<User> newUser = userRepo.findByEmail(newLogin.getEmail());
        
    	if(!newUser.isPresent()) {
    		result.rejectValue("email", "Matches", "User not found!");
    		return null;
    	}
    	
    	
    	User user = newUser.get();
        
    	if(!BCrypt.checkpw(passwordEntered, user.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	
    	if(result.hasErrors()) {
    		return null;
    	}
    	
        return user;
    	
    }
    
    public User findById(Long id) {
    	Optional<User> user = userRepo.findById(id);
    	if(user.isPresent()) {
    		return user.get();
    	}
    	return null;
    }
}