package org.medmota.departmentservice.service;

import org.medmota.departmentservice.entities.Department;

public interface IDepartmentService {
	
	Department saveDepartment(Department department);
	Department getDepartmentById(Long id);

}
