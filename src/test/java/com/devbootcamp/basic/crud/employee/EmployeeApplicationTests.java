package com.devbootcamp.basic.crud.employee;

import com.devbootcamp.basic.crud.employee.entity.EmployeeEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void returnListOfEmployee() {
		//arrange
		EmployeeEntity employeeEntity=new EmployeeEntity();
		employeeEntity.setEmail("abc@gmail.com");
		employeeEntity.setFirstName("karthik");

		//act
		ResponseEntity<List> response=restTemplate.getForEntity("/employees",List.class);

		//assert
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}

}
