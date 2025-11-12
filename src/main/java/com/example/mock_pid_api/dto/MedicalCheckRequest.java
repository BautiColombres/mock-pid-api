package com.example.mock_pid_api.dto;

public class MedicalCheckRequest {
    private String email;
    private boolean medicalCheck;

    public MedicalCheckRequest() {
    }

    public MedicalCheckRequest(String email, boolean medicalCheck) {
        this.email = email;
        this.medicalCheck = medicalCheck;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isMedicalCheck() {
        return medicalCheck;
    }

    public void setMedicalCheck(boolean medicalCheck) {
        this.medicalCheck = medicalCheck;
    }
}
