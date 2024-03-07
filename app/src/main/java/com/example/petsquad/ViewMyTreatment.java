package com.example.petsquad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ViewMyTreatment extends AppCompatActivity {

    private ArrayList<TreatmentModal> treatmentModalArrayList;
    private DatabaseHelper dbHandler;
    private TreatmentRVAdapter treatmentRVAdapter;
    private RecyclerView treatmentsRV;
    Integer did;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_treatment);

        dbHandler=new DatabaseHelper(this);

        Intent intent = getIntent();


        did = intent.getIntExtra("did",0);

        treatmentModalArrayList=dbHandler.readmyTreatments(did);

        treatmentRVAdapter = new TreatmentRVAdapter(treatmentModalArrayList, ViewMyTreatment.this);
        treatmentsRV = findViewById(R.id.idRVmyTreatments);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewMyTreatment.this, RecyclerView.VERTICAL, false);
        treatmentsRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        treatmentsRV.setAdapter(treatmentRVAdapter);



    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
        Intent intent=new Intent(ViewMyTreatment.this,AddTreatment.class);
        intent.putExtra("did",did);
        startActivity(intent);
        finish();
        //startActivity(new Intent(ViewMyTreatment.this,AddTreatment.class));
    }
}