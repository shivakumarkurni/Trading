package com.hcl.trading.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.trading.dto.UserDetailsDto;
import com.hcl.trading.dto.UserDto;
import com.hcl.trading.entity.User;
import com.hcl.trading.repository.UserRepository;

@RunWith(value = SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserServiceImpl userService;
	
	UserDto userDto = null;
	UserDetailsDto userDetailsDto = null;
	User user = null;
	
	@Before
	public void setup() {
		userDto = new UserDto();
		userDto.setMobileNo(9618L);
		
		userDetailsDto = new UserDetailsDto();
		userDetailsDto.setStatusCode(200);
		
		user = new User();
		user.setMobileNo(9618L);
	}

	@Test
	public void validateLoginTestSuccess() {
		Mockito.when(userRepository.findByMobileNoAndPassword(userDto.getMobileNo(), userDto.getPassword())).thenReturn(user);
		UserDetailsDto usResponseEntity = userService.validateLogin(userDto);
		assertEquals(userDetailsDto.getStatusCode(), usResponseEntity.getStatusCode());
		
	}
	
	@Test
	public void validateLoginTestFailure() {
		userDto = new UserDto();
		userDto.setMobileNo(null);
		
		userDetailsDto = new UserDetailsDto();
		userDetailsDto.setStatusCode(401);
		
		
		Mockito.when(userRepository.findByMobileNoAndPassword(userDto.getMobileNo(), userDto.getPassword())).thenReturn(null);
		UserDetailsDto usResponseEntity = userService.validateLogin(userDto);
		assertEquals(userDetailsDto.getStatusCode(), usResponseEntity.getStatusCode());
		
	}

}
