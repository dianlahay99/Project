package com.dianlahay.kampuspintar;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.dianlahay.kampuspintar.model.UniversitasModel;


import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "UniversitasDB";
    private static final String T_UNIVERSITAS = "tb_universitas";

    private static final String KEY_ID = "id_universitas";
    private static final String KEY_NAMA = "nama_universitas";
    private static final String KEY_AKREDITAS = "akreditas";
    private static final String KEY_STATUS = "status";
    private static final String KEY_LOGO = "logo";

    private static final String TABLE_ALAMAT = "alamat";
    private static final String KEY_IDA = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_IMAGE = "image";

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        tes(db);
        alamat(db);

    }

    public void tes (SQLiteDatabase db){
        String query = "CREATE TABLE " + T_UNIVERSITAS + " (" +
                KEY_ID + " INTEGER PRIMARY KEY, " +
                KEY_NAMA + " TEXT, " +
                KEY_AKREDITAS + " TEXT, " +
                KEY_STATUS + " TEXT" +")";
        Log.d("Data", "onCreate: " + query);
        db.execSQL(query);

        query = "insert into tb_universitas values(1,'Universitas Gajah Mada','Akreditas A','Negeri')";
        db.execSQL(query);
        query = "insert into tb_universitas values(2,'Institut Pertanian Bogor','Akreditas B','Negeri')";
        db.execSQL(query);
        query = "insert into tb_universitas values(3,'Universitas Indonesia','Akreditas A','Negeri')";
        db.execSQL(query);
        query = "insert into tb_universitas values(4,'Institut Teknologi Sepuluh Nopember','Akreditas A','Swasta')";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion >= newVersion)
            return;
        db.execSQL("DROP TABLE IF EXISTS " + T_UNIVERSITAS);

        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALAMAT);

        onCreate(db);
    }


    public List<UniversitasModel> getUniv() {
        List<UniversitasModel> univList = new ArrayList<>();
        String query = "SELECT * FROM " + T_UNIVERSITAS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String nama = cursor.getString(1);
                String akreditas = cursor.getString(2);
                String status = cursor.getString(3);

                UniversitasModel universitasModel = new UniversitasModel(id, nama, akreditas, status);

                univList.add(universitasModel);
            } while (cursor.moveToNext());
        }

        return univList;
    }




    public void alamat (SQLiteDatabase db){
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_ALAMAT + "("
                + KEY_IDA + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_IMAGE + " BLOB" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

}
