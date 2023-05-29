package com.example.projecthubserver.controller;

import com.example.projecthubserver.dto.UserDTO;
import com.example.projecthubserver.model.User;
import com.example.projecthubserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        // Extract user registration data from the request payload
        String firstName = userDTO.getFirstName();
        String lastName = userDTO.getLastName();
        String email = userDTO.getEmail();
        String password = userDTO.getPassword();

        // Validate the user registration data (e.g., check for required fields, email format, password strength, etc.)
        // You can use Spring validations, custom validation logic, or any validation library of your choice

        // Check if the email is already registered
        if (userRepository.findByEmail(email) != null) {
            return ResponseEntity.badRequest().body("Email is already registered.");
        }

        // Create a new User object and set the provided data
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);

        // Save the new user to the database using the UserRepository
        userRepository.save(user);

        // Return a success response
        return ResponseEntity.ok("User registered successfully.");
    }
}
