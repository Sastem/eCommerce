package com.doranco.ecommerceapp.bd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.doranco.ecommerceapp.models.Gateau;

import java.util.ArrayList;
import java.util.List;

public class TableGateau extends MyDataBase {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "GateauDataBase";
    private static final String TABLE_GATEAU = "Gateau";
    private static final String COLUMN_GATEAU_ID = "Id";
    private static final String COLUMN_GATEAU_TYPE = "Type";
    private static final String COLUMN_GATEAU_NOM= "GateauNom";
    private static final String COLUMN_GATEAU_PRIX= "GateauPrix";
    private static final String COLUMN_GATEAU_STOCK = "GateauStock";




}
    @Override
    public void onCreate(MyDataBase gateauDatabase) {
        String script = "CREATE TABLE " + TABLE_GATEAU+ "("
                + COLUMN_GATEAU_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_GATEAU_TYPE = "TEXT,"
                + COLUMN_GATEAU_NOM + " TEXT,"
                + COLUMN_GATEAU_PRIX + " TEXT,"
                + COLUMN_GATEAU_STOCK + " INTEGER"
                +  ")";
        // Execute Script.
        gateauDatabas.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // Drop older table if existed
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_GATEAU);

        // Create tables again
        onCreate(gateauDatabase);
    }

    public void addGateau(Gateau gateau) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_GATEAU_TYPE, gateau.getType());
        values.put(COLUMN_GATEAU_NOM, gateau.getNom());
        values.put(COLUMN_GATEAU_PRIX, gateau.getPrix());
        values.put(COLUMN_GATEAU_STOCK, gateau.getStock());

        // Inserting Row
        db.insert(TABLE_GATEAU, null, values);

        // Closing database connection
        db.close();
    }

    public Gateau getGateau(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        String Columns[] = { COLUMN_GATEAU_ID, COLUMN_GATEAU_TYPE, COLUMN_GATEAU_NOM, COLUMN_GATEAU_PRIX, COLUMN_GATEAU_STOCK};

        Cursor cursor = db.query(TABLE_GATEAU, Columns, COLUMN_GATEAU_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Gateau gateau = new Gateau(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getDouble(3),cursor.getDouble(4));

        return gateau;
    }

    public List<Gateau> getAllGateaus() {

        List<Gateau> gateauList = new ArrayList<Gateau>();

        String selectQuery = "SELECT * FROM " + TABLE_GATEAU;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Gateau gateau = new Gateau();
                gateau.setId(Integer.parseInt(cursor.getString(0)));
                gateau.setType(cursor.getString(1));
                gateau.setNom(cursor.getString(2));
                gateau.setPrix(Double.parseDouble(cursor.getString(3)));
                gateau.setStock(Double.parseDouble(cursor.getString(4)));
                // Adding gateau to list
                gateauList.add(gateau);
            } while (cursor.moveToNext());
        }

        return gateauList;
    }

    public int getGateausCount() {

        String countQuery = "SELECT  * FROM " + TABLE_GATEAU;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        return count;
    }

    public int updateGateau(Gateau gateau) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_GATEAU_TYPE, gateau.getType());
        values.put(COLUMN_GATEAU_NOM, gateau.getNom());
        values.put(COLUMN_GATEAU_PRIX, gateau.getPrix());
        values.put(COLUMN_GATEAU_STOCK, gateau.getStock());

        // updating row
        return db.update(TABLE_GATEAU, values, COLUMN_GATEAU_ID + " = ?",
                new String[]{String.valueOf(gateau.getId())});
    }

    public void deleteGateau(Gateau gateau) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_GATEAU, COLUMN_GATEAU_ID + " = ?",
                new String[] { String.valueOf(gateau.getId()) });
        db.close();
    }
}