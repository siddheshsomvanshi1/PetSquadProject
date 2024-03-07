package com.example.petsquad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ViewPetProfile extends AppCompatActivity {

    private ArrayList<PetProfileModal> petProfileModalArrayList;
    private DatabaseHelper dbHandler;
    private PetProfileRVAdapter petProfileRVAdapter;
    private RecyclerView petsRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pet_profile);

        dbHandler=new DatabaseHelper(this);

        petProfileModalArrayList=dbHandler.readPets();

        petProfileRVAdapter = new PetProfileRVAdapter(petProfileModalArrayList, ViewPetProfile.this);
        petsRV = findViewById(R.id.idRVPets);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewPetProfile.this, RecyclerView.VERTICAL, false);
        petsRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        petsRV.setAdapter(petProfileRVAdapter);
    }
    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
        startActivity(new Intent(ViewPetProfile.this,AdminHomeActivity.class));
    }
}