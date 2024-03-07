package com.example.petsquad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ViewDoctorAppointment extends AppCompatActivity {

    private ArrayList<DoctorAppointmentModal> doctorAppointmentModalArrayList;
    private DatabaseHelper dbHandler;
    private DoctorAppointmentRVAdapter doctorAppointmentRVAdapter;
    private RecyclerView dappointmentRV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_doctor_appointment);

        dbHandler=new DatabaseHelper(this);

        doctorAppointmentModalArrayList=dbHandler.readDoctorAppointments();

        doctorAppointmentRVAdapter = new DoctorAppointmentRVAdapter(doctorAppointmentModalArrayList, ViewDoctorAppointment.this);
        dappointmentRV = findViewById(R.id.idRVDoctorAppointment);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewDoctorAppointment.this, RecyclerView.VERTICAL, false);
        dappointmentRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        dappointmentRV.setAdapter(doctorAppointmentRVAdapter);


    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();

        startActivity(new Intent(ViewDoctorAppointment.this,BookDoctorAppointment.class));
        finish();


    }
}