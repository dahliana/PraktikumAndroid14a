package com.dahliana.kasapp14.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Sqlitehelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "uangkas";
    private static final int DATABASE_VERSION = 1 ;

    public Sqlitehelper( Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table = "CREATE TABLE transaksi (" +
                "transaksi_id INTERGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "jumlah DOUBLE," +
                "keterangan TEXT," +
                "tanggal DATE DEFAULT CURRENT_DATE)";

        db.execSQL(table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS transaksi");

    }
}
