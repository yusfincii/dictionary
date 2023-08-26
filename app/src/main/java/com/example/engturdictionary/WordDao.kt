package com.example.engturdictionary

class WordDao()
{
    fun getAllWords(db:DatabaseHelper) : ArrayList<Word>
    {
        val words = ArrayList<Word>()

        val db = db.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM word", null)

        while (cursor.moveToNext()){
            val word = Word(
                cursor.getInt(cursor.getColumnIndexOrThrow("word_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("word_eng")),
                cursor.getString(cursor.getColumnIndexOrThrow("word_tur"))
            )

            words.add(word)
        }
        db.close()
        return words
    }

    fun searchWord(db:DatabaseHelper, wordEng:String) : ArrayList<Word>
    {
        val word = ArrayList<Word>()

        val db = db.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM word WHERE word_eng like '%$wordEng%'", null)

        while (cursor.moveToNext()){
            val wordX = Word(
                cursor.getInt(cursor.getColumnIndexOrThrow("word_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("word_eng")),
                cursor.getString(cursor.getColumnIndexOrThrow("word_tur"))
            )
            word.add(wordX)
        }
        db.close()
        return word
    }



}