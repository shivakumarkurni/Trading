package com.hcl.trading.service;

import com.hcl.trading.dto.UserDetailsDto;
import com.hcl.trading.dto.UserDto;

public interface UserService {
	public UserDetailsDto validateLogin(UserDto userDto);
}
