package com.example.petsquad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ViewCustomerDoctorAppointment extends AppCompatActivity {

    private ArrayList<DoctorAppointmentModal> doctorAppointmentModalArrayList;
    private DatabaseHelper dbHandler;
    private DoctorAppointmentRVAdapter doctorAppointmentRVAdapter;
    private RecyclerView dappointmentRV;
    Integer ownerid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_customer_doctor_appointment);

        Intent intent = getIntent();


        ownerid = intent.getIntExtra("ID",0);


        dbHandler=new DatabaseHelper(this);

        doctorAppointmentModalArrayList=dbHandler.readcuDoctorAppointments(ownerid);

        doctorAppointmentRVAdapter = new DoctorAppointmentRVAdapter(doctorAppointmentModalArrayList, ViewCustomerDoctorAppointment.this);
        dappointmentRV = findViewById(R.id.idRVCustomerDoctorAppointment);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewCustomerDoctorAppointment.this, RecyclerView.VERTICAL, false);
        dappointmentRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        dappointmentRV.setAdapter(doctorAppointmentRVAdapter);


    }
    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();

        Intent i3=new Intent(ViewCustomerDoctorAppointment.this,BookDoctorAppointment.class);
        i3.putExtra("ID",ownerid);
        startActivity(i3);
        finish();

        //startActivity(new Intent(ViewCustomerDoctorAppointment.this,BookDoctorAppointment.class));
        //finish();


    }
}