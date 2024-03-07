package com.example.petsquad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ViewMySchedule extends AppCompatActivity {

    private ArrayList<DoctorScheduleModal> doctorScheduleModalArrayList;
    private DatabaseHelper dbHandler;
    private DoctorScheduleRVAdapter doctorScheduleRVAdapter;
    private RecyclerView dscheduleRV;
    Integer did;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_schedule);

        dbHandler=new DatabaseHelper(this);

        Intent intent = getIntent();


        did = intent.getIntExtra("did",0);


        doctorScheduleModalArrayList=dbHandler.readmyDoctorSchedule(did);

        doctorScheduleRVAdapter = new DoctorScheduleRVAdapter(doctorScheduleModalArrayList, ViewMySchedule.this);
        dscheduleRV = findViewById(R.id.idRVmySchedule);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewMySchedule.this, RecyclerView.VERTICAL, false);
        dscheduleRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        dscheduleRV.setAdapter(doctorScheduleRVAdapter);
    }


    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
        Intent i=new Intent(ViewMySchedule.this,DoctorSchedule.class);
        i.putExtra("did",did);
        startActivity(i);
        finish();
        //startActivity(new Intent(ViewMySchedule.this,DoctorSchedule.class));
    }
}