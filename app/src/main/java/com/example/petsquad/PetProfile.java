package com.example.petsquad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PetProfile extends AppCompatActivity {

    private EditText pname, page, pheight, pweight, pbreed;
    private Button psave;
    private DatabaseHelper mydDB;
    String Name, Age, Height, Weight, Breed;
    Boolean CheckEditTextEmpty ;
    String SQLiteQuery;
    SQLiteDatabase SQLITEDATABASE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_profile);
        pname=findViewById(R.id.petname);
        page=findViewById(R.id.petage);
        pheight=findViewById(R.id.petheight);
        pweight=findViewById(R.id.petweight);
        pbreed=findViewById(R.id.petbreed);
        psave=findViewById(R.id.petsave);

        mydDB = new DatabaseHelper(this);
        insertPet();

        psave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBCreate();

                SubmitData2SQLiteDB();
            }
        });
    }

    public void DBCreate(){

        SQLITEDATABASE = openOrCreateDatabase("USER_RECORD", Context.MODE_PRIVATE, null);

        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS pet(pid INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR, age VARCHAR, height VARCHAR, weight VARCHAR, breed VARCHAR);");
    }

    public void SubmitData2SQLiteDB() {


        Name = pname.getText().toString();
        Age = page.getText().toString();
        Height = pheight.getText().toString();
        Weight = pweight.getText().toString();
        Breed = pbreed.getText().toString();

        SQLiteQuery = "INSERT INTO pet (name,age,height,weight,breed) VALUES('" + Name + "', '" + Age + "', '" + Height + "', '" + Weight + "', '" + Breed + "');";

        SQLITEDATABASE.execSQL(SQLiteQuery);

        insertPet();

    }

    private void insertPet() {
        psave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isAllFieldsChecked = false;
                isAllFieldsChecked = CheckAllFields();

                // the boolean variable turns to be true then
                // only the user must be proceed to the activity2
                if (isAllFieldsChecked) {
                    Toast.makeText(PetProfile.this,"Data Submit Successfully", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(PetProfile.this, HomeActivity.class);
                    startActivity(i);
                }


            }
        });
    }

    private boolean CheckAllFields() {


        if ( pname.length()==0) {
            Toast.makeText(getApplicationContext(), "Sorry, you need to enter at least 5 characters in name", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (page.length() ==0 )
        {
            Toast.makeText(getApplicationContext(), "Invalid age", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (pheight.length() ==0)
        {
            Toast.makeText(getApplicationContext(), "Invalid Height", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (pweight.length() ==0)
        {
            Toast.makeText(getApplicationContext(), "Invalid Weight", Toast.LENGTH_SHORT).show();
            return false;
        }




        if (pbreed.length() ==0 ) {
            Toast.makeText(getApplicationContext(), " Invalid Breed", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;

    }


}
