package org.medmota.userservice.service;

import org.medmota.userservice.dto.DepartmentDto;
import org.medmota.userservice.dto.ResponseDto;
import org.medmota.userservice.dto.UserDto;
import org.medmota.userservice.entities.User;
import org.medmota.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserServiceWebClient implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private WebClient webClient;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public ResponseDto getUser(Long userId) {
		
		User user = userRepository.findById(userId).get();
		UserDto userDto = mapToUser(user);
		
		DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/api/departments/" + user.getDepartmentId())
				.retrieve()
				.bodyToMono(DepartmentDto.class)
				.block();
	
		ResponseDto responseDto = new ResponseDto();
		responseDto.setUser(userDto);	
		responseDto.setDepartment(departmentDto);
		
		return responseDto;
		
	}

}
