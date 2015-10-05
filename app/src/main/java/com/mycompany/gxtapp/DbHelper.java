package com.mycompany.gxtapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;

/**
 * Created by David on 7/18/15.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final int database_VERSION = 1;
    //database Name
    private static final String database_NAME = "FieldObjDB";
    private static final String table_OBJECTS = "objects";
    private static final String obj_STATION = "station";
    private static final String obj_OBJECT = "object";
    private static final String obj_OFFSET = "offset";
    private static final String obj_DIRECTION = "direction";

    private static final String[] COLUMNS ={obj_STATION, obj_OBJECT, obj_OFFSET,obj_DIRECTION };

    public DbHelper(Context context) {
        super(context, database_NAME, null, database_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQL statement to create book table
        String CREATE_FIELD_OBJECT_TABLE = "CREATE TABLE objects ( " + "station INTEGER PRIMARY KEY, " + "object TEXT," + "offset INTEGER )";
        db.execSQL(CREATE_FIELD_OBJECT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop field object table if it already exist
        db.execSQL("DROP TABLE IF EXISTS objects");
        this.onCreate(db);
    }

    public void createFieldObj(FieldObj fieldObj){
        //get reference of the FieldObjDB database
        SQLiteDatabase db = this.getWritableDatabase();

        //make values to be inserted
        ContentValues values = new ContentValues();
        values.put(obj_STATION, fieldObj.getStation());
        values.put(obj_OBJECT,fieldObj.getName());
        values.put(obj_OFFSET,fieldObj.getOffset());

        //insert field object
        db.insert(table_OBJECTS, null, values);

        //close database tranx
        db.close();
    }

    public FieldObj readFieldObj(int sta){
        //get reference to the FieldObjDB
        SQLiteDatabase db = this.getReadableDatabase();

        //get field object query
        Cursor cursor = db.query(table_OBJECTS, // a. table
                        COLUMNS, "station = ?", new String[]{String.valueOf(sta)}, null,null,null,null);

        //if result != null, parse the first one
        if (cursor != null)
            cursor.moveToFirst();

        FieldObj fieldObj = new FieldObj();
        fieldObj.setStation(Integer.parseInt(cursor.getString(0)));
        fieldObj.setName(cursor.getString(1));
        fieldObj.setOffset(Integer.parseInt(cursor.getString(2)));

        return fieldObj;

    }

    public List getAllFieldObj(){
        List fieldObjs = new List();//!!!!!!!!!!!!!!!!!!!!!!!!!!

        //select field objet query
        String query = "SELECT *FROM" + table_OBJECTS;

        //get reference of the FieldObjDB database
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        //parse all results
        FieldObj fieldObj = null;
        if (cursor.moveToFirst()){
            do{
                fieldObj = new FieldObj();
                fieldObj.setStation(Integer.parseInt(cursor.getString(0)));
                fieldObj.setName(cursor.getString(1));
                fieldObj.setOffset(Integer.parseInt(cursor.getString(2)));
            }while (cursor.moveToNext());
        }

        return fieldObjs;
    }

    public int updateFieldObj(FieldObj fieldObj){
        //get reference to FieldObjDB database
        SQLiteDatabase db = this.getWritableDatabase();

        //make values to be inserted
        ContentValues values = new ContentValues();
        values.put("station",fieldObj.getStation());
        values.put("object",fieldObj.getName());
        values.put("offset", fieldObj.getOffset());

        //update
        int i = db.update(table_OBJECTS, values,obj_STATION  + " = ?", new String[] {String.valueOf(fieldObj.getStation())} );

        db.close();
        return i;
    }

    //deleting single fieldObj
    public void deleteFieldObj(FieldObj fieldObj){

        //get reference to the FieldObjDB
        SQLiteDatabase db = this.getWritableDatabase();

        //delete fieldObj
        db.delete(table_OBJECTS,obj_STATION + "= ?", new String[]{String.valueOf(fieldObj.getStation())});
        db.close();
    }
}
