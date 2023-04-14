package com.example.clothing_suggestor.data

import com.example.clothing_suggestor.ClotheImage
import com.example.clothing_suggestor.R

object DataManager {

    val listSummer1=mutableListOf(
        ClotheImage(R.drawable.summer_tshirt1)
        , ClotheImage(R.drawable.summer_tshirt2)
        , ClotheImage(R.drawable.pants2)
        , ClotheImage(R.drawable.pants4)
        , ClotheImage(R.drawable.summer_tshirt5)
        , ClotheImage(R.drawable.summer_tshirt6)
        , ClotheImage(R.drawable.pants1)
        , ClotheImage(R.drawable.pants3)
    )
    val listSummer2=mutableListOf(
        ClotheImage(R.drawable.summer_tshirt3)
        , ClotheImage(R.drawable.summer_tshirt4)
        , ClotheImage(R.drawable.pants4)
        , ClotheImage(R.drawable.pants3)
        , ClotheImage(R.drawable.summer_tshirt5)
        , ClotheImage(R.drawable.summer_tshirt6)
        , ClotheImage(R.drawable.pants2)
        , ClotheImage(R.drawable.pants4)
    )
    val listSummer3=mutableListOf(
        ClotheImage(R.drawable.summer_tshirt8)
        , ClotheImage(R.drawable.summer_tshirt7)
        , ClotheImage(R.drawable.pants1)
        , ClotheImage(R.drawable.pants3)
        , ClotheImage(R.drawable.summer_tshirt5)
        , ClotheImage(R.drawable.summer_tshirt6)
        , ClotheImage(R.drawable.pants2)
        , ClotheImage(R.drawable.pants4)
    )
    val summerLists= mutableListOf(listSummer1, listSummer2, listSummer3)

    val listWinter1=mutableListOf(
        ClotheImage(R.drawable.winter_clothe1)
        , ClotheImage(R.drawable.winter_clothe3)
        , ClotheImage(R.drawable.pants2)
        , ClotheImage(R.drawable.pants4)
        , ClotheImage(R.drawable.winter_jacket)
        , ClotheImage(R.drawable.winter_jacket)
        , ClotheImage(R.drawable.pants1)
        , ClotheImage(R.drawable.pants3)
    )
    val listWinter2=mutableListOf(
        ClotheImage(R.drawable.winter_clothe4)
        , ClotheImage(R.drawable.winter_clothe2)
        , ClotheImage(R.drawable.pants1)
        , ClotheImage(R.drawable.pants3)
        , ClotheImage(R.drawable.winter_jacket)
        , ClotheImage(R.drawable.winter_jacket)
        , ClotheImage(R.drawable.pants1)
        , ClotheImage(R.drawable.pants3)
    )
    val listWinter3=mutableListOf(
        ClotheImage(R.drawable.winter_clothe6)
        , ClotheImage(R.drawable.winter_clothe5)
        , ClotheImage(R.drawable.pants3)
        , ClotheImage(R.drawable.pants2)
        , ClotheImage(R.drawable.winter_jacket)
        , ClotheImage(R.drawable.winter_jacket)
        , ClotheImage(R.drawable.pants1)
        , ClotheImage(R.drawable.pants4)
    )
    val winterLists= mutableListOf(listWinter1, listWinter2, listWinter3)


}