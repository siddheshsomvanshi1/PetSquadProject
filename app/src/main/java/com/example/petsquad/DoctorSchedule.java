package com.example.petsquad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class DoctorSchedule extends AppCompatActivity {

    String Day,Open,Close;
    private DatabaseHelper mydDB;
    Integer did;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_schedule);

        Intent intent = getIntent();
         did = intent.getIntExtra("did",0);

        Spinner days=findViewById(R.id.spinDays);
        Spinner openTime=findViewById(R.id.spinStartTime);
        Spinner closeTime=findViewById(R.id.spinEndTime);
        Button addSchedule=findViewById(R.id.btnAddSchedule);
        Button readSchedule=findViewById(R.id.btnReadSchedule);
        Button updateSchedule=findViewById(R.id.btnUpdateSchedule);
        Button deleteSchedule=findViewById(R.id.btnDeleteSchedule);

        mydDB=new DatabaseHelper(this);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this , R.array.days, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        days.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this , R.array.time, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        openTime.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this , R.array.time, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        closeTime.setAdapter(adapter2);

        addSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Day=days.getSelectedItem().toString();
                Open= openTime.getSelectedItem().toString();
                Close=closeTime.getSelectedItem().toString();
                if (Day.isEmpty() && Open.isEmpty() && Close.isEmpty()) {
                    Toast.makeText(DoctorSchedule.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(Integer.valueOf(openTime.getSelectedItem().toString()) >=  Integer.valueOf(closeTime.getSelectedItem().toString()))
                {
                    Toast.makeText(DoctorSchedule.this, "Please enter valid timings", Toast.LENGTH_SHORT).show();
                    return;
                }

                mydDB.addNewScehdule(Day, Open, Close,did);

                Toast.makeText(getBaseContext(), "Schedule has been added.", Toast.LENGTH_SHORT).show();
                // after adding the data we are displaying a toast message.


                days.setSelection(0);
                openTime.setSelection(0);
                closeTime.setSelection(0);


            }
        });


        readSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DoctorSchedule.this,ViewMySchedule.class);
                i.putExtra("did",did);
                startActivity(i);
                finish();


                //startActivity(new Intent(DoctorSchedule.this,ViewMySchedule.class));
            }
        });

        updateSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inside this method we are calling an update course
                // method and passing all our edit text values.
                mydDB.updateDoctorSchedule(days.getSelectedItem().toString(), openTime.getSelectedItem().toString(), closeTime.getSelectedItem().toString());

                // displaying a toast message that our course has been updated.
                Toast.makeText(DoctorSchedule.this, "Schedule Updated..", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                //Intent i = new Intent(AddTreatment.this, MainActivity.class);
                // startActivity(i);
            }
        });


        deleteSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to delete our course.
                mydDB.deleteDoctorSchedule(days.getSelectedItem().toString());
                Toast.makeText(DoctorSchedule.this, "Deleted the Schedule", Toast.LENGTH_SHORT).show();
                //Intent i = new Intent(AddTreatment.this, MainActivity.class);
                //startActivity(i);
            }
        });


    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
        Intent i=new Intent(DoctorSchedule.this,DoctorHomeActivity.class);
        i.putExtra("did",did);
        startActivity(i);
        finish();
        //startActivity(new Intent(DoctorSchedule.this,DoctorHomeActivity.class));
    }
}