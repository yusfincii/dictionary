package com.example.engturdictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.engturdictionary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , SearchView.OnQueryTextListener {

    private lateinit var main : ActivityMainBinding

    private lateinit var wordList : ArrayList<Word>
    private lateinit var adapter : MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        main.toolbar.title = " English - Turkish Dictionary "
        setSupportActionBar(main.toolbar)

        main.recyclerView.setHasFixedSize(true)
        main.recyclerView.layoutManager = LinearLayoutManager(this)

        wordList = ArrayList()

        val w1 = Word(1, "suspend", "askiya almak")
        val w2 = Word(2, "asset", "varlik - mal")
        val w3 = Word(3, "deploy", "dagitim - yaymak")

        wordList.add(w1)
        wordList.add(w2)
        wordList.add(w3)

        adapter = MyAdapter(this, wordList)

        main.recyclerView.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)

        val item = menu?.findItem(R.id.action_search)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    // on each pressed submit
    override fun onQueryTextSubmit(query: String?): Boolean {
        Log.e("submit", query.toString())
        return true
    }

    // on each text change
    override fun onQueryTextChange(newText: String?): Boolean {
        Log.e("change", newText.toString())
        return true
    }
}