package com.example.petsquad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "USER_RECORD";
    private static final String TABLE_NAME = "USER_DATA";
        private static final String COL_1 = "ID";
    private static final String COL_2 = "USERNAME";
    private static final String COL_3 = "EMAIL";
    private static final String COL_4 = "PASSWORD";

    private static final int DB_VERSION = 1;


    private static final String TABLE_NAME1 = "treatment";

    private static final String ID_COL = "trid";

    private static final String NAME_COL = "name";

    private static final String DESCRIPTION_COL = "description";

    private static final String COST_COL = "cost";

    private static final String DOC_ID="did";


    private static final String TABLE_NAME2 = "product";

    private static final String PID_COL = "pid";

    private static final String PNAME_COL = "pname";

    private static final String PDESCRIPTION_COL = "pdescription";

    private static final String PCOST_COL = "pcost";

    private static final String PSHID_COL = "shid";


    private static final String TABLE_NAME3 = "doctorschedule";

    private static final String DSID_COL = "dsid";

    private static final String DSDAY_COL = "day";

    private static final String OPENTIME_COL = "opentime";

    private static final String CLOSETIME_COL = "closetime";

    private static final String DSDOC_ID="did";



    private static final String TABLE_NAME6 = "doctorappointment";

    private static final String DAID_COL = "daid";

    private static final String DADID_COL = "did";

    private static final String DADATE_COL = "date";

    private static final String DATIME_COL = "time";

    private static final String DAUID_ID="ID";

    private static final String DAPETNAME_ID="name";




    private static final String TABLE_NAME7 = "productcart";

    private static final String PCID_COL = "pcid";

    private static final String U_ID="ID";

    private static final String PPCID_COL = "pname";

    private static final String QTY_COL = "quantity";

    private static final String SHPCID_COL = "name";





    private static final String TABLE_NAME8 = "petprofile";

    private static final String PPID_COL = "petid";

   private static final String PETNAME_COL = "name";

    private static final String PETAGE = "age";

    private static final String PETHEIGHT = "height";

    private static final String PETWEIGHT = "weight";

    private static final String PETBREED = "breed";

    private static final String PPU_ID="ID";


    private static final String TABLE_NAME9 = "event";

    private static final String EID_COL = "eid";

    private static final String ENAME_COL = "name";

    private static final String EDESC = "description";

    private static final String EDATE = "date";

    private static final String EVENUE = "venue";

    private static final String ETIME = "time";


    private static final String TABLE_NAME10 = "post";

    private static final String POID_COL = "poid";

    private static final String PONAME_COL = "name";

    private static final String PODESC = "description";




    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME , null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME10+ "(poid INTEGER PRIMARY KEY AUTOINCREMENT , name TEXT ,description TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME9+ "(eid INTEGER PRIMARY KEY AUTOINCREMENT , name TEXT ,description TEXT, date TEXT , venue TEXT , time TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME8+ "(petid INTEGER PRIMARY KEY AUTOINCREMENT , name TEXT ,age TEXT, height TEXT , weight TEXT , breed TEXT, ID INTEGER)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME7 + "(pcid INTEGER PRIMARY KEY AUTOINCREMENT , ID INTEGER , pname TEXT , quantity TEXT , name TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME6 + "(daid INTEGER PRIMARY KEY AUTOINCREMENT , did INTEGER , date TEXT , time TEXT , ID INTEGER,name TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME3 + "(dsid INTEGER PRIMARY KEY AUTOINCREMENT , day TEXT , opentime TEXT , closetime TEXT , did INTEGER)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME2 + "(pid INTEGER PRIMARY KEY AUTOINCREMENT , pname TEXT , pdescription TEXT , pcost TEXT, shid INTEGER )");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME1 + "(trid INTEGER PRIMARY KEY AUTOINCREMENT , name TEXT , description TEXT , cost TEXT , did INTEGER)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , USERNAME TEXT , EMAIL TEXT , PASSWORD TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME1);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME3);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME6);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME7);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME8);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME9);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME10);
        onCreate(db);
    }

    public boolean registerUser(String username , String email , String password){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2 , username);
        values.put(COL_3 , email);
        values.put(COL_4 , password);

        long result = db.insert(TABLE_NAME , null , values);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean checkUser(String username , String password){

        SQLiteDatabase db = this.getWritableDatabase();
        String [] columns = { COL_1 };
        String selection = COL_2 + "=?" + " and " + COL_4 + "=?";
        String [] selectionargs = { username , password};
        Cursor cursor = db.query(TABLE_NAME , columns , selection ,selectionargs , null , null , null);
        int count = cursor.getCount();
        db.close();
        cursor.close();
        if (count > 0)
            return true;
        else
            return false;

    }

    public void addNewTreatment(String treatmentName, String treatmentDescription, String treatmentCost, Integer did) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.


        SQLiteDatabase db = this.getWritableDatabase();


        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, treatmentName);
        values.put(DESCRIPTION_COL, treatmentDescription);
        values.put(COST_COL, treatmentCost);
        values.put(DOC_ID,did);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME1, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public ArrayList<TreatmentModal> readTreatments() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorTreatment = db.rawQuery("SELECT * FROM " + TABLE_NAME1, null);

        // on below line we are creating a new array list.
        ArrayList<TreatmentModal> TreatmentModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorTreatment.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                TreatmentModalArrayList.add(new TreatmentModal(cursorTreatment.getString(1),
                        cursorTreatment.getString(2),
                        cursorTreatment.getString(3)));
            } while (cursorTreatment.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorTreatment.close();
        return TreatmentModalArrayList;
    }

    public ArrayList<TreatmentModal> readmyTreatments(Integer did) {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorTreatment = db.rawQuery("SELECT * FROM treatment where did=?" , new String[]{String.valueOf(did)});

        // on below line we are creating a new array list.
        ArrayList<TreatmentModal> TreatmentModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorTreatment.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                TreatmentModalArrayList.add(new TreatmentModal(cursorTreatment.getString(1),
                        cursorTreatment.getString(2),
                        cursorTreatment.getString(3)));
            } while (cursorTreatment.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorTreatment.close();
        return TreatmentModalArrayList;
    }

    public void updateTreatment( String treatmentName, String treatmentDescription,
                                 String treatmentCost) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, treatmentName);
        values.put(DESCRIPTION_COL, treatmentDescription);
        values.put(COST_COL, treatmentCost);

        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(TABLE_NAME1, values, "name=?", new String[]{treatmentName});
        db.close();
    }

    // below is the method for deleting our course.
    public void deleteTreatment(String courseName) {

        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        db.delete(TABLE_NAME1 , "name=?", new String[]{courseName});
        db.close();
    }


    public void addNewProduct(String productName, String productDescription, String productCost,Integer shid) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(PNAME_COL, productName);
        values.put(PDESCRIPTION_COL, productDescription);
        values.put(PCOST_COL, productCost);
        values.put(PSHID_COL,shid);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME2, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public ArrayList<ProductModal> readProducts() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorProduct = db.rawQuery("SELECT * FROM " + TABLE_NAME2, null);

        // on below line we are creating a new array list.
        ArrayList<ProductModal> ProductModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorProduct.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                ProductModalArrayList.add(new ProductModal(cursorProduct.getString(1),
                        cursorProduct.getString(2),
                        cursorProduct.getString(3)));
            } while (cursorProduct.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorProduct.close();

        return ProductModalArrayList;
    }

    public ArrayList<ProductModal> readmyProducts(Integer shid) {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorProduct = db.rawQuery("SELECT * FROM product where shid=?", new String[]{String.valueOf(shid)});

        // on below line we are creating a new array list.
        ArrayList<ProductModal> ProductModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorProduct.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                ProductModalArrayList.add(new ProductModal(cursorProduct.getString(1),
                        cursorProduct.getString(2),
                        cursorProduct.getString(3)));
            } while (cursorProduct.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorProduct.close();
        return ProductModalArrayList;
    }

    public void updateProduct( String productName, String productDescription, String productCost) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(PNAME_COL, productName);
        values.put(PDESCRIPTION_COL, productDescription);
        values.put(PCOST_COL, productCost);

        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(TABLE_NAME2, values, "pname=?", new String[]{productName});
        db.close();
    }

    // below is the method for deleting our course.
    public void deleteProduct(String productName) {

        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        db.delete(TABLE_NAME2 , "pname=?", new String[]{productName});
        db.close();
    }


    public ArrayList<DoctorModal> readDoctors() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorDoctor = db.rawQuery("SELECT * FROM doctor", null);

        // on below line we are creating a new array list.
        ArrayList<DoctorModal> DoctorModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorDoctor.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                DoctorModalArrayList.add(new DoctorModal(cursorDoctor.getString(1),
                        cursorDoctor.getString(2),
                        cursorDoctor.getString(4)));
            } while (cursorDoctor.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorDoctor.close();
        return DoctorModalArrayList;
    }

    public Cursor ViewDoctors(){
        SQLiteDatabase db=this.getReadableDatabase();
        String query="Select name from doctor";
        Cursor cursor=db.rawQuery(query,null);
        return cursor;
    }

    public void addNewScehdule(String day, String opentime, String closetime, Integer did) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.


        SQLiteDatabase db = this.getWritableDatabase();


        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(DSDAY_COL, day);
        values.put(OPENTIME_COL, opentime);
        values.put(CLOSETIME_COL, closetime);
        values.put(DOC_ID,did);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME3, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public ArrayList<DoctorScheduleModal> readDoctorSchedule() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursordoctorSchedule = db.rawQuery("SELECT * FROM " + TABLE_NAME3, null);

        // on below line we are creating a new array list.
        ArrayList<DoctorScheduleModal> DoctorScheduleModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursordoctorSchedule.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                DoctorScheduleModalArrayList.add(new DoctorScheduleModal(cursordoctorSchedule.getString(1),
                        cursordoctorSchedule.getString(2),
                        cursordoctorSchedule.getString(3)));
            } while (cursordoctorSchedule.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursordoctorSchedule.close();
        return DoctorScheduleModalArrayList;
    }

    public ArrayList<DoctorScheduleModal> readmyDoctorSchedule(Integer did) {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursordoctorSchedule = db.rawQuery("SELECT * FROM doctorschedule where did=?", new String[]{String.valueOf(did)});

        // on below line we are creating a new array list.
        ArrayList<DoctorScheduleModal> DoctorScheduleModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursordoctorSchedule.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                DoctorScheduleModalArrayList.add(new DoctorScheduleModal(cursordoctorSchedule.getString(1),
                        cursordoctorSchedule.getString(2),
                        cursordoctorSchedule.getString(3)));
            } while (cursordoctorSchedule.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursordoctorSchedule.close();
        return DoctorScheduleModalArrayList;
    }

    public void updateDoctorSchedule( String day, String opentime, String closetime) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(DSDAY_COL, day);
        values.put(OPENTIME_COL, opentime);
        values.put(CLOSETIME_COL, closetime);

        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(TABLE_NAME3, values, "day=?", new String[]{day});
        db.close();
    }

    // below is the method for deleting our course.
    public void deleteDoctorSchedule(String day) {

        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        db.delete(TABLE_NAME3 , "day=?", new String[]{day});
        db.close();
    }





    public void addNewDoctorAppointment(Integer did,String date, String time, Integer ID, String name) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.


        SQLiteDatabase db = this.getWritableDatabase();


        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(DADID_COL, did);
        values.put(DADATE_COL, date);
        values.put(DATIME_COL, time);
        values.put(DAUID_ID,ID);
        values.put(DAPETNAME_ID,name);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME6, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public ArrayList<DoctorAppointmentModal> readDoctorAppointments() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursordoctorAppointment = db.rawQuery("SELECT * FROM " + TABLE_NAME6, null);

        // on below line we are creating a new array list.
        ArrayList<DoctorAppointmentModal> doctorAppointmentModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursordoctorAppointment.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                doctorAppointmentModalArrayList.add(new DoctorAppointmentModal(cursordoctorAppointment.getString(2),
                        cursordoctorAppointment.getString(3),
                        cursordoctorAppointment.getString(5)));
            } while (cursordoctorAppointment.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursordoctorAppointment.close();
        return doctorAppointmentModalArrayList;
    }

    public ArrayList<DoctorAppointmentModal> readmyDoctorAppointments(Integer did) {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursordoctorAppointment = db.rawQuery("SELECT * FROM doctorappointment where did=?" , new String[]{String.valueOf(did)});

        // on below line we are creating a new array list.
        ArrayList<DoctorAppointmentModal> doctorAppointmentModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursordoctorAppointment.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                doctorAppointmentModalArrayList.add(new DoctorAppointmentModal(cursordoctorAppointment.getString(2),
                        cursordoctorAppointment.getString(3),
                        cursordoctorAppointment.getString(5)));
            } while (cursordoctorAppointment.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursordoctorAppointment.close();
        return doctorAppointmentModalArrayList;
    }

    public ArrayList<DoctorAppointmentModal> readcuDoctorAppointments(Integer ownerid) {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursordoctorAppointment = db.rawQuery("SELECT * FROM doctorappointment where ID=?" , new String[]{String.valueOf(ownerid)});

        // on below line we are creating a new array list.
        ArrayList<DoctorAppointmentModal> doctorAppointmentModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursordoctorAppointment.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                doctorAppointmentModalArrayList.add(new DoctorAppointmentModal(cursordoctorAppointment.getString(2),
                        cursordoctorAppointment.getString(3),
                        cursordoctorAppointment.getString(5)
                ));
            } while (cursordoctorAppointment.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursordoctorAppointment.close();
        return doctorAppointmentModalArrayList;
    }



    public ArrayList<ShopModal> readShops() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorShop = db.rawQuery("SELECT * FROM shop", null);

        // on below line we are creating a new array list.
        ArrayList<ShopModal> shopModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorShop.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                shopModalArrayList.add(new ShopModal(cursorShop.getString(1),
                        cursorShop.getString(2),
                        cursorShop.getString(3)));
            } while (cursorShop.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorShop.close();
        return shopModalArrayList;
    }




    public void addNewProductCart(Integer ID,String pname, String quantity, String name) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        /*
         private static final String PCID_COL = "pcid";

    private static final String U_ID="ID";

    private static final String PPCID_COL = "pid";

    private static final String QTY_COL = "quantity";

    private static final String SHPCID_COL = "shid";

         */


        SQLiteDatabase db = this.getWritableDatabase();


        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(U_ID, ID);
        values.put(PPCID_COL, pname);
        values.put(QTY_COL, quantity);
        values.put(SHPCID_COL,name);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME7, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public ArrayList<ProductCartModal> readProductsCart() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorproductCart = db.rawQuery("SELECT * FROM " + TABLE_NAME7, null);

        // on below line we are creating a new array list.
        ArrayList<ProductCartModal> ProductCartModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorproductCart.moveToFirst()) {
            do {

                // on below line we are adding the data from cursor to our array list.
                ProductCartModalArrayList.add(new ProductCartModal(cursorproductCart.getString(2),
                        cursorproductCart.getString(3),
                        cursorproductCart.getString(4)));
            } while (cursorproductCart.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorproductCart.close();
        return ProductCartModalArrayList;
    }


    public ArrayList<ProductCartModal> readshProductsCart(String shopName) {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorproductCart = db.rawQuery("SELECT * FROM productcart where name=?" , new String[]{shopName});

        // on below line we are creating a new array list.
        ArrayList<ProductCartModal> ProductCartModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorproductCart.moveToFirst()) {
            do {

                // on below line we are adding the data from cursor to our array list.
                ProductCartModalArrayList.add(new ProductCartModal(cursorproductCart.getString(2),
                        cursorproductCart.getString(3),
                        cursorproductCart.getString(4)));
            } while (cursorproductCart.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorproductCart.close();
        return ProductCartModalArrayList;
    }

    public ArrayList<ProductCartModal> readcuProductsCart(Integer ownerid) {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorproductCart = db.rawQuery("SELECT * FROM productcart where ID=?" , new String[]{String.valueOf(ownerid)});

        // on below line we are creating a new array list.
        ArrayList<ProductCartModal> ProductCartModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorproductCart.moveToFirst()) {
            do {

                // on below line we are adding the data from cursor to our array list.
                ProductCartModalArrayList.add(new ProductCartModal(cursorproductCart.getString(2),
                        cursorproductCart.getString(3),
                        cursorproductCart.getString(4)));
            } while (cursorproductCart.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorproductCart.close();
        return ProductCartModalArrayList;
    }


    public void addNewPet(String name, String age, String height, String weight, String breed, Integer ID) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.


        SQLiteDatabase db = this.getWritableDatabase();


        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(PETNAME_COL, name);
        values.put(PETAGE,age);
        values.put(PETHEIGHT, height);
        values.put(PETWEIGHT, weight);
        values.put(PETBREED,breed);
        values.put(PPU_ID,ID);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME8, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public ArrayList<PetProfileModal> readPets() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorPet = db.rawQuery("SELECT * FROM " + TABLE_NAME8, null);

        // on below line we are creating a new array list.
        ArrayList<PetProfileModal> PetModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorPet.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                PetModalArrayList.add(new PetProfileModal(cursorPet.getString(1),
                        cursorPet.getString(2),
                        cursorPet.getString(5)));
            } while (cursorPet.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorPet.close();
        return PetModalArrayList;
    }

    public ArrayList<PetProfileModal> readmyPets(Integer ID) {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorPet = db.rawQuery("SELECT * FROM petprofile where ID=?" , new String[]{String.valueOf(ID)});

        // on below line we are creating a new array list.
        ArrayList<PetProfileModal> PetModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorPet.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                PetModalArrayList.add(new PetProfileModal(cursorPet.getString(1),
                        cursorPet.getString(2),
                        cursorPet.getString(5)));
            } while (cursorPet.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorPet.close();
        return PetModalArrayList;
    }

    public void updatePet( String name, String age, String height, String weight, String breed) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(PETNAME_COL, name);
        values.put(PETAGE, age);
        values.put(PETHEIGHT, height);
        values.put(PETWEIGHT, weight);
        values.put(PETBREED, breed);

        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(TABLE_NAME8, values, "name=?", new String[]{name});
        db.close();
    }

    // below is the method for deleting our course.
    public void deletePet(String name) {

        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        db.delete(TABLE_NAME8 , "name=?", new String[]{name});
        db.close();
    }

    public ArrayList<OwnerModal> readOwners() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorOwner = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<OwnerModal> OwnerModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorOwner.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                OwnerModalArrayList.add(new OwnerModal(cursorOwner.getString(1),
                        cursorOwner.getString(2)));
            } while (cursorOwner.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorOwner.close();
        return OwnerModalArrayList;
    }


    public void addNewEvent(String name, String description, String date,String venue,String time) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(ENAME_COL, name);
        values.put(EDESC, description);
        values.put(EDATE, date);
        values.put(EVENUE,venue);
        values.put(ETIME,time);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME9, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public ArrayList<EventModal> readEvents() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorevent = db.rawQuery("SELECT * FROM " + TABLE_NAME9, null);

        // on below line we are creating a new array list.
        ArrayList<EventModal> eventModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorevent.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                eventModalArrayList.add(new EventModal(cursorevent.getString(1),
                        cursorevent.getString(3),
                        cursorevent.getString(4),
                        cursorevent.getString(5)));
            } while (cursorevent.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorevent.close();
        return eventModalArrayList;
    }

    public void updateEvent( String name, String description, String date,String venue,String time) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(ENAME_COL, name);
        values.put(EDESC, description);
        values.put(EDATE, date);
        values.put(EVENUE, venue);
        values.put(ETIME, time);

        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(TABLE_NAME9, values, "name=?", new String[]{name});
        db.close();
    }

    // below is the method for deleting our course.
    public void deleteEvent(String name) {

        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        db.delete(TABLE_NAME9 , "name=?", new String[]{name});
        db.close();
    }


    public void addNewPost(String name, String description) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(PONAME_COL, name);
        values.put(PODESC, description);


        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME10, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public ArrayList<PostModal> readPosts() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorpost = db.rawQuery("SELECT * FROM " + TABLE_NAME10, null);

        // on below line we are creating a new array list.
        ArrayList<PostModal> postModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorpost.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                postModalArrayList.add(new PostModal(cursorpost.getString(1),
                        cursorpost.getString(2)));
            } while (cursorpost.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorpost.close();
        return postModalArrayList;
    }

    public void updatePost( String name, String description) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(PONAME_COL, name);
        values.put(PODESC, description);


        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(TABLE_NAME10, values, "name=?", new String[]{name});
        db.close();
    }

    // below is the method for deleting our course.
    public void deletePost(String name) {

        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        db.delete(TABLE_NAME10 , "name=?", new String[]{name});
        db.close();
    }



}
