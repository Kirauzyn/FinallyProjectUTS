package com.example.finallyprojectuts.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.finallyprojectuts.Komik
import com.example.finallyprojectuts.R

class komikAdapter (private val context: Context, private val komikList: ArrayList<Komik>, val listener: (Komik) -> Unit): RecyclerView.Adapter<komikAdapter.komikViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): komikViewHolder{
    val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_komik, parent, false)
    return komikViewHolder(itemView)}

    override fun onBindViewHolder(holder: komikViewHolder, position: Int) {
        val currentItem = komikList[position]
        holder.imgKomik.setImageResource(currentItem.imgKomik)

        holder.titleKomik.text = (currentItem.nameKomik)
        holder.descKomik.text = (currentItem.descKomik)

        holder.bindView(komikList[position], listener)

    }

    override fun getItemCount(): Int {
        return komikList.size
    }

    class komikViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val imgKomik : ImageView= itemView.findViewById(R.id.ivPhoto)
        val titleKomik : TextView =  itemView.findViewById(R.id.tvJudul)
        val descKomik : TextView = itemView.findViewById(R.id.tvDesc)

        fun bindView(komik: Komik, listener: (Komik) -> Unit){
            imgKomik.setImageResource(komik.imgKomik)

            titleKomik.text = komik.nameKomik
            descKomik.text = komik.descKomik
            itemView.setOnClickListener{
                listener(komik)
            }
        }
    }

}
