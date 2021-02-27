package com.example.laboratorio3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), NoticiasAdaptador.NoticiasHolder.ClickListener {
    private var noticias: MutableList<Noticia> = mutableListOf()
    private val adapter = NoticiasAdaptador(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd:Button = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener {
            val aux = Noticia("Prueba",
                    "Prueba",
                    "https://ih1.redbubble.net/image.1115317261.6105/flat,750x,075,f-pad,750x1000,f8f8f8.jpg")
            adapter.addItem(aux)
        }

        adapter.addItem(Noticia("Desaparece el COVID",
                "Gracias al gran esfuerzo de cada persona, la pandemia termina tras solo 1 mes",
                "https://d2v9ipibika81v.cloudfront.net/uploads/sites/253/virus750x450.png"))
        adapter.addItem(Noticia("Guatemala lider mundial",
                "Se convierte hoy en la primera potencia mundial en todos los ambitos posibles",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Flag_of_Guatemala.svg/1200px-Flag_of_Guatemala.svg.png"))
        adapter.addItem(Noticia("Remontada Blaugrana",
                "FC Barcelona vence a Paris Saint Germain 9-0. 5 goles de Messi chiquito",
                "https://i.ytimg.com/vi/YDFt_-DH6cg/maxresdefault.jpg"))
        adapter.addItem(Noticia("Spiderverse Confirmado",
                "Tobey Maguire, Andrew Garfield y Tom Holland estaran juntos en la pelicula",
                "https://i.ytimg.com/vi/w7VWKeNntUs/maxresdefault.jpg"))
        adapter.addItem(Noticia("Guatemala Campeon Mundial",
                "Vence a Brasil 4-0 en la final de la Copa del Mundo de la mano del Pescado Ruiz",
                "https://static.emisorasunidas.com/uploads/2019/09/Carlos-Ruiz-Gol-Chilena.jpg"))

        val listaNoticias: RecyclerView = findViewById(R.id.listaNoticias)
        listaNoticias.layoutManager = LinearLayoutManager(this)
        listaNoticias.adapter = adapter

    }
    override fun onItemClicked(position: Int) {
        adapter.removeItem(position)
    }
    override fun onItemLongClicked(position: Int): Boolean {
        val aux = Noticia(
                "Actualizado",
                "Actualizado",
                "https://i.kym-cdn.com/photos/images/newsfeed/001/688/917/f1e.jpg"
        )
        adapter.updateItem(position, aux)
        return true
    }
}