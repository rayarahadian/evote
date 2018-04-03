package com.example.evliveraya.evote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created by EvliveRaya on 02/04/2018.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int db_version = 1;
    private static final String db_name = "evotedb";
    private static final String table_candidate="candidates";
    private static final String table_user="users";

    public DBHandler(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_CANDIDATE ="CREATE TABLE " + table_candidate + "(id INTEGER PRIMARY KEY, nama1 TEXT," +
                " nama2 TEXT, nomor INTEGER, jml_vote INTEGER)";
        String CREATE_TABLE_USER = "CREATE TABLE "+ table_user + "(id INTEGER PRIMARY KEY, nama TEXT, nik TEXT," +
                " email TEXT, password TEXT, vote INTEGER)";
        sqLiteDatabase.execSQL(CREATE_TABLE_CANDIDATE);
        sqLiteDatabase.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + table_candidate);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + table_user);
        onCreate(sqLiteDatabase);
    }

    //Candidate

    public void insertCandidate(Candidate candidate) {
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase db_read = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("nama1", candidate.getNama1());
        values.put("nama2", candidate.getNama2());
        values.put("nomor", candidate.getNomor());
        values.put("jml_vote", candidate.getJml_vote());
        List<Candidate> listCandidate = new ArrayList<Candidate>();
        boolean checkCandidate = false;
        for (Candidate p : listCandidate) {
            if (p.getNomor() == candidate.getNomor()) {
                checkCandidate = true;
            }
        }
        if (checkCandidate == false) {
            db.insert(table_candidate, null, values);
        }
        db.close();
    }

    public Candidate getCandidate(int nomor) {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Candidate> listCandidate = new ArrayList<Candidate>();
        String query = "SELECT * FROM " + table_candidate;
        Cursor cursor = db.rawQuery(query, null);
        Candidate candidate = new Candidate();
        if (cursor.moveToFirst()) {
            do {
                if (Integer.parseInt(cursor.getString(3))  == nomor ) {
                    candidate.setId(Integer.parseInt(cursor.getString(0)));
                    candidate.setNama1(cursor.getString(1));
                    candidate.setNama2(cursor.getString(2));
                    candidate.setNomor(Integer.parseInt(cursor.getString(3)));
                    candidate.setJml_vote(Integer.parseInt(cursor.getString(4)));
                    listCandidate.add(candidate);
                }
            } while (cursor.moveToNext());
        }
        db.close();
        return candidate;
    }

    public List<Candidate> getAllCandidate() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Candidate> listCandidate = new ArrayList<Candidate>();
        String query = "SELECT * FROM " + table_candidate;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Candidate candidate = new Candidate();
                candidate.setId(Integer.parseInt(cursor.getString(0)));
                candidate.setNama1(cursor.getString(1));
                candidate.setNama2(cursor.getString(2));
                candidate.setNomor(Integer.parseInt(cursor.getString(3)));
                candidate.setJml_vote(Integer.parseInt(cursor.getString(4)));
                listCandidate.add(candidate);
            } while (cursor.moveToNext());
        }
        return listCandidate;
    }

    public int updateCandidate(Candidate candidate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nama1", candidate.getNama1());
        values.put("nama2", candidate.getNama2());
        values.put("nomor", candidate.getNomor());
        values.put("jml_vote", candidate.getJml_vote());
        return db.update(table_candidate, values, "id = ?", new String[] {String.valueOf(candidate.getId())});
    }

    public void deleteCandidate(Candidate candidate) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table_candidate, "id = ?", new String[] {String.valueOf(candidate.getId())});
        db.close();
    }

    //User
    public void insertUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nama", user.getNama());
        values.put("nik", user.getNik());
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());
        values.put("vote", user.getVote());
        db.insert(table_user, null, values);
        db.close();
    }

    public User getUser(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        User user = new User();
        user.setEmail("");
        user.setPassword("");
        String query = "SELECT * FROM " + table_user;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                if (cursor.getString(3).equals(email)) {
                    user.setId(Integer.parseInt(cursor.getString(0)));
                    user.setNama(cursor.getString(1));
                    user.setNik(cursor.getString(2));
                    user.setEmail(cursor.getString(3));
                    user.setPassword(cursor.getString(4));
                    user.setVote(Integer.parseInt(cursor.getString(5)));
                }
            } while (cursor.moveToNext());
        }
        db.close();
        return user;
    }

    public List<User> getAllUser() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<User> listUser = new ArrayList<User>();
        String query = "SELECT * FROM " + table_user;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setNama(cursor.getString(1));
                user.setNik(cursor.getString(2));
                user.setEmail(cursor.getString(3));
                user.setPassword(cursor.getString(4));
                user.setVote(Integer.parseInt(cursor.getString(5)));
                listUser.add(user);
            } while (cursor.moveToNext());
        }
        return listUser;
    }

    public int updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nama", user.getNama());
        values.put("nik", user.getNik());
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());
        values.put("vote", user.getVote());
        return  db.update(table_user, values, "id = ?", new String[] {String.valueOf(user.getId())});
    }
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table_user, "id = ?", new String[] {String.valueOf(user.getId())});
        db.close();
    }
}
