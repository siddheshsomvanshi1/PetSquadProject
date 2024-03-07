package com.example.petsquad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ViewDoctorSchedule extends AppCompatActivity {

    private ArrayList<DoctorScheduleModal> doctorScheduleModalArrayList;
    private DatabaseHelper dbHandler;
    private DoctorScheduleRVAdapter doctorScheduleRVAdapter;
    private RecyclerView dscheduleRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_doctor_schedule);

        dbHandler=new DatabaseHelper(this);

        doctorScheduleModalArrayList=dbHandler.readDoctorSchedule();

        doctorScheduleRVAdapter = new DoctorScheduleRVAdapter(doctorScheduleModalArrayList, ViewDoctorSchedule.this);
        dscheduleRV = findViewById(R.id.idRVDoctorSchedule);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewDoctorSchedule.this, RecyclerView.VERTICAL, false);
        dscheduleRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        dscheduleRV.setAdapter(doctorScheduleRVAdapter);

    }
}