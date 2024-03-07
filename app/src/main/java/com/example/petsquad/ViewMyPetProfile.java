package com.example.petsquad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ViewMyPetProfile extends AppCompatActivity {

    private ArrayList<PetProfileModal> petProfileModalArrayList;
    private DatabaseHelper dbHandler;
    private PetProfileRVAdapter petProfileRVAdapter;
    private RecyclerView petsRV;
    Integer ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_pet_profile);

        dbHandler=new DatabaseHelper(this);

        Intent intent = getIntent();


        ID = intent.getIntExtra("ID",0);


        petProfileModalArrayList=dbHandler.readmyPets(ID);

        petProfileRVAdapter = new PetProfileRVAdapter(petProfileModalArrayList, ViewMyPetProfile.this);
        petsRV = findViewById(R.id.idRVmyPets);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewMyPetProfile.this, RecyclerView.VERTICAL, false);
        petsRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        petsRV.setAdapter(petProfileRVAdapter);
    }
    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
        Intent intent=new Intent(ViewMyPetProfile.this,ManagePetProfile.class);
        intent.putExtra("ID",ID);
        startActivity(intent);
        finish();
        //startActivity(new Intent(ViewMyPetProfile.this,ManagePetProfile.class));
        //finish();


    }
}