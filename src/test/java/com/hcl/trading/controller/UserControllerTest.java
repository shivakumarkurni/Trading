package com.hcl.trading.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.trading.dto.UserDetailsDto;
import com.hcl.trading.dto.UserDto;
import com.hcl.trading.service.UserService;

@RunWith(value = SpringJUnit4ClassRunner.class)
public class UserControllerTest {

	@Mock
	UserService userService;
	
	@InjectMocks
	UserController userController;
	
	UserDto userDto = null;
	UserDetailsDto userDetailsDto = null;
	
	@Before
	public void setup() {
		userDto = new UserDto();
		userDto.setMobileNo(9618L);
		
		userDetailsDto = new UserDetailsDto();
		userDetailsDto.setStatusCode(200);
	}

	@Test
	public void validateLoginTestSuccess() {
		Mockito.when(userService.validateLogin(userDto)).thenReturn(userDetailsDto);
		ResponseEntity<UserDetailsDto> usResponseEntity = userController.validateLogin(userDto);
		UserDetailsDto userDetailsDtos = usResponseEntity.getBody();
		assertEquals(userDetailsDto.getStatusCode(), userDetailsDtos.getStatusCode());
		
	}
	
	@Test
	public void validateLoginTestFailure() {
		userDto = new UserDto();
		userDto.setMobileNo(null);
		
		userDetailsDto = new UserDetailsDto();
		userDetailsDto.setStatusCode(401);
		
		Mockito.when(userService.validateLogin(userDto)).thenReturn(userDetailsDto);
		ResponseEntity<UserDetailsDto> usResponseEntity = userController.validateLogin(userDto);
		UserDetailsDto userDetailsDtos = usResponseEntity.getBody();
		assertEquals(userDetailsDto.getStatusCode(), userDetailsDtos.getStatusCode());
		
	}

}
