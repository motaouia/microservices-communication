package org.medmota.userservice.service;

import org.medmota.userservice.dto.DepartmentDto;
import org.medmota.userservice.dto.ResponseDto;
import org.medmota.userservice.dto.UserDto;
import org.medmota.userservice.entities.User;
import org.medmota.userservice.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements IUserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ResponseDto getUser(Long userId) {

		ResponseDto responseDto = new ResponseDto();
		User user = userRepository.findById(userId).get();
		UserDto userDto = mapToUser(user);

		ResponseEntity<DepartmentDto> responseEntity = restTemplate
				.getForEntity("http://localhost:8080/api/departments/" + Integer.parseInt(user.getDepartmentId()), DepartmentDto.class);

		DepartmentDto departmentDto = responseEntity.getBody();

		logger.info(String.format("=>> The HttpCode Response is : {%s}" ,responseEntity.getStatusCode().value()));

		responseDto.setUser(userDto);
		responseDto.setDepartment(departmentDto);

		return responseDto;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	/*private UserDto mapToUser(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		return userDto;
	}
	*/

}
