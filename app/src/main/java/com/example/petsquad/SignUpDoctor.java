package com.example.petsquad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;



import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpDoctor extends AppCompatActivity {

    private EditText demail, dusername, dpassword, dage, dqualification, dexperience;
    private Button dsignUpButton;
    private DatabaseHelper mydDB;
    String Email, Username, Password, Age, Qualification, Experience ;
    Boolean CheckEditTextEmpty ;
    String SQLiteQuery;
    SQLiteDatabase SQLITEDATABASE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_doctor);

        demail=findViewById(R.id.signupdemail);
        dusername=findViewById(R.id.signupdname);
        dpassword=findViewById(R.id.signupdpssd);
        dage=findViewById(R.id.signupdage);
        dqualification=findViewById(R.id.signupdqualificaton);
        dexperience=findViewById(R.id.sigupdexp);
        dsignUpButton=findViewById(R.id.dsignupbutton);

        mydDB = new DatabaseHelper(this);
        insertDoctor();
        dsignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBCreate();

                SubmitData2SQLiteDB();



            }
        });

    }

    public void DBCreate(){

        SQLITEDATABASE = openOrCreateDatabase("USER_RECORD", Context.MODE_PRIVATE, null);

        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS doctor(did INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR, age VARCHAR, qualification VARCHAR, experience VARCHAR, email VARCHAR, password VARCHAR);");
    }

    public void SubmitData2SQLiteDB(){


        Username=dusername.getText().toString();
        Age=dage.getText().toString();
        Qualification=dqualification.getText().toString();
        Experience=dexperience.getText().toString();
        Email = demail.getText().toString();
        Password=dpassword.getText().toString();


        SQLITEDATABASE = openOrCreateDatabase("USER_RECORD", Context.MODE_PRIVATE, null);


        Cursor resultSet=mydDB.getReadableDatabase().rawQuery("SELECT * from doctor where name=?", new String[]{Username});
        resultSet.getCount();
        //String dusername = resultSet.getString(1);

        if( resultSet.getCount()!=0)
        {
            Toast.makeText(SignUpDoctor.this," Duplicate Record", Toast.LENGTH_LONG).show();;
        }
        else {


            SQLiteQuery = "INSERT INTO doctor (name,age,qualification,experience,email,password) VALUES('" + Username + "', '" + Age + "', '" + Qualification + "', '" + Experience + "', '" + Email + "', '" + Password + "');";

            SQLITEDATABASE.execSQL(SQLiteQuery);

            insertDoctor();

        }

//            startActivity(new Intent(SignUpDoctor.this , LoginActivity.class));


    }



    private void insertDoctor() {
        dsignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isAllFieldsChecked = false;
                isAllFieldsChecked = CheckAllFields();

                // the boolean variable turns to be true then
                // only the user must be proceed to the activity2
                if (isAllFieldsChecked) {
                    Toast.makeText(SignUpDoctor.this,"Data Submit Successfully", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(SignUpDoctor.this, LoginActivity.class);
                    startActivity(i);
                }


            }
        });
    }


    private boolean CheckAllFields() {
        String emaild = demail.getText().toString().trim();

        String demailPattern =  "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

       if (emaild.matches(demailPattern) == false ) {
           Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();

            return false;
        }

        if (demail.length() ==0)
        {
            Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
            return false;
        }

        if ( dusername.length()==0) {
            Toast.makeText(getApplicationContext(), "Sorry, you need to enter at least 5 characters in username", Toast.LENGTH_SHORT).show();

            dusername.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            return false;
        }

        if (dage.length() ==0 )
        {
            Toast.makeText(getApplicationContext(), "Invalid age", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (dqualification.length() ==0)
        {
            Toast.makeText(getApplicationContext(), "Invalid qualification", Toast.LENGTH_SHORT).show();
            dqualification.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            return false;
        }

        if (dexperience.length() ==0)
        {
            Toast.makeText(getApplicationContext(), "Invalid experience", Toast.LENGTH_SHORT).show();
            return false;
        }




        if (dpassword.length() ==0 ) {
            Toast.makeText(getApplicationContext(), "Sorry, you need to enter at least 5 characters in password", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;

    }


}