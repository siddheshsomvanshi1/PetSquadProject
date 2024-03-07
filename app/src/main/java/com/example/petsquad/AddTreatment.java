package com.example.petsquad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTreatment extends AppCompatActivity {

    private EditText tName, tDesc, tCost;
    private Button addTreatment;
    private DatabaseHelper mydDB;
    String Name, Description, Cost ;
    Boolean CheckEditTextEmpty ;
    String SQLiteQuery;
    SQLiteDatabase SQLITEDATABASE;
    Integer did;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_treatment);

        tName=findViewById(R.id.treatName);
        tDesc=findViewById(R.id.treatDesc);
        tCost=findViewById(R.id.treatcost);
        addTreatment=findViewById(R.id.addbutton);
        Button readBtn=findViewById(R.id.readbutton);
        Button updateBtn=findViewById(R.id.idBtnUpdate);
        Button deleteBtn=findViewById(R.id.idBtnDelete);


        Intent intent = getIntent();


        did = intent.getIntExtra("did",0);




        mydDB = new DatabaseHelper(this);

        addTreatment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name=tName.getText().toString();
                Description=tDesc.getText().toString();
                Cost=tCost.getText().toString();

                if (Name.isEmpty() && Description.isEmpty() && Cost.isEmpty()) {
                    Toast.makeText(AddTreatment.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                mydDB.addNewTreatment(Name, Description, Cost, did);

                Toast.makeText(getBaseContext(), "Treatment has been added.", Toast.LENGTH_SHORT).show();
                // after adding the data we are displaying a toast message.

                tName.setText("");
                tDesc.setText("");
                tCost.setText("");

                //startActivity(new Intent(AddTreatment.this,DoctorHomeActivity.class));

            }
        });


        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AddTreatment.this,ViewMyTreatment.class);
                i.putExtra("did",did);
                startActivity(i);
                finish();
                //startActivity(new Intent(AddTreatment.this,ViewTreatment.class));
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inside this method we are calling an update course
                // method and passing all our edit text values.
                mydDB.updateTreatment(tName.getText().toString(), tDesc.getText().toString(), tCost.getText().toString());

                // displaying a toast message that our course has been updated.
                Toast.makeText(AddTreatment.this, "Treatment Updated..", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                //Intent i = new Intent(AddTreatment.this, MainActivity.class);
               // startActivity(i);
            }
        });


        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to delete our course.
                mydDB.deleteTreatment(tName.getText().toString());
                Toast.makeText(AddTreatment.this, "Deleted the Treatment", Toast.LENGTH_SHORT).show();
                //Intent i = new Intent(AddTreatment.this, MainActivity.class);
                //startActivity(i);
            }
        });



    }


    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
        Intent intent=new Intent(AddTreatment.this,DoctorHomeActivity.class);
        intent.putExtra("did",did);
        startActivity(intent);
        finish();
        //startActivity(new Intent(AddTreatment.this,DoctorHomeActivity.class));
    }





}