package com.doranco.ecommerceapp.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.doranco.ecommerceapp.bean.Utilisateur;

import java.util.ArrayList;
import java.util.List;

public class MyDataBase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "E-commerce";
    private static final String TABLE_NAME = "Client";
    private static final String COLUMN_USER_ID = "Id";
    private static final String COLUMN_USER_LASTNAME = "Nom";
    private static final String COLUMN_USER_FIRSTNAME = "Prénom";
    private static final String COLUMN_USER_TELEPHONE = "Téléphone";
    private static final String COLUMN_USER_EMAIL = "Email";
    private static final String COLUMN_USER_PASSWORD = "password";
    private static final String COLUMN_USER_ADRESS = "Adresse";

    public MyDataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String script = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_USER_ID + " INTEGER PRIMARY KEY," + COLUMN_USER_LASTNAME + " TEXT,"
                + COLUMN_USER_FIRSTNAME + " TEXT," + COLUMN_USER_TELEPHONE + " TEXT," + COLUMN_USER_EMAIL + " TEXT UNIQUE," + COLUMN_USER_PASSWORD + " TEXT," + COLUMN_USER_ADRESS + " TEXT"+ ")";
        // Execute Script.
        sqLiteDatabase.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Drop older table if existed
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Create tables again
        onCreate(sqLiteDatabase);
    }

    public void addUtilisateur(Utilisateur utilisateur) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_LASTNAME, utilisateur.getNom());
        values.put(COLUMN_USER_FIRSTNAME, utilisateur.getPrenom());
        values.put(COLUMN_USER_TELEPHONE, utilisateur.getTelephone());
        values.put(COLUMN_USER_EMAIL, utilisateur.getEmail());
        values.put(COLUMN_USER_PASSWORD, utilisateur.getPassword());
        values.put(COLUMN_USER_ADRESS, utilisateur.getAdresse());
        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        // Closing database connection
        db.close();
    }

    public Utilisateur getUtilisateurById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String Columns[] = {COLUMN_USER_ID, COLUMN_USER_LASTNAME, COLUMN_USER_FIRSTNAME, COLUMN_USER_TELEPHONE, COLUMN_USER_EMAIL, COLUMN_USER_PASSWORD, COLUMN_USER_ADRESS};
        Cursor cursor = db.query(TABLE_NAME, Columns, COLUMN_USER_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Utilisateur utilisateur = new Utilisateur(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
        return utilisateur;
    }

    public Utilisateur getUtilisateurByEmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String Columns[] = {COLUMN_USER_ID, COLUMN_USER_LASTNAME, COLUMN_USER_FIRSTNAME, COLUMN_USER_TELEPHONE, COLUMN_USER_EMAIL, COLUMN_USER_PASSWORD, COLUMN_USER_ADRESS};
        Cursor cursor = db.query(TABLE_NAME, Columns, COLUMN_USER_EMAIL + "=?",
                new String[]{email}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Utilisateur utilisateur = new Utilisateur(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
        return utilisateur;
    }

    public Utilisateur getUtilisateurByTelephone(String tel) {
        SQLiteDatabase db = this.getReadableDatabase();
        String Columns[] = {COLUMN_USER_ID, COLUMN_USER_LASTNAME, COLUMN_USER_FIRSTNAME, COLUMN_USER_TELEPHONE, COLUMN_USER_EMAIL, COLUMN_USER_PASSWORD, COLUMN_USER_ADRESS};
        Cursor cursor = db.query(TABLE_NAME, Columns, COLUMN_USER_TELEPHONE + "=?",
                new String[]{tel}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Utilisateur utilisateur = new Utilisateur(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
        return utilisateur;
    }

    public List<Utilisateur> getAllUtilisateurs() {
        List<Utilisateur> utilisateursList = new ArrayList<Utilisateur>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(Integer.parseInt(cursor.getString(0)));
                utilisateur.setNom(cursor.getString(1));
                utilisateur.setPrenom(cursor.getString(2));
                utilisateur.setTelephone(cursor.getString(2));
                utilisateur.setEmail(cursor.getString(2));
                utilisateur.setPassword(cursor.getString(2));
                utilisateur.setAdresse(cursor.getString(2));
                // Adding note to list
                utilisateursList.add(utilisateur);
            } while (cursor.moveToNext());
        }
        // return note list
        return utilisateursList;
    }

    public int getUtilisateursCount() {
        String countQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int updateUtilisateur(Utilisateur utilisateur) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_LASTNAME, utilisateur.getNom());
        values.put(COLUMN_USER_FIRSTNAME, utilisateur.getPrenom());
        values.put(COLUMN_USER_TELEPHONE, utilisateur.getTelephone());
        values.put(COLUMN_USER_EMAIL, utilisateur.getEmail());
        values.put(COLUMN_USER_PASSWORD, utilisateur.getPassword());
        values.put(COLUMN_USER_ADRESS, utilisateur.getAdresse());
        // updating row
        return db.update(TABLE_NAME, values, COLUMN_USER_ID + " = ?", new String[]{String.valueOf(utilisateur.getId())});
    }

    public void deleteUtilisateur(Utilisateur utilisateur) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(utilisateur.getId())});
        db.close();
    }
}
