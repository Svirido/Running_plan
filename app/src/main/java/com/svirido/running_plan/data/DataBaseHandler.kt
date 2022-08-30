package com.svirido.running_plan.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.svirido.running_plan.base.Workout

const val DATABASE_VERSION = 1
const val DATABASE_NAME = "trainDB"
const val TABLE_NAME = "trains"

const val KEY_ID = "id"
const val KEY_TYPE = "type"
const val KEY_DATE = "date"
const val KEY_DAY_WEEK = "dayWeek"
const val KEY_TRAIN = "train"
const val KEY_DESCRIPTION = "description"
const val KEY_REPORT = "report"

class DataBaseHandler(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(p0: SQLiteDatabase?) {

        val CREATE_TRAIN_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
                KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_TYPE + " TEXT," +
                KEY_DATE + " TEXT," +
                KEY_DAY_WEEK + " TEXT," +
                KEY_TRAIN + " TEXT," +
                KEY_DESCRIPTION + " TEXT," +
                KEY_REPORT + " TEXT" + ")"

        p0?.execSQL(CREATE_TRAIN_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(p0)
    }

    fun addTrain(train: Workout) {
        val db: SQLiteDatabase = this.writableDatabase

        val contentValue = ContentValues()
        contentValue.put(KEY_TYPE, train.type)
        contentValue.put(KEY_DATE, train.date)
        contentValue.put(KEY_DAY_WEEK, train.dayWeek)
        contentValue.put(KEY_TRAIN, train.train)
        contentValue.put(KEY_DESCRIPTION, train.description)
        contentValue.put(KEY_REPORT, train.report)

        db.insert(TABLE_NAME, null, contentValue)
        db.close()
    }

    fun getTrain(id: Int): Workout {
        val db = this.readableDatabase

        val cursor: Cursor = db.query(TABLE_NAME,
            arrayOf(KEY_ID,
                KEY_TYPE,
                KEY_DATE,
                KEY_DAY_WEEK,
                KEY_TRAIN,
                KEY_DESCRIPTION,
                KEY_REPORT),
            "$KEY_ID=?",
            arrayOf(id.toString()),
            null,
            null,
            null,
            null)

        cursor.moveToFirst()
        val train = Workout(
            cursor.getString(0).toInt(),
            cursor.getString(1),
            cursor.getString(2),
            cursor.getString(3),
            cursor.getString(4),
            cursor.getString(5),
            cursor.getString(6)
        )
        return train
    }

    fun getAllTrain(): List<Workout> {
        val db = this.readableDatabase

        val trainList = ArrayList<Workout>()
        val selectAllTrain = "SELECT * FROM $TABLE_NAME"

        val cursor = db.rawQuery(selectAllTrain, null)

        if (cursor.moveToFirst()) {
            do {
                val train = Workout(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6))

                trainList.add(train)

            } while (cursor.moveToNext())
        }
        return trainList
    }

}