package com.example.petsquad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    String loginUsername;
    Integer ownerid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button viewTreatment=findViewById(R.id.buttonTreat);
        Button buttonpet=findViewById(R.id.buttonpet);
        Button doctorAppointment=findViewById(R.id.buttonDoctorAppointment);

        Button logout=findViewById(R.id.clogout);

        Intent intent = getIntent();


        ownerid = intent.getIntExtra("ID",0);


        Intent i1=getIntent();

        loginUsername=i1.getStringExtra("username");

        /*manageevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(), ManageEvent.class);
                intent.putExtra("fromevent","owner");
                startActivity(intent);
                finish();
            }
        });*/

        buttonpet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(HomeActivity.this,ManagePetProfile.class);
                i1.putExtra("ID",ownerid);
                startActivity(i1);
                finish();

                //startActivity(new Intent(HomeActivity.this,ViewTreatment.class));
            }
        });

        viewTreatment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(HomeActivity.this,ViewTreatment.class);
                i1.putExtra("fromtreatment","owner");
                startActivity(i1);
                finish();
                //startActivity(new Intent(HomeActivity.this,ViewTreatment.class));
               // finish();
            }
        });
/*
        Button petProfile= findViewById(R.id.buttonpet);
        petProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, PetProfile.class));
            }
        });
*/
        Button viewDoctor=findViewById(R.id.buttonDoctor);

        viewDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(HomeActivity.this,ViewDoctor.class);
                i1.putExtra("fromdoctor","owner");
                startActivity(i1);
                finish();

            }
        });

        doctorAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(HomeActivity.this,BookDoctorAppointment.class);
                i1.putExtra("ID",ownerid);
                startActivity(i1);
                finish();
            }
        });

        /*bookProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(HomeActivity.this,BookProduct.class);
                i1.putExtra("ID",ownerid);
                i1.putExtra("username",loginUsername);

                startActivity(i1);
                finish();
            }
        });

        viewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(HomeActivity.this,ViewProduct.class);
                i1.putExtra("ID",ownerid);
                i1.putExtra("fromproduct","owner");

                startActivity(i1);
                finish();

            }
        });*/



        /*viewShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,ViewShop.class));
                finish();
            }
        });

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ManagePost.class);
                intent.putExtra("frompost","owner");
                startActivity(intent);
                finish();
            }
        });*/

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,LoginActivity.class));
                finish();
            }
        });

    }




}