package com.jjnaylo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(collectionResourceRel = "employees", path="employees")
public interface EmployeeRecordRepository extends MongoRepository<EmployeeRecord, String> {
	List<EmployeeRecord> findByLastName(@Param("lastName") String lastName);
	
	@Transactional
	Long deleteByLastName(@Param("lastName") String lastName);
}
