package com.example.juan.candisalud.models

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import java.io.Serializable

class Entidad: Serializable {

    companion object {
        val tblNombre: String = "Entidades"
        val lblId: String = "Id"
        val lblNombre: String = "Nombre"
        val lblDireccion: String = "Direccion"
        val lblTelefono: String = "Telefono"
        val lblObservaciones: String = "Observaciones"

        val createtbl: String = "CREATE TABLE [$tblNombre] (" +
                "[$lblId] INTEGER PRIMARY KEY AUTOINCREMENT," +
                "[$lblNombre] TEXT NOT NULL," +
                "[$lblDireccion] TEXT NOT NULL," +
                "[$lblTelefono] TEXT NOT NULL," +
                "[$lblObservaciones] TEXT)"

        fun add(db: SQLiteDatabase, entidad: Entidad){
            db.insert(tblNombre, null, entidad.toContentValues())
        }

        fun select(db: SQLiteDatabase): ArrayList<Entidad>{
            val arrayList = ArrayList<Entidad>()
            val c = db.query(tblNombre, null, null, null, null, null, "$lblNombre ASC")

            while (c.moveToNext()){
                val entidad = Entidad()
                entidad.fromCursor(c)
                arrayList.add(entidad)
            }

            return arrayList
        }
    }

    var id: Int = -1
    var nombre: String = ""
    var direccion: String = ""
    var telefono: String = ""
    var observaciones: String = ""

    override fun toString(): String {
        return nombre
    }

    fun toContentValues(): ContentValues{

        val content = ContentValues()
        content.put(lblNombre,nombre)
        content.put(lblDireccion,direccion)
        content.put(lblTelefono,telefono)
        content.put(lblObservaciones,observaciones)
        return content
    }

    fun fromCursor(c: Cursor){
        id = c.getInt(c.getColumnIndex(lblId))
        nombre = c.getString(c.getColumnIndex(lblNombre))
        direccion = c.getString(c.getColumnIndex(lblDireccion))
        telefono = c.getString(c.getColumnIndex(lblTelefono))
        observaciones = c.getString(c.getColumnIndex(lblObservaciones))
    }


}