package com.example.petsquad;

public class DoctorModal {

    private String doctorName;
    private String doctorAge;
    private String doctorExperience;
    private int id;

    public DoctorModal(String doctorName, String doctorAge, String doctorExperience) {
        this.doctorName = doctorName;
        this.doctorAge = doctorAge;
        this.doctorExperience = doctorExperience;

    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorAge() {
        return doctorAge;
    }

    public void setDoctorAge(String doctorAge) {
        this.doctorAge = doctorAge;
    }

    public String getDoctorExperience() {
        return doctorExperience;
    }

    public void setDoctorExperience(String doctorExperience) {
        this.doctorExperience = doctorExperience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
