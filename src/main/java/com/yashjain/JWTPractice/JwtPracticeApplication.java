package com.yashjain.JWTPractice;

import com.yashjain.JWTPractice.domain.Role;
import com.yashjain.JWTPractice.domain.User;
import com.yashjain.JWTPractice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtPracticeApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Yash Jain", "yash123", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Sangeeta Sharma", "sangeeta123", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Umesh Singh", "umesh123", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Prateek Goyal", "prateek123", "prateek", new ArrayList<>()));

			userService.addRoleToUser("prateek123", "ROLE_MANAGER");
			userService.addRoleToUser("prateek123", "ROLE_USER");
			userService.addRoleToUser("umesh123", "ROLE_MANAGER");
			userService.addRoleToUser("sangeeta123", "ROLE_ADMIN");
			userService.addRoleToUser("yash123", "ROLE_ADMIN");
			userService.addRoleToUser("yash123", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("yash123", "ROLE_USER");
		};
	}
}
