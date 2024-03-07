package com.example.petsquad;

public class DoctorAppointmentModal {

    private String appointDate;
    private String appointTime;
    private String petName;

    public DoctorAppointmentModal(String appointDate, String appointTime,String petName) {
        this.appointDate = appointDate;
        this.appointTime = appointTime;
        this.petName=petName;
    }


    public String getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(String appointDate) {
        this.appointDate = appointDate;
    }

    public String getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(String appointTime) {
        this.appointTime = appointTime;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }
}
