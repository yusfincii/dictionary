package com.example.engturdictionary

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(private val context:Context) : SQLiteOpenHelper(context, "wordsEngTur.sqlite",
    null , 1)
{
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS word(" +
                "word_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "word_eng TEXT, " +
                "word_tur TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS word")
        onCreate(db)
    }

}