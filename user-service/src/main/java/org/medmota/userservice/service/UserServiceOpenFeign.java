package org.medmota.userservice.service;

import org.medmota.userservice.dto.DepartmentDto;
import org.medmota.userservice.dto.ResponseDto;
import org.medmota.userservice.dto.UserDto;
import org.medmota.userservice.entities.User;
import org.medmota.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceOpenFeign implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ApiClient apiClient;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public ResponseDto getUser(Long userId) {
		User user = userRepository.findById(userId).get();
		UserDto userDto = mapToUser(user);

		DepartmentDto departmentDto = apiClient.getDepartmentById(Long.parseLong(user.getDepartmentId()));

		ResponseDto responseDto = new ResponseDto();
		responseDto.setUser(userDto);
		responseDto.setDepartment(departmentDto);

		return responseDto;
	}

}
