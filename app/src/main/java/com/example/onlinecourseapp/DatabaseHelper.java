package com.example.onlinecourseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME="OnlineCourseApp.db";
    public DatabaseHelper(Context context) {

        super(context, "OnlineCourseApp.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table teachers(id TEXT primary key ,password TEXT ,firstname TEXT,lastname TEXT)");
        db.execSQL("create table student(id TEXT primary key,password TEXT ,section TEXT,firstname TEXT,lastname TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists teachers");
        db.execSQL("drop Table if exists student");
    }
    public Boolean InsertData(String id,String password,String firstname,String lastname){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values=new ContentValues();


        values.put("id",id);
        values.put("password",password);
        values.put("firstname",firstname);
        values.put("lastname",lastname);

        long result=db.insert("teachers",null,values);
        if(result==-1) return false;
        else
            return true;
    }
    public Boolean checkId(String id){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from teachers where Id=?",new String[] {id});

        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkIdpassword(String id,String password){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from teachers where id=? and password=?",new String[] {id,password});

        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean InsertStudentData(String id,String password,String section,String firstname,String lastname){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put("id",id);
        values.put("password",password);
        values.put("section",section);
        values.put("firstname",firstname);
        values.put("lastname",lastname);

        long result=db.insert("student",null,values);
        if(result==-1) return false;
        else
            return true;
    }


    public Boolean checkIdpasswordStudent(String id,String password){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from student where id=? and password=?",new String[] {id,password});

        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkIdStudent(String id){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from student where Id=?",new String[] {id});

        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Cursor ViewData6c1(){

        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from student where section='6c1'" ,null);

        return cursor;
    }

    public Cursor ViewData6c2(){

        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from student where section='6c2'" ,null);

        return cursor;
    }


    public Cursor ViewData6c3(){

        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from student where section='6c3'" ,null);

        return cursor;
    }


}