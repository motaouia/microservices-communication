package org.medmota.userservice.service;

import org.medmota.userservice.dto.ResponseDto;
import org.medmota.userservice.dto.UserDto;
import org.medmota.userservice.entities.User;

public interface IUserService {

	User saveUser(User user);
	ResponseDto getUser(Long userId);
	
	public default UserDto mapToUser(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		return userDto;
	}

}
