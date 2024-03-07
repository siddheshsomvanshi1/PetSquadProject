package com.example.petsquad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ManagePetProfile extends AppCompatActivity {

    private DatabaseHelper mydDB;
    String Name, Age, Height, Weight, Breed ;
    Integer ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_pet_profile);

        Intent intent = getIntent();


        ID = intent.getIntExtra("ID",0);

        EditText petName=findViewById(R.id.petName);
        EditText petAge=findViewById(R.id.petAge);
        EditText petHeight=findViewById(R.id.petHeight);
        EditText petWeight=findViewById(R.id.petWeight);
        EditText petBreed=findViewById(R.id.petBreed);
        Button addPet=findViewById(R.id.addPet);
        Button readPet=findViewById(R.id.readPet);
        Button updatePet=findViewById(R.id.updatePet);
        Button deletePet=findViewById(R.id.deletePet);

        mydDB = new DatabaseHelper(this);

        addPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name=petName.getText().toString();
                Age=petAge.getText().toString();
                Height=petHeight.getText().toString();
                Weight=petWeight.getText().toString();
                Breed=petBreed.getText().toString();

                if (Name.isEmpty() && Age.isEmpty() && Height.isEmpty() && Weight.isEmpty() && Breed.isEmpty()) {
                    Toast.makeText(ManagePetProfile.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                mydDB.addNewPet(Name, Age, Height,Weight,Breed,ID);

                Toast.makeText(getBaseContext(), "Pet has been added.", Toast.LENGTH_SHORT).show();
                // after adding the data we are displaying a toast message.

                petName.setText("");
                petAge.setText("");
                petHeight.setText("");
                petWeight.setText("");
                petBreed.setText("");



            }
        });

        readPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ViewMyPetProfile.class);
                intent.putExtra("ID",ID);
                startActivity(intent);
                finish();
                //startActivity(new Intent(ManageProduct.this,ViewMyProduct.class));
            }
        });

        updatePet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inside this method we are calling an update course
                // method and passing all our edit text values.
                mydDB.updatePet(petName.getText().toString(), petAge.getText().toString(), petHeight.getText().toString(), petWeight.getText().toString(), petBreed.getText().toString());

                // displaying a toast message that our course has been updated.
                Toast.makeText(ManagePetProfile.this, "Pet Updated..", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                //Intent i = new Intent(AddTreatment.this, MainActivity.class);
                // startActivity(i);
            }
        });

        deletePet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to delete our course.
                mydDB.deletePet(petName.getText().toString());
                Toast.makeText(ManagePetProfile.this, "Deleted the Pet", Toast.LENGTH_SHORT).show();
                //Intent i = new Intent(AddTreatment.this, MainActivity.class);
                //startActivity(i);
            }
        });


    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
        Intent intent=new Intent(ManagePetProfile.this,HomeActivity.class);
        intent.putExtra("ID",ID);
        startActivity(intent);
        finish();
       // startActivity(new Intent(ManagePetProfile.this,HomeActivity.class));
      //  finish();


    }
}