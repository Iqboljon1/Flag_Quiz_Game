package com.ir.flagquizgame.Data

data class ResultData(
    var resultWord: ArrayList<TextHintData>,
    var resultWord2: ArrayList<TextHintData>,
    var resultChars: ArrayList<String>,
    var helpWordCount: Int,
    var booleanSound: Boolean
)