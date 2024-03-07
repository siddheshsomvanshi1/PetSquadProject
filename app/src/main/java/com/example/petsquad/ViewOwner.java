package com.example.petsquad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ViewOwner extends AppCompatActivity {

    private ArrayList<OwnerModal> ownerModalArrayList;
    private DatabaseHelper dbHandler;
    private OwnerRVAdapter ownerRVAdapter;
    private RecyclerView ownersRV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_owner);

        dbHandler=new DatabaseHelper(this);



        ownerModalArrayList=dbHandler.readOwners();

        ownerRVAdapter = new OwnerRVAdapter(ownerModalArrayList, ViewOwner.this);
        ownersRV = findViewById(R.id.idRVOwners);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewOwner.this, RecyclerView.VERTICAL, false);
        ownersRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        ownersRV.setAdapter(ownerRVAdapter);


    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
        startActivity(new Intent(ViewOwner.this,AdminHomeActivity.class));
    }
}