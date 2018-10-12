package com.example.juan.candisalud

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.juan.candisalud.fragments.EntidadFragmento
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var fragmentoActivo: Int = -1
    val mRequestEntidadFormulario: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nav_view.setNavigationItemSelectedListener(this)
        nav_view.setCheckedItem(R.id.entidades)
        setFragmento(R.id.entidades)


        mBotonMenu.setOnClickListener(){
            drawer_layout.openDrawer(GravityCompat.START)
        }

        mBotonAgregar.setOnClickListener{

            when (fragmentoActivo){
                R.id.entidades -> {
                    val i = Intent(this@MainActivity, EntidadFormulario::class.java)
                    startActivityForResult(i,mRequestEntidadFormulario)
                }
            }
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    fun setFragmento(id:Int){

        var fragment: Fragment? = null

        when(id){
            R.id.entidades ->{
                fragment = EntidadFragmento()
                mAppbarlabel.text = EntidadFragmento.LABEL
            }
        }

        if (fragment != null){
            fragmentoActivo = id
            supportFragmentManager.beginTransaction().replace(R.id.mFrameLayout,fragment).commit()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        setFragmento(item.itemId)

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
