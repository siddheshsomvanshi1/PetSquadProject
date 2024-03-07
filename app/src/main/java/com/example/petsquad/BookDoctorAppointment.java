package com.example.petsquad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class BookDoctorAppointment extends AppCompatActivity {
    Spinner doctorslist,petlist;
    String arrdoctors[],arrpets[];
    Integer docId,ownerid;
    DatabaseHelper db;
    SQLiteDatabase myDb;
    ListView doctors;
    Button bookDoctor;
    Button docAppoint;
    //ArrayList<String> listItem;
   ArrayAdapter adapter,adpt;
   DatabaseHelper mydDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_doctor_appointment);

        bookDoctor = findViewById(R.id.btnBookDoctor);
        Button ViewDoctor=findViewById(R.id.btnViewDoctor);
        doctorslist = findViewById(R.id.spin_doctor);
        petlist=findViewById(R.id.spin_pet);
        docAppoint= findViewById(R.id.doctorAppoint);
        Spinner apptime=findViewById(R.id.spinTime);

        mydDB=new DatabaseHelper(this);

        Intent intent = getIntent();


         ownerid = intent.getIntExtra("ID",0);

        myDb = openOrCreateDatabase("USER_RECORD", Context.MODE_PRIVATE, null);
        Cursor cur = myDb.rawQuery("select name from petprofile where ID=?", new String[]{String.valueOf(ownerid)});
        //Cursor cursor= db.ViewDoctors();
        arrpets = new String[cur.getCount()];
        if (cur.getCount() == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            cur.moveToFirst();
            int x;
            for (x = 0; x < arrpets.length; x++) {
                arrpets[x] = cur.getString(0);
                cur.moveToNext();
            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrpets);
            petlist.setAdapter(adapter);
        }


        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this , R.array.time, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        apptime.setAdapter(adapter1);
        myDb = openOrCreateDatabase("USER_RECORD", Context.MODE_PRIVATE, null);
        Cursor c = myDb.rawQuery("select name from doctor", null);
        //Cursor cursor= db.ViewDoctors();
        arrdoctors = new String[c.getCount()];
        if (c.getCount() == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            c.moveToFirst();
            int x;
            for (x = 0; x < arrdoctors.length; x++) {
                arrdoctors[x] = c.getString(0);
                c.moveToNext();
            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrdoctors);
            doctorslist.setAdapter(adapter);
        }

        Intent i=getIntent();
        String date=i.getStringExtra("date");


        Intent intent1 = getIntent();


        Integer weekday = intent1.getIntExtra("weekday",0);
        String appDay;
        if(weekday==1)
        {
            appDay="Sunday";
        }
        else if(weekday==2)
        {
            appDay="Monday";
        }
        else if(weekday==3)
        {
            appDay="Tuesday";
        }
        else if(weekday==4)
        {
            appDay="Wednesday";
        }
        else if(weekday==5)
        {
            appDay="Thrusday";
        }
        else if(weekday==6)
        {
            appDay="Friday";
        }
        else
        {
            appDay="Saturday";
        }


        docAppoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(BookDoctorAppointment.this,SelectCalenderDate.class);
                i.putExtra("petName",petlist.getSelectedItem().toString());
                i.putExtra("ID",ownerid);
                startActivity(i);
                finish();

                //startActivity(new Intent(BookDoctorAppointment.this,SelectCalenderDate.class));
              //  petlist.setSelection(Integer.valueOf(petName));

            }
        });

        //Intent pet=getIntent();

        //petName=pet.getStringExtra("petName");
       // petlist.setSelection(Integer.valueOf(petName));

        bookDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myDb = openOrCreateDatabase("USER_RECORD", Context.MODE_PRIVATE, null);
                String docName=doctorslist.getSelectedItem().toString();
                Cursor c = myDb.rawQuery("select did from doctor where name=?", new String[]{docName});
                //Cursor cursor= db.ViewDoctors();
                c.moveToFirst();
                docId= Integer.valueOf(c.getString(0));

                String petName=petlist.getSelectedItem().toString();
                //Cursor cur1 = myDb.rawQuery("select name from petprofile where name=?", new String[]{petName});
                //Cursor cursor= db.ViewDoctors();
                //cur1.moveToFirst();
                //docId= Integer.valueOf(c.getString(0));


                Cursor c1 = myDb.rawQuery("select opentime,closetime from doctorschedule where did=? and day=?",new String[]{docId.toString(),appDay});
                c1.moveToFirst();
                String openTime= c1.getString(0);
                String closeTime= c1.getString(1);
                Integer bTime=0;
                String appointTime=apptime.getSelectedItem().toString();

                Integer oTime,cTime,aTime;
                oTime=Integer.valueOf(openTime);
                cTime=Integer.valueOf(closeTime);
                aTime=Integer.valueOf(apptime.getSelectedItem().toString());
                Cursor c2 = myDb.rawQuery("select time from doctorappointment where did=? and date=?",new String[]{docId.toString(),date});
                c2.moveToFirst();
                if(c2.getCount()!=0)
                {
                    String bookedTime= c2.getString(0);
                     bTime=Integer.valueOf(bookedTime);
                     if(bTime==aTime)
                    {
                    Toast.makeText(getBaseContext(), "Appointment already booked. Change Date or Time ", Toast.LENGTH_SHORT).show();
                    }
                     else
                     {
                         if(aTime>=cTime || aTime<=oTime )
                         {
                             Toast.makeText(getBaseContext(), "Appointment not at this time.Change time & try again", Toast.LENGTH_SHORT).show();
                         }
                         else
                         {
                             mydDB.addNewDoctorAppointment(docId,date,appointTime,ownerid,petName);

                             Toast.makeText(getBaseContext(), "Appointment has been added.", Toast.LENGTH_SHORT).show();

                         }

                     }

                }
                else
                {
                    if(aTime>=cTime || aTime<=oTime )
                    {
                        Toast.makeText(getBaseContext(), "Appointment not at this time.Change time & try again", Toast.LENGTH_SHORT).show();
                    }

                    else
                    {
                        mydDB.addNewDoctorAppointment(docId,date,appointTime,ownerid,petName);

                        Toast.makeText(getBaseContext(), "Appointment has been added.", Toast.LENGTH_SHORT).show();

                    }
                }











            }
        });

        ViewDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i3=new Intent(BookDoctorAppointment.this,ViewCustomerDoctorAppointment.class);
                i3.putExtra("ID",ownerid);
                startActivity(i3);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();

        Intent i3=new Intent(BookDoctorAppointment.this,HomeActivity.class);
        i3.putExtra("ID",ownerid);
        startActivity(i3);
        finish();

      //  startActivity(new Intent(BookDoctorAppointment.this,HomeActivity.class));
      //  finish();


    }

}