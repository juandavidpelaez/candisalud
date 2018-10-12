package com.example.juan.candisalud.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.juan.candisalud.R
import com.example.juan.candisalud.adapter.EntidadAdapter
import com.example.juan.candisalud.models.Entidad
import com.example.juan.candisalud.utils.DbHelper
import kotlinx.android.synthetic.main.fragment_entidades.*

class EntidadFragmento: Fragment() {

    companion object {
        const val LABEL = "Entidad"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_entidades,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val db = DbHelper(activity!!).readableDatabase
        val lista = Entidad.select(db)
        val adaptador = EntidadAdapter(activity!!, lista)
        mRecyclerView.layoutManager = LinearLayoutManager(activity!!)
        mRecyclerView.adapter = adaptador
    }
}