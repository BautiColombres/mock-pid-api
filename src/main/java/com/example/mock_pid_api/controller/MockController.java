package com.example.mock_pid_api.controller;

import com.example.mock_pid_api.dto.MedicalCheckRequest;
import com.example.mock_pid_api.dto.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MockController {

    @PostMapping("/isUser")
    public boolean isUser(@RequestBody UserRequest request) {
        // Returns true for Gmail addresses, false for anything else
        if (request.getEmail() != null && request.getEmail().toLowerCase().endsWith("@gmail.com")) {
            return true;
        }
        return false;
    }

    @PostMapping("/userHasMedicalCheck")
    public ResponseEntity<String> userHasMedicalCheck(@RequestBody MedicalCheckRequest request) {
        // Validate email is present
        if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Email is required");
        }
        
        // Validate email format (basic check)
        if (!request.getEmail().contains("@")) {
            return ResponseEntity.badRequest().body("Invalid email format");
        }
        
        // If validation passes, return 200 OK
        return ResponseEntity.ok().build();
    }
}
