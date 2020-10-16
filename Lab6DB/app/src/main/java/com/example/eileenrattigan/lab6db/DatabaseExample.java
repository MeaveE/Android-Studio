package com.example.eileenrattigan.lab6db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseExample { //extends SQLiteOpenHelper

    public static final String DATABASE_NAME="TaskList";
    public static final String TABLE_NAME = "Tasks";
    public static final String Col_1 = "_id";
    public static final String Col_2 = "Task_Name";
    public static final String Col_3 = "Task_Description";
    public static final String Col_4 = "Status";

    // SQL statement to create the database
    private static final String DATABASE_CREATE =
            "create table Tasks (_id integer primary key autoincrement," +
                    "Task_Name text not null," + "Task_Description text not null,"  +
                    "Status Integer not null);";

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DatabaseExample(Context ctx) {

      //super(context, DATABASE_NAME, null, 1);
        this.context 	= ctx;
        DBHelper 		= new DatabaseHelper(context);
    }

    public DatabaseExample open() throws SQLException
    {
        db     = DBHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {

        DBHelper.close();
    }

    public long insertTask( String Task_Name, String Task_Description, Integer Status)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(Col_2, Task_Name);
        initialValues.put(Col_3, Task_Description);
        initialValues.put(Col_4, Status);
        return db.insert(TABLE_NAME, null, initialValues);
    }

    public boolean deleteTask(long rowId)
    {
        //
        return db.delete(TABLE_NAME, Col_1 +
                "=" + rowId, null) > 0;
    }

    public Cursor getAllTasks()
    {
        return db.query(TABLE_NAME, new String[]
                        {
                                Col_1,
                                Col_2,
                                Col_3,
                                Col_4
                        },
                null, null, null, null, null);
    }
    public Cursor getTask(long rowId) throws SQLException
    {
        Cursor mCursor =
                db.query(true, TABLE_NAME, new String[]
                                {
                                        Col_1,
                                        Col_2,
                                        Col_3,
                                        Col_4
                                },
                        Col_1 + "=" + rowId,  null, null, null, null, null);

        if (mCursor != null)
        {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public boolean updateTask(long rowId, String Task_Name, String Task_Description, Integer Status)
    {
        ContentValues args = new ContentValues();
        args.put(Col_2, Task_Name);
        args.put(Col_3,Task_Description);
        args.put(Col_4,Status);
        return db.update(TABLE_NAME, args,
                Col_1 + "=" + rowId, null) > 0;
    }

    ///////////////////nested dB helper class ///////////////////////////////////////
    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        //
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, 1);
        }


        @Override
        //
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        //
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion)
        {
            // dB structure change..

        }
    }
    //////////////////////////// end nested dB helper class //////////////////////////////////////
}
