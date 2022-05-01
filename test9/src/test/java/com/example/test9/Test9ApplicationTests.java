package com.example.test9;

import com.example.test9.api.ResourceNotFoundException;
import com.example.test9.api.user;
import com.example.test9.api.userRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest

@RestController
public class Test9ApplicationTests {
	@Autowired
	userRepository userRepository;
	@GetMapping("/userinfo/{id}")
	@Test
	void TestGetUserById() {
		user user = userRepository.findById(testdata.id)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", testdata.id));
		/*return userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));*/
		Assertions.assertNotNull(user.getId());
		Assertions.assertEquals(user.getId(),testdata.id);
		Assertions.assertEquals(user.getName(),testdata.name);
	}

	@PutMapping("/userinfo/{id}")
	@Test
	void TestUpdateTel(){
		user user = userRepository.findById(testdata.id)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", testdata.id));

		user.setTel(testdata.tel);

		//user updatedUser = userRepository.save(user);
		Assertions.assertNotNull(user.getId());
		Assertions.assertEquals(user.getId(),testdata.id);
		Assertions.assertNotNull(user.getTel());
		Assertions.assertEquals(user.getTel(),testdata.tel);
	}
	@Valid
	public class testdata{
		static long id = 1;
		static String name = "Chang";
		static String tel = "0123456789";
	}
}
