package com.example.shoepping.oldclass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Connection;

public class DBUserHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "login.db";

    public DBUserHelper(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = myDB.insert("users", null, contentValues);
        if (result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ?", new String[] {username});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ? and password = ?", new String [] {username, password});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    /*  private int checkDB(String username, String password) {

        CallableStatement stmt = null;
        int role = 0;
        String query = "{ call login(?, ?, ?) }";
        // Preparing a CallableStatement to call a procedure
        try {
            stmt = connection.prepareCall(query);
            //Setting the value for the IN parameters
            stmt.setString(1, username);
            stmt.setString(2, password);
            //Registering the type of the OUT parameter
            stmt.registerOutParameter(3, Types.INTEGER);
            //Executing the CallableStatement
            stmt.execute();

            //Retrieving the value for role
            role = stmt.getInt(3);
        }
        catch (SQLException e) {
            Log.e(SQL_EXCEPTION, e.getMessage());
        }
        finally {
            assert stmt != null;
            dbConnection.closeStatement((com.mysql.jdbc.CallableStatement) stmt);
        }

        return role;

    }*/
    public void Check(){
    Paolino paolino = new Paolino();
    Connection connection = paolino.getConnection();
    if (connection == null) {
        System.out.println("Errore");
    }
    else{
    System.out.println("connesso");
    }

    }

}

