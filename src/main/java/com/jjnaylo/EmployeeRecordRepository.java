package com.jjnaylo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRecordRepository extends MongoRepository<EmployeeRecord, String> {
	

}
