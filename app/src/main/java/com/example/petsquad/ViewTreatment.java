package com.example.petsquad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewTreatment extends AppCompatActivity {

    private ArrayList<TreatmentModal> treatmentModalArrayList;
    private DatabaseHelper dbHandler;
    private TreatmentRVAdapter treatmentRVAdapter;
    private RecyclerView treatmentsRV;
    String fromtreatment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_treatment);

        Intent intent=getIntent();

        fromtreatment=intent.getStringExtra("fromtreatment");

        dbHandler=new DatabaseHelper(this);

        treatmentModalArrayList=dbHandler.readTreatments();

        treatmentRVAdapter = new TreatmentRVAdapter(treatmentModalArrayList, ViewTreatment.this);
        treatmentsRV = findViewById(R.id.idRVTreatments);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewTreatment.this, RecyclerView.VERTICAL, false);
        treatmentsRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        treatmentsRV.setAdapter(treatmentRVAdapter);
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
        if(fromtreatment.equals("admin"))
        {
            startActivity(new Intent(ViewTreatment.this,AdminHomeActivity.class));
            finish();
        }
        else
        {
            startActivity(new Intent(ViewTreatment.this,HomeActivity.class));
            finish();
        }

    }
}