package com.example.petsquad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText loginUsername , loginPassword;
    private Button loginButton;
    private Spinner spinner;
    private DatabaseHelper myDb;
    SQLiteDatabase SQLITEDATABASE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView txtSignIn=findViewById(R.id.txtSingIn);
        loginUsername = findViewById(R.id.loginusername);
        loginPassword = findViewById(R.id.loginpassword);
        loginButton = findViewById(R.id.loginbutton);
        spinner=findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this , R.array.usertype, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        myDb = new DatabaseHelper(this);

        loginUser();


        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });

    }
    private void loginUser(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item=spinner.getSelectedItem().toString();
                if(item.equals("Owner"))
                {

                    boolean var = myDb.checkUser(loginUsername.getText().toString(), loginPassword.getText().toString());
                    if (var) {
                        Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                        String testuser=loginUsername.getText().toString();
                        Cursor resultSet=myDb.getReadableDatabase().rawQuery("SELECT ID from USER_DATA where USERNAME=?",new String[]{testuser},null);
                        resultSet.moveToFirst();
                        Integer ownerid=resultSet.getInt(0);

                        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                        i.putExtra("key",loginUsername.getText().toString());
                        i.putExtra("username",loginUsername.getText().toString());
                        i.putExtra("ID",ownerid);
                        startActivity(i);
                        //startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Login Failed !!", Toast.LENGTH_SHORT).show();
                    }
                }
                if (item.equals("Doctor"))
                {

                    SQLITEDATABASE = openOrCreateDatabase("USER_RECORD", Context.MODE_PRIVATE, null);
                    String testuser=loginUsername.getText().toString();
                    String testpass=loginPassword.getText().toString();
                    Cursor resultSet=myDb.getReadableDatabase().rawQuery("SELECT did,name,password from doctor where name=?",new String[]{testuser},null);
                    resultSet.moveToFirst();


                    if(resultSet.getCount()!=0)
                    {
                        Integer doctorid=resultSet.getInt(0);
                        String dusername = resultSet.getString(1);
                        String dpassword = resultSet.getString(2);
                        if(dusername.equals(testuser) && dpassword.equals(testpass))
                        {
                            Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                            // startActivity(new Intent(LoginActivity.this, DoctorHomeActivity.class));
                            Intent intent = new Intent(getApplicationContext(), DoctorHomeActivity.class);
                            intent.putExtra("did",doctorid);
                            startActivity(intent);
                            finish();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Login Failed !!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Login Failed !!", Toast.LENGTH_SHORT).show();
                    }

                }

                /*if (item.equals("Shop"))
                {

                    SQLITEDATABASE = openOrCreateDatabase("USER_RECORD", Context.MODE_PRIVATE, null);
                    String testuser=loginUsername.getText().toString();
                    String testpass=loginPassword.getText().toString();
                    Cursor resultSet=myDb.getReadableDatabase().rawQuery("SELECT shid,name,password from shop where name=?",new String[]{testuser},null);
                    resultSet.moveToFirst();
                    if(resultSet.getCount() != 0)
                    {
                        Integer shid=resultSet.getInt(0);
                        String dusername = resultSet.getString(1);
                        String dpassword = resultSet.getString(2);

                        if(dusername.equals(testuser) && dpassword.equals(testpass))
                        {
                            Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(getApplicationContext(), ShopHomeActivity.class);
                            intent.putExtra("shid",shid);
                            intent.putExtra("shopName",testuser);
                            startActivity(intent);
                            finish();

                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Login Failed !!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Login Failed !!", Toast.LENGTH_SHORT).show();
                    }




                }*/

                if(item.equals("Admin"))
                {
                    SQLITEDATABASE = openOrCreateDatabase("USER_RECORD", Context.MODE_PRIVATE, null);
                    String testuser=loginUsername.getText().toString();
                    String testpass=loginPassword.getText().toString();

                    String dusername = "admin";
                    String dpassword = "admin123";


                    if(dusername.equals(testuser) && dpassword.equals(testpass))
                    {
                        Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(), AdminHomeActivity.class);
                        startActivity(intent);
                        finish();

                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Login Failed !!", Toast.LENGTH_SHORT).show();
                    }

                }

            }


        });
    }
}