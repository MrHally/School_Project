package com.example.quanlytaphoaver1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.DataFormatException;
import com.example.quanlytaphoaver1.MatHang;


public class DBManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "TapHoa_DB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "MatHang";
    private static final String ID_FIELD = "id";
    private static final String NAME_FIELD = "tenhang";
    private static final String CATALOG_FIELD = "theloai";
    private static final String PRICE_FIELD = "giatien";
    private Context context;
    private String SQL = "Create Table " + TABLE_NAME + " ("
            + ID_FIELD + " INTEGER PRIMARY KEY, "
            + NAME_FIELD + " TEXT, "
            + CATALOG_FIELD + " TEXT, "
            + PRICE_FIELD + " INTEGER)";
    public DBManager(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table If Exists " + TABLE_NAME + "");
    }

    public void addMHtoDB(MatHang mh){
        SQLiteDatabase db =  this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_FIELD, mh.getID());
        contentValues.put(NAME_FIELD, mh.getTenHang());
        contentValues.put(CATALOG_FIELD, mh.getTheLoai());
        contentValues.put(PRICE_FIELD, mh.getGiaTien());

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public void getMHfromDB(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor result = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (result.moveToFirst()) {
            do {
                int id = result.getInt(0);
                String tenhang = result.getString(1);
                String theloai = result.getString(2);
                int giatien = result.getInt(3);
                MatHang mh = new MatHang(id,tenhang,theloai,giatien);
                MatHang.ArrayList_MH.add(mh);
            } while (result.moveToNext());
        }
        db.close();
    }

    public void updateMH(MatHang mh){
        SQLiteDatabase db =  this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_FIELD, mh.getID());
        contentValues.put(NAME_FIELD, mh.getTenHang());
        contentValues.put(CATALOG_FIELD, mh.getTheLoai());
        contentValues.put(PRICE_FIELD, mh.getGiaTien());
        db.update(TABLE_NAME, contentValues, ID_FIELD + "= ?",new String[]{String.valueOf(mh.getID())});
    }

    public void deleteMH(MatHang mh){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID_FIELD + "= ?", new String[]{String.valueOf(mh.getID())});
    }
}

