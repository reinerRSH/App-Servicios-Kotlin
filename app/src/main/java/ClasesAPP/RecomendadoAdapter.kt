package ClasesAPP

import Data.Servicio
import Data.recomendado
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R




class recomendadoAdapter(private val listaRecomendados: List<recomendado>) :
    RecyclerView.Adapter<recomendadoAdapter.recomendadoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup,  viewType: Int): recomendadoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.molde_recomendado, parent, false)
        return  recomendadoViewHolder(view)

    }

    override fun onBindViewHolder(holder: recomendadoViewHolder, position: Int) {
        val recomendado = listaRecomendados[position]
        holder.tvNombre_recomendado.text = recomendado.nombre
        holder.tvPrecio_recomendado.text = recomendado.precio
        holder.tvProfesion_recomendado.text = recomendado.profesion
        holder.tvRating_recomendado.text = recomendado.rating
        holder.ivProfile_recomendado.setImageResource(recomendado.imageProfile)
        holder.ivAction_recomendado.setImageResource(recomendado.ivContratar)





    }

    override fun getItemCount(): Int = listaRecomendados.size



    //holder para cada elemento de la lista de recomendados
    class recomendadoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val ivProfile_recomendado: ImageView = view.findViewById(R.id.iv_imageProfile_popular)
        val tvNombre_recomendado: TextView = view.findViewById(R.id.id_recomendado_tarjeta)
        val tvProfesion_recomendado: TextView = view.findViewById(R.id.profesion_perfil)
        val tvPrecio_recomendado: TextView = view.findViewById(R.id.id_precio_hora)
        val ivAction_recomendado: ImageView = view.findViewById(R.id.iv_contratar)
        val tvRating_recomendado: TextView = view.findViewById(R.id.tv_rating)


    }
}









