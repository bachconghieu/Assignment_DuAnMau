package com.example.assignment_duanmau.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.assignment_duanmau.dao.HoaDonChiTietDAO;
import com.example.assignment_duanmau.dao.HoaDonDAO;
import com.example.assignment_duanmau.dao.NguoiDungDAO;
import com.example.assignment_duanmau.dao.SachDAO;
import com.example.assignment_duanmau.dao.TheLoaiDAO;
import com.example.assignment_duanmau.model.HoaDon;
import com.example.assignment_duanmau.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "dbBookManager";
    public static final int VERSION = 1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NguoiDungDAO.SQL_NGUOI_DUNG);
        db.execSQL(TheLoaiDAO.SQL_THE_LOAI);
        db.execSQL(SachDAO.SQL_SACH);
        db.execSQL(HoaDonDAO.SQL_HOA_DON);
        db.execSQL(HoaDonChiTietDAO.SQL_HOA_DON_CHI_TIET);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists "+NguoiDungDAO.TABLE_NAME);
        db.execSQL("Drop table if exists "+TheLoaiDAO.TABLE_NAME);
        db.execSQL("Drop table if exists "+SachDAO.TABLE_NAME);
        db.execSQL("Drop table if exists "+HoaDonDAO.TABLE_NAME);
        db.execSQL("Drop table if exists "+HoaDonChiTietDAO.TABLE_NAME);

        onCreate(db);
    }

}
