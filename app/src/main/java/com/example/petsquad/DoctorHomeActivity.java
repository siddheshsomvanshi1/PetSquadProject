package com.example.petsquad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class DoctorHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);
        Button addtreatment=findViewById(R.id.addt);

        /*Button readtreatment=findViewById(R.id.readt);

         */
        Button logout=findViewById(R.id.logout);

        Button addSchedule=findViewById(R.id.adds);

        Button viewAppointment=findViewById(R.id.edits);

        Intent intent = getIntent();


        Integer did = intent.getIntExtra("did",0);

        /*events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  startActivity(new Intent(DoctorHomeActivity.this,ManageEvent.class));
               // finish();

                Intent intent = new Intent(getApplicationContext(), ManageEvent.class);
                intent.putExtra("fromevent","doctor");
                startActivity(intent);
                finish();
            }
        });*/



        addtreatment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddTreatment.class);
                intent.putExtra("did",did);
                startActivity(intent);
                finish();
                // startActivity(new Intent(DoctorHomeActivity.this,AddTreatment.class));
            }
        });

        addSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DoctorSchedule.class);
                intent.putExtra("did",did);
                startActivity(intent);
                finish();
            }
        });

        viewAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ViewMyDoctorAppointment.class);
                intent.putExtra("did",did);
                startActivity(intent);
                finish();
               // startActivity(new Intent(DoctorHomeActivity.this,ViewMyDoctorAppointment.class));
            }
        });




        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorHomeActivity.this,LoginActivity.class));
                finish();
            }
        });


        /*upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(DoctorHomeActivity.this,ManagePost.class));
               // finish();
                Intent intent = new Intent(getApplicationContext(), ManagePost.class);
                intent.putExtra("frompost","doctor");
                startActivity(intent);
                finish();
            }
        });*/

    }

}

