package com.example.clothing_suggestor.data

import com.example.clothing_suggestor.ClotheImage
import com.example.clothing_suggestor.R

object DataManager {

    private val listSummer1=mutableListOf(
        ClotheImage(R.drawable.summer_tshirt1)
        , ClotheImage(R.drawable.pants2)
        , ClotheImage(R.drawable.summer_tshirt2)
        , ClotheImage(R.drawable.pants1)

    )
    private val listSummer2=mutableListOf(
        ClotheImage(R.drawable.summer_tshirt3)
        , ClotheImage(R.drawable.pants4)
        , ClotheImage(R.drawable.summer_tshirt4)
        , ClotheImage(R.drawable.pants3)
    )
    private val listSummer3=mutableListOf(
        ClotheImage(R.drawable.summer_tshirt5)
        , ClotheImage(R.drawable.pants3)
        , ClotheImage(R.drawable.summer_tshirt6)
        , ClotheImage(R.drawable.pants4)
    )
    val summerLists= mutableListOf(listSummer1, listSummer2, listSummer3)

    private val listWinter1=mutableListOf(
        ClotheImage(R.drawable.winter_clothe1)
        , ClotheImage(R.drawable.pants2)
        , ClotheImage(R.drawable.winter_clothe3)
        , ClotheImage(R.drawable.pants4)
    )
    private val listWinter2=mutableListOf(
        ClotheImage(R.drawable.winter_clothe4)
        , ClotheImage(R.drawable.pants1)
        , ClotheImage(R.drawable.winter_clothe2)
        , ClotheImage(R.drawable.pants3)
    )
    private val listWinter3=mutableListOf(
        ClotheImage(R.drawable.winter_clothe6)
        , ClotheImage(R.drawable.pants3)
        , ClotheImage(R.drawable.winter_clothe5)
        , ClotheImage(R.drawable.pants2)
    )
    val winterLists= mutableListOf(listWinter1, listWinter2, listWinter3)


}