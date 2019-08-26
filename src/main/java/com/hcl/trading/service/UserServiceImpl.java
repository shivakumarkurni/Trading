package com.hcl.trading.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.trading.dto.UserDetailsDto;
import com.hcl.trading.dto.UserDto;
import com.hcl.trading.entity.User;
import com.hcl.trading.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;
	
	public UserDetailsDto validateLogin(UserDto userDto) {
		LOGGER.debug("UserServiceImpl login()");
		
		UserDetailsDto userDetailsDto = null;
		User user = userRepository.findByMobileNoAndPassword(userDto.getMobileNo(),userDto.getPassword());
		if(user!=null) {
			userDetailsDto = new UserDetailsDto();
			userDetailsDto.setUserId(user.getUserId());
			userDetailsDto.setStatusCode(200);
			userDetailsDto.setMessage("Logged In Successfully..");
		}
		else {
			userDetailsDto = new UserDetailsDto();
			userDetailsDto.setStatusCode(401);
			userDetailsDto.setMessage("Enter Valid MobileNo and Password..");
		}
		return userDetailsDto;
	}

	
	
}
