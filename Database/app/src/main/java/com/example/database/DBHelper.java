package com.example.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context){
        super(context,"Login.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sakshi) {
        sakshi.execSQL("create table users(username text primary key,password text )");
    }
    @Override
    public void onUpgrade(SQLiteDatabase Mydb, int i, int i1) {
        Mydb.execSQL("drop table if exists users");
    }
    public Boolean checkusername(String user1){
        SQLiteDatabase Mydb=this.getWritableDatabase();
        Cursor cur = Mydb.rawQuery("select * from users where username=?",new String[]{user1});
        if(cur.getCount()>0)
            return true;
        else return false;
    }
    public Boolean inserdata(String user,String pass){
        SQLiteDatabase Mydb=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password",pass);
        long result=Mydb.insert("users",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
}
}
