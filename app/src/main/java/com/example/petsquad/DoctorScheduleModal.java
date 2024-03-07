package com.example.petsquad;

import androidx.recyclerview.widget.RecyclerView;

public class DoctorScheduleModal {

    private String day;
    private String starttime;
    private String closetime;
    private int id;

    public DoctorScheduleModal(String day, String starttime, String closetime) {
        this.day = day;
        this.starttime = starttime;
        this.closetime = closetime;

    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getClosetime() {
        return closetime;
    }

    public void setClosetime(String closetime) {
        this.closetime = closetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
