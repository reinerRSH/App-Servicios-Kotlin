package com.example.myapplication

import ClasesAPP.ServicioAdapter
import ClasesAPP.recomendadoAdapter
import Data.Servicio
import Data.recomendado
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class homeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_home)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        RecyclerViewService ()
        RecycleViewRecomendados()

    }


    fun RecyclerViewService (){
        val rv_populars_service = findViewById<RecyclerView>(R.id.rv_populars_service)

        val listaDeServicios = listOf(
            Servicio(1,"Limpieza",R.drawable.limpiesza),
            Servicio(2,"Reparaciones", R.drawable.reparar),
            Servicio(3,"Electricidad",R.drawable.electricidad),
            Servicio(4,"Carpinteria",R.drawable.carpinteria)

)

        rv_populars_service.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rv_populars_service.adapter = ServicioAdapter(listaDeServicios)

    }

    fun RecycleViewRecomendados(){
        val rv_recomendados = findViewById<RecyclerView>(R.id.rv_recomendados)



        // lista de Rv recomendados pendiente por mejorar
        val listaRecomendados = listOf(
            recomendado(1,"Juan M.",R.drawable.ic_launcher_foreground,"4.5","Plomeria","200$/hs",R.drawable.ic_launcher_foreground),
            recomendado(2,"Juan M.",R.drawable.ic_launcher_foreground,"4.5","Plomeria","200$/hs",R.drawable.ic_launcher_foreground),
            recomendado(3,"Juan M.",R.drawable.ic_launcher_foreground,"4.5","Plomeria","200$/hs",R.drawable.ic_launcher_foreground),
            recomendado(4,"Juan M.",R.drawable.ic_launcher_foreground,"4.5","Plomeria","200$/hs",R.drawable.ic_launcher_foreground),
            recomendado(5,"Juan M.",R.drawable.ic_launcher_foreground,"4.5","Plomeria","200$/hs",R.drawable.ic_launcher_foreground),
            recomendado(6,"Juan M.",R.drawable.ic_launcher_foreground,"4.5","Plomeria","200$/hs",R.drawable.ic_launcher_foreground),
            recomendado(7,"Juan M.",R.drawable.ic_launcher_foreground,"4.5","Plomeria","200$/hs",R.drawable.ic_launcher_foreground))

        val mLayoutManager = GridLayoutManager(this, 2)
        rv_recomendados.layoutManager = mLayoutManager

            rv_recomendados.adapter = recomendadoAdapter(listaRecomendados)

    }


}