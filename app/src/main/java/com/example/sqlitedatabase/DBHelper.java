package com.example.sqlitedatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String STUDENT_ID = "StudentID";
    public static final String STUDENT_NAME = "StudentName";
    public static final String STUDENT_ROLL = "StudentRollNumber";
    public static final String STUDENT_ENROLL = "IsEnrolled";
    public static final String STUDENT_TABLE = "StudentTable";

    public DBHelper(@Nullable Context context) {
        super(context, "MyDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSTatement = "CREATE TABLE " + STUDENT_TABLE +
                "(" + STUDENT_ID + " Integer PRIMARY KEY AUTOINCREMENT, " +
                STUDENT_NAME + " Text, " +
                STUDENT_ROLL + " Int, " +
                STUDENT_ENROLL + " BOOL) ";

        db.execSQL(createTableSTatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
        onCreate(db);
    }

    //CRUD OPERATIONS
    //ADD
    public void  addStudent(StudentModel STUDENTModel){
        SQLiteDatabase db = this.getWritableDatabase();         //getting object of Db
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();

        cv.put(STUDENT_NAME, STUDENTModel.getName());
        cv.put(STUDENT_ROLL, STUDENTModel.getRollNo());
        cv.put(STUDENT_ENROLL, STUDENTModel.isEnroll());

        db.insert(STUDENT_TABLE, null, cv);

        db.close();
        //NullCoumnHack
        //long insert =
        //if (insert == -1) { return false; }
        //else{return true;}
    }
    //Update
    public void updateStudent(int id, StudentModel STUDENTModel){
        ContentValues cv = new ContentValues();

        cv.put(STUDENT_NAME, STUDENTModel.getName());
        cv.put(STUDENT_ROLL, STUDENTModel.getRollNo());
        cv.put(STUDENT_ENROLL, STUDENTModel.isEnroll());

        SQLiteDatabase db = this.getWritableDatabase();         //getting object of Db
        //Cursor cursorCourses = db.rawQuery("SELECT * FROM " + STUDENT_TABLE, STUDENT_ID:id);

    }
    //Delete
    public void deleteStudent(int id){
        SQLiteDatabase db = this.getWritableDatabase();         //getting object of Db
        //Cursor cursorCourses = db.rawQuery("DELETE FROM " + STUDENT_TABLE, STUDENT_ID==id);

    }
    //READ
    public ArrayList<StudentModel> getAllStudents() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + STUDENT_TABLE, null);

        ArrayList<StudentModel> studentArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {

                studentArrayList.add(new StudentModel(cursorCourses.getString(1),
                        cursorCourses.getInt(2),
                        cursorCourses.getInt(3) == 1 ? true : false));
            } while (cursorCourses.moveToNext());

        }

        cursorCourses.close();
        db.close();
        return studentArrayList;
    }

}
