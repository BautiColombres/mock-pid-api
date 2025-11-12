package com.example.mock_pid_api.controller;

import com.example.mock_pid_api.dto.MedicalCheckRequest;
import com.example.mock_pid_api.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class MockController {

    private final Random random = new Random();

    @PostMapping("/isUser")
    public boolean isUser(@RequestBody UserRequest request) {
        // Returns a random true or false
        return random.nextBoolean();
    }

    @PostMapping("/userHasMedicalCheck")
    public boolean userHasMedicalCheck(@RequestBody MedicalCheckRequest request) {
        // Returns a random true or false
        return random.nextBoolean();
    }
}
