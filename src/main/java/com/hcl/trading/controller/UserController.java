package com.hcl.trading.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trading.dto.UserDetailsDto;
import com.hcl.trading.dto.UserDto;
import com.hcl.trading.service.UserService;

@RestController
@RequestMapping("/trading")
@CrossOrigin(origins = {"*","*/"},allowedHeaders = {"*","*/"})
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@PostMapping("/login")
	public ResponseEntity<UserDetailsDto> validateLogin(@RequestBody UserDto userDto) {
		LOGGER.debug("MortgageController:validateLogin");
		UserDetailsDto userDetailsDto = userService.validateLogin(userDto);
		return new ResponseEntity<>(userDetailsDto, HttpStatus.OK);
	}

}
