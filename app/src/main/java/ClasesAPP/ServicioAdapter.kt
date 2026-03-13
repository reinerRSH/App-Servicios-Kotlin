package ClasesAPP

import Data.Servicio
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

// ADAPTADOR PARA LA CATEGORIA DE SERVICIOS (POPULARES)
class ServicioAdapter(private val listaServicios: List<Servicio>) :
    RecyclerView.Adapter<ServicioAdapter.ServicioViewHolder>() {

    // 1. Infla el diseño del "molde" (item_categoria)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.molde_categoria, parent, false)
        return ServicioViewHolder(view)
    }

    // 2. Conecta los datos con la vista
    override fun onBindViewHolder(holder: ServicioViewHolder, position: Int) {
        val servicio = listaServicios[position]
        holder.tvNombre.text = servicio.nombre
        holder.ivIcono.setImageResource(servicio.icon)



        // Aquí podrías cambiar el color de fondo si quisieras:
        // holder.ivIcono.backgroundTintList = ColorStateList.valueOf(servicio.colorFondo)
    }

    override fun getItemCount(): Int = listaServicios.size
// holder para cada elemento de la lista populares
    class ServicioViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivIcono: ImageView = view.findViewById(R.id.iv_cat_ic)
        val tvNombre: TextView = view.findViewById(R.id.tv_cat_nombre)
    }
}

























