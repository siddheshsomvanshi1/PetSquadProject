package com.example.petsquad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);


        Button viewCustomers=findViewById(R.id.viewCustomers);
        Button viewDoctors=findViewById(R.id.viewDoctors);
        Button viewPets=findViewById(R.id.viewPets);
        Button viewTreatments=findViewById(R.id.viewTreatments);

        Button logout=findViewById(R.id.viewlogout);

        viewCustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminHomeActivity.this,ViewOwner.class));
                finish();
            }
        });


        viewDoctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AdminHomeActivity.this,ViewDoctor.class);
                i.putExtra("fromdoctor","admin");
                startActivity(i);
                finish();
                //startActivity(new Intent(AdminHomeActivity.this,ViewDoctor.class));
                //finish();
            }
        });

        viewPets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminHomeActivity.this,ViewPetProfile.class));
                finish();
            }
        });

        viewTreatments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AdminHomeActivity.this,ViewTreatment.class);
                i.putExtra("fromtreatment","admin");
                startActivity(i);
                finish();
               // startActivity(new Intent(AdminHomeActivity.this,ViewTreatment.class));
                //finish();
            }
        });

        /*viewProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AdminHomeActivity.this,ViewProduct.class);
                i.putExtra("fromproduct","admin");
                startActivity(i);
                finish();
               // startActivity(new Intent(AdminHomeActivity.this,ViewProduct.class));
                //finish();
            }
        });

        viewEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AdminHomeActivity.this,ViewEvent.class);
                i.putExtra("fromevent","admin");
                startActivity(i);
                finish();
               // startActivity(new Intent(AdminHomeActivity.this,ViewEvent.class));
                //finish();
            }
        });

        viewPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AdminHomeActivity.this,ViewPost.class);
                i.putExtra("frompost","admin");
                startActivity(i);
                finish();
                //startActivity(new Intent(AdminHomeActivity.this,ViewPost.class));
                //finish();
            }
        });*/

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminHomeActivity.this,LoginActivity.class));
                finish();
            }
        });


    }
}