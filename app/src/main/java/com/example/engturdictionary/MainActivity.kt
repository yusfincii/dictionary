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

    private lateinit var db : DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        main.toolbar.title = " English - Turkish Dictionary "
        setSupportActionBar(main.toolbar)

        main.recyclerView.setHasFixedSize(true)
        main.recyclerView.layoutManager = LinearLayoutManager(this)

        copyDatabase()
        db = DatabaseHelper(this)
        wordList = WordDao().getAllWords(db)

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

    // on each time pressed submit
    override fun onQueryTextSubmit(query: String): Boolean {
        search(query)
        Log.e("submit", query.toString())
        return true
    }

    // on each time text changed
    override fun onQueryTextChange(newText: String): Boolean {
        search(newText)
        Log.e("change", newText.toString())
        return true
    }

    private fun copyDatabase(){
        // object from database copy helper class
        val dbCopyHelper = DatabaseCopyHelper(this)
        try {
            dbCopyHelper.createDataBase()
            dbCopyHelper.openDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    private fun search(wordEng : String){
        wordList = WordDao().searchWord(db, wordEng)
        adapter = MyAdapter(this, wordList)
        main.recyclerView.adapter = adapter
    }
}