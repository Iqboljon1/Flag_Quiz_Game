package com.ir.flagquizgame.Interface

import com.ir.flagquizgame.Data.TextHintData

interface MyOnClickListener {
    fun onClick(
        string: String,
        arrayListWord: ArrayList<TextHintData>,
        arrayListWord2: ArrayList<TextHintData>,
        arrayListChars: ArrayList<String>,
        positionWord: Int,
        positionChars: Int,
        booleanRecyclerView: Boolean,
    ) {

    }
}