package org.medmota.userservice.service;

import org.medmota.userservice.dto.ResponseDto;
import org.medmota.userservice.entities.User;

public interface IUserService {

	User saveUser(User user);
	ResponseDto getUser(Long userId);

}
