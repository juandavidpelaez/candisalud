package com.example.juan.candisalud

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.juan.candisalud.models.Entidad
import com.example.juan.candisalud.utils.DbHelper
import kotlinx.android.synthetic.main.form_entidades.*

class EntidadFormulario: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_entidades)

        mBotonBack.setOnClickListener { onBackPressed()}

        mBotonGuardar.setOnClickListener {
            val entidad = Entidad()
                entidad.nombre= mETNombre.text.toString()
                entidad.direccion= mETDireccion.text.toString()
                entidad.telefono= mETTelefono.text.toString()
                entidad.observaciones= mETObservaciones.text.toString()

            var db = DbHelper(this).writableDatabase

            Entidad.add(db,entidad)

            setResult(Activity.RESULT_OK)
            finish()
        }
    }

}