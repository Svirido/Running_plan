package com.svirido.running_plan.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.svirido.running_plan.base.OneGoal

const val GOAL_DATABASE_VERSION = 2
const val GOAL_DATABASE_NAME = "goalDB"
const val GOAL_TABLE_NAME = "goals"

const val GOAL_KEY_ID = "id"
const val GOAL_KEY_DATE = "date"
const val GOAL_KEY_DISTANCE = "distance"

class GoalDataBaseHandler(context: Context) :
    SQLiteOpenHelper(context, GOAL_DATABASE_NAME, null, GOAL_DATABASE_VERSION) {
    override fun onCreate(p0: SQLiteDatabase?) {
        val CREATE_TRAIN_TABLE = "CREATE TABLE " + GOAL_TABLE_NAME + "(" +
                GOAL_KEY_ID + " INTEGER PRIMARY KEY," +
                GOAL_KEY_DATE + " TEXT," +
                GOAL_KEY_DISTANCE + " INTEGER" + ")"

        p0?.execSQL(CREATE_TRAIN_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS $GOAL_TABLE_NAME")
        onCreate(p0)
    }

    fun addGoal(oneGoal: OneGoal) {
        val db: SQLiteDatabase = this.writableDatabase

        val contentValue = ContentValues()
        contentValue.put(GOAL_KEY_DATE, oneGoal.date)
        contentValue.put(GOAL_KEY_DISTANCE, oneGoal.distance)

        db.insert(GOAL_TABLE_NAME, null, contentValue)
        db.close()
    }

    fun getAllOneGoal(): List<OneGoal> {
        val db = this.readableDatabase

        val goalList = ArrayList<OneGoal>()
        val selectAllGoal = "SELECT * FROM $GOAL_TABLE_NAME"

        val cursor = db.rawQuery(selectAllGoal, null)

        if (cursor.moveToFirst()) {
            do {
                val goal = OneGoal(cursor.getInt(0),
                    cursor.getString(1), cursor.getInt(2))

                goalList.add(goal)

            } while (cursor.moveToNext())
        }
        return goalList
    }


}