package com.example.juan.candisalud.utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.juan.candisalud.models.Entidad

class DbHelper(context: Context): SQLiteOpenHelper(context, dbNombre, null, dbVersion) {

    companion object {
        val dbNombre = "Candisalud.db"
        val dbVersion = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(Entidad.createtbl)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }

}