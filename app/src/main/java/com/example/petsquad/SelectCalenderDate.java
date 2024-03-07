package com.example.petsquad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;

import java.util.Calendar;

public class SelectCalenderDate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_calender_date);

        CalendarView calendarView=findViewById(R.id.calender);

        Intent intent=getIntent();

        String petName=intent.getStringExtra("petName");

        Integer ownerid=intent.getIntExtra("ID",0);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date=i+"/"+i1+"/"+i2;

                Calendar calendar = Calendar.getInstance();
                calendar.set(i, i1, i2);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

                Intent intent=new Intent(SelectCalenderDate.this,BookDoctorAppointment.class);
                intent.putExtra("date",date);
                intent.putExtra("weekday",dayOfWeek);
                intent.putExtra("petName",petName);
                intent.putExtra("ID",ownerid);
                startActivity(intent);
            }
        });

    }
}