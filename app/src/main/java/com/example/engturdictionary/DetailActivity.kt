package com.example.engturdictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.engturdictionary.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var detail : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detail = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detail.root)

        val word = intent.getSerializableExtra("word") as Word

        detail.textViewDetailEng.text = word.wordEng
        detail.textViewDetailTur.text = word.wordTur
    }
}