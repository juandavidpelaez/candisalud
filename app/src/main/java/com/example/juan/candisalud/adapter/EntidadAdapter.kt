package com.example.juan.candisalud.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.juan.candisalud.R
import com.example.juan.candisalud.models.Entidad

class EntidadAdapter(val context: Context, val lista: ArrayList<Entidad>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class EntidadHolder(view: View): RecyclerView.ViewHolder(view){
        val tvNombre = view.findViewById<TextView>(R.id.tvNombre)
        val tvTelefono = view.findViewById<TextView>(R.id.tvTelefono)
        val tvDireccion = view.findViewById<TextView>(R.id.tvDireccion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EntidadHolder(LayoutInflater.from(context).inflate(R.layout.adapter_entidades, parent, false))
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val entidadHolder = holder as EntidadHolder
        val entidad = lista[position]
        entidadHolder.tvNombre.text = entidad.nombre
        entidadHolder.tvDireccion.text = entidad.direccion
        entidadHolder.tvTelefono.text = entidad.telefono

    }

}