package com.example.engturdictionary

import java.io.Serializable

data class Word(var wordId:Int, var wordEng:String, var wordTur:String) : Serializable
{

}