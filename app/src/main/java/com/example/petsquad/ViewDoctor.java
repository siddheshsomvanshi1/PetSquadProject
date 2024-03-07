package com.example.petsquad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ViewDoctor extends AppCompatActivity {

    private ArrayList<DoctorModal> doctorModalArrayList;
    private DatabaseHelper dbHandler;
    private DoctorRVAdapter doctorRVAdapter;
    private RecyclerView doctorsRV;
    String fromdoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_doctor);
        Intent intent=getIntent();

        fromdoctor=intent.getStringExtra("fromdoctor");


        dbHandler=new DatabaseHelper(this);

        doctorModalArrayList=dbHandler.readDoctors();

        doctorRVAdapter = new DoctorRVAdapter(doctorModalArrayList, ViewDoctor.this);
        doctorsRV = findViewById(R.id.idRVDoctors);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewDoctor.this, RecyclerView.VERTICAL, false);
        doctorsRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        doctorsRV.setAdapter(doctorRVAdapter);

    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
        if(fromdoctor.equals("admin"))
        {
            startActivity(new Intent(ViewDoctor.this,AdminHomeActivity.class));
            finish();
        }
        else
        {
            startActivity(new Intent(ViewDoctor.this,HomeActivity.class));
            finish();
        }

    }
}