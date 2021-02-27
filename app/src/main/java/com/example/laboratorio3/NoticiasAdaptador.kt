package com.example.laboratorio3

import android.view.LayoutInflater
import android.view.LayoutInflater.*
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

public class NoticiasAdaptador(private val listener: NoticiasHolder.ClickListener):
    RecyclerView.Adapter<NoticiasAdaptador.NoticiasHolder>() {
    private var noticias: MutableList<Noticia> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiasHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_noticia, parent, false)
        return NoticiasHolder(view)
    }

    override fun onBindViewHolder(holder: NoticiasHolder, position: Int) {
        holder.bind(noticias[position], listener)
    }

    override fun getItemCount(): Int {
        return this.noticias.size
    }

    public fun setItems(news: MutableList<Noticia>) {
        this.noticias = news
        notifyDataSetChanged()
    }

    fun addItem(aux: Noticia) {
        this.noticias.add(aux)
        notifyItemInserted(itemCount)
    }

    fun removeItem(position: Int) {
        this.noticias.removeAt(position)
        notifyItemRemoved(position)
    }

    fun updateItem(position: Int, aux: Noticia) {
        this.noticias[position] = aux
        notifyItemChanged(position)
    }


    class NoticiasHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(noticia: Noticia, listener: ClickListener) = with(itemView){
            val txtTitulo: TextView = findViewById(R.id.txtTitulo)
            val txtDescripcion: TextView = findViewById(R.id.txtDescripcion)
            val imagen: ImageView = findViewById(R.id.imagen)

            txtTitulo.text = noticia.titulo
            txtDescripcion.text = noticia.descipcion

            Picasso.get()
                    .load(noticia.imagen)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .into(imagen)

            setOnClickListener {
                listener.onItemClicked(adapterPosition)
            }

            setOnLongClickListener {
                listener.onItemLongClicked(adapterPosition)
            }
        }
        interface ClickListener{
            fun onItemClicked(position: Int)
            fun onItemLongClicked(position: Int): Boolean
        }
    }
}