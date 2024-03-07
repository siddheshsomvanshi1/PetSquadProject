package com.example.petsquad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ViewMyDoctorAppointment extends AppCompatActivity {

    private ArrayList<DoctorAppointmentModal> doctorAppointmentModalArrayList;
    private DatabaseHelper dbHandler;
    private DoctorAppointmentRVAdapter doctorAppointmentRVAdapter;
    private RecyclerView dappointmentRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_doctor_appointment);

        Intent intent = getIntent();


        Integer did = intent.getIntExtra("did",0);


        dbHandler=new DatabaseHelper(this);

        doctorAppointmentModalArrayList=dbHandler.readmyDoctorAppointments(did);

        doctorAppointmentRVAdapter = new DoctorAppointmentRVAdapter(doctorAppointmentModalArrayList, ViewMyDoctorAppointment.this);
        dappointmentRV = findViewById(R.id.idRVmyDoctorAppointment);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewMyDoctorAppointment.this, RecyclerView.VERTICAL, false);
        dappointmentRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        dappointmentRV.setAdapter(doctorAppointmentRVAdapter);

    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();

            startActivity(new Intent(ViewMyDoctorAppointment.this,DoctorHomeActivity.class));

    }

}