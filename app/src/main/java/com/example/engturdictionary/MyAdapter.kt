package com.example.engturdictionary

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val context: Context, private val wordList: List<Word>) :
    RecyclerView.Adapter<MyAdapter.CardViewHolder>()
{

    inner class CardViewHolder(design: View) : RecyclerView.ViewHolder(design) {

        var cardView: CardView
        var textViewEng: TextView
        var textViewTur: TextView

        init {
            cardView = design.findViewById(R.id.cardView)
            textViewEng = design.findViewById(R.id.textViewEng)
            textViewTur = design.findViewById(R.id.textViewTur)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_design, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val data = wordList[position]
        holder.textViewEng.text = data.wordEng
        holder.textViewTur.text = data.wordTur

        holder.cardView.setOnClickListener{
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("word", data)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return wordList.size
    }
}
