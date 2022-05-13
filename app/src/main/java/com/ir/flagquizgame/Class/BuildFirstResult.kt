package com.ir.flagquizgame.Class

import com.ir.flagquizgame.Data.FlagData
import com.ir.flagquizgame.Data.ResultData
import com.ir.flagquizgame.Data.TextHintData
import com.ir.flagquizgame.Data.UserData
import com.ir.flagquizgame.R

class BuildFirstResult {
    lateinit var dataList: ArrayList<UserData>
    lateinit var arrayListFlag: ArrayList<FlagData>
    lateinit var arrayListResult: ArrayList<ResultData>

    fun buildDataList(booleanSound: Boolean, coins: Int): ArrayList<UserData> {
        dataList = ArrayList()
        firstTimeWorkFlag()
        firstTimeWorkResult(arrayListFlag, booleanSound)
        dataList.add(UserData(arrayListFlag,
            arrayListResult,
            coins,
            defineTheWord(arrayListFlag[0].flagName)))
        return dataList
    }

    private fun firstTimeWorkFlag(): ArrayList<FlagData> {
        val afghanistan = R.drawable.afghanistan
        val alandIslands = R.drawable.aland_islands
        val albania = R.drawable.albania
        val algeria = R.drawable.algeria
        val andorra = R.drawable.andorra
        val unitedKingdom = R.drawable.anglii
        val angola = R.drawable.angola
        val argentina = R.drawable.argentina
        val armenia = R.drawable.armenia
        val australia = R.drawable.australia
        val austria = R.drawable.austria
        val azerbaijan = R.drawable.azerbaijan
        val bahrain = R.drawable.bahrain
        val bangladesh = R.drawable.bangladesh
        val barbados = R.drawable.barbados
        val belarus = R.drawable.belarus
        val belgium = R.drawable.belgium
        val belize = R.drawable.belize
        val benin = R.drawable.benin
        val bhutan = R.drawable.bhutan
        val bolivia = R.drawable.bolivia
        val botswana = R.drawable.botswana
        val brazil = R.drawable.brazil
        val brunei = R.drawable.brunei
        val caboVerde = R.drawable.cabo_verde
        val cambodia = R.drawable.cambodia
        val cameroon = R.drawable.cameroon
        val canada = R.drawable.canada
        val chad = R.drawable.chad
        val chile = R.drawable.chile
        val china = R.drawable.china
        val colombia = R.drawable.colombia
        val comoros = R.drawable.comoros
        val croatia = R.drawable.croatina
        val cuba = R.drawable.cuba
        val cyprus = R.drawable.cyprus
        val czechia = R.drawable.czechia
        val denmark = R.drawable.denmark
        val djibouti = R.drawable.djibouti
        val ecuador = R.drawable.ecuador
        val egypt = R.drawable.egypt
        val england = R.drawable.england
        val eritrea = R.drawable.eritrea
        val estonia = R.drawable.estonia
        val eswatini = R.drawable.eswatini
        val ethiopia = R.drawable.ethiopia
        val palestine = R.drawable.falastin
        val finland = R.drawable.finlandii
        val france = R.drawable.france
        val gabon = R.drawable.gabon
        val georgia = R.drawable.georgia
        val germany = R.drawable.germany
        val ghana = R.drawable.ghana
        val greece = R.drawable.greece
        val grenada = R.drawable.grenada
        val guatemala = R.drawable.guatemala
        val guinea = R.drawable.guinea
        val guyana = R.drawable.guyana
        val haiti = R.drawable.haiti
        val honduras = R.drawable.honduras
        val hungary = R.drawable.hungary
        val iceland = R.drawable.iceland
        val india = R.drawable.india
        val indonesia = R.drawable.indonesia
        val iran = R.drawable.iran
        val iraq = R.drawable.iraq
        val ireland = R.drawable.ireland
        val spain = R.drawable.ispanii
        val israel = R.drawable.israel
        val italy = R.drawable.italy
        val jamaica = R.drawable.jamaica
        val japan = R.drawable.japan
        val jordan = R.drawable.jordan
        val kazakhstan = R.drawable.kazakhstan
        val kenya = R.drawable.kenya
        val korea = R.drawable.korea
        val kosovo = R.drawable.kosovo
        val kuwait = R.drawable.kuwait
        val kyrgyzstan = R.drawable.kyrgyzstan
        val laos = R.drawable.laos
        val latvia = R.drawable.latvia
        val lebanon = R.drawable.lebanon
        val lesotho = R.drawable.lesotho
        val liberia = R.drawable.liberia
        val libya = R.drawable.libya
        val liechtenstein = R.drawable.liechtenstein
        val lithuania = R.drawable.lithuania
        val luxembourg = R.drawable.luxembourg
        val madagascar = R.drawable.madagascar
        val malawi = R.drawable.malawi
        val malaysia = R.drawable.malaysia
        val maldives = R.drawable.maldives
        val mali = R.drawable.mali
        val malta = R.drawable.malta
        val mauritania = R.drawable.mauritania
        val mauritius = R.drawable.mauritius
        val mexico = R.drawable.mexico
        val moldova = R.drawable.moldova
        val monaco = R.drawable.monaco
        val mongolia = R.drawable.mongolia
        val montenegro = R.drawable.montenegro
        val morocco = R.drawable.morocco
        val mozambique = R.drawable.mozambique
        val myanmar = R.drawable.myanmar
        val namibia = R.drawable.namibia
        val nepal = R.drawable.nepal
        val netherlands = R.drawable.netherlands
        val nicaragua = R.drawable.nicaragua
        val nigeria = R.drawable.nigeria
        val northKorea = R.drawable.north_korea
        val northMacedonia = R.drawable.north_macedonia
        val norway = R.drawable.norway
        val oman = R.drawable.oman
        val pakistan = R.drawable.pakistan
        val panama = R.drawable.panama
        val paraguay = R.drawable.paraguay
        val peru = R.drawable.peru
        val philippines = R.drawable.philippines
        val poland = R.drawable.poland
        val portugal = R.drawable.portugal
        val qatar = R.drawable.qatar
        val romania = R.drawable.romania
        val russia = R.drawable.russia
        val rwanda = R.drawable.rwanda
        val saudiArabia = R.drawable.saudia_arabiya
        val senegal = R.drawable.senegal
        val serbia = R.drawable.serbia
        val seychelles = R.drawable.seychelles
        val singapore = R.drawable.singapore
        val slovakia = R.drawable.slovakia
        val slovenia = R.drawable.slovenia
        val somalia = R.drawable.somalia
        val southAfrica = R.drawable.south_africa
        val southSudan = R.drawable.south_sudan
        val sriLanka = R.drawable.sri_lanka
        val sudan = R.drawable.sudan
        val suriname = R.drawable.suriname
        val sweden = R.drawable.sweden
        val switzerland = R.drawable.switzerland
        val syria = R.drawable.syria
        val taiwan = R.drawable.taiwan
        val tajikistan = R.drawable.tajikistan
        val tanzania = R.drawable.tanzania
        val thailand = R.drawable.thailand
        val togo = R.drawable.togo
        val tunisia = R.drawable.tunisia
        val turkey = R.drawable.turkey
        val turkmenistan = R.drawable.turkmenistan
        val uganda = R.drawable.uganda
        val ukraine = R.drawable.ukraine
        val uruguay = R.drawable.uruguay
        val usa = R.drawable.usa
        val uzbekistan = R.drawable.uzbekistan
        val venezuela = R.drawable.venezuela
        val vietnam = R.drawable.vietnam
        val yemen = R.drawable.yemen
        val zambia = R.drawable.zambia
        val zimbabwe = R.drawable.zimbabwe

        arrayListFlag = ArrayList()
        arrayListFlag.add(FlagData("north Macedonia", northMacedonia))
        arrayListFlag.add(FlagData("north Korea", northKorea))
        arrayListFlag.add(FlagData("albania", albania))
        arrayListFlag.add(FlagData("south Korea", korea))
        arrayListFlag.add(FlagData("andorra", andorra))
        arrayListFlag.add(FlagData("united Kingdom", unitedKingdom))
        arrayListFlag.add(FlagData("afghanistan", afghanistan))
        arrayListFlag.add(FlagData("liechtenstein", liechtenstein))
        arrayListFlag.add(FlagData("aland Islands", alandIslands))
        arrayListFlag.add(FlagData("algeria", algeria))
        arrayListFlag.add(FlagData("united States", usa))
        arrayListFlag.add(FlagData("angola", angola))
        arrayListFlag.add(FlagData("argentina", argentina))
        arrayListFlag.add(FlagData("armenia", armenia))
        arrayListFlag.add(FlagData("australia", australia))
        arrayListFlag.add(FlagData("austria", austria))
        arrayListFlag.add(FlagData("azerbaijan", azerbaijan))
        arrayListFlag.add(FlagData("bahrain", bahrain))
        arrayListFlag.add(FlagData("bangladesh", bangladesh))
        arrayListFlag.add(FlagData("barbados", barbados))
        arrayListFlag.add(FlagData("belarus", belarus))
        arrayListFlag.add(FlagData("belgium", belgium))
        arrayListFlag.add(FlagData("belize", belize))
        arrayListFlag.add(FlagData("benin", benin))
        arrayListFlag.add(FlagData("bhutan", bhutan))
        arrayListFlag.add(FlagData("bolivia", bolivia))
        arrayListFlag.add(FlagData("botswana", botswana))
        arrayListFlag.add(FlagData("brazil", brazil))
        arrayListFlag.add(FlagData("brunei", brunei))
        arrayListFlag.add(FlagData("cabo Verde", caboVerde))
        arrayListFlag.add(FlagData("cambodia", cambodia))
        arrayListFlag.add(FlagData("cameroon", cameroon))
        arrayListFlag.add(FlagData("canada", canada))
        arrayListFlag.add(FlagData("chad", chad))
        arrayListFlag.add(FlagData("chile", chile))
        arrayListFlag.add(FlagData("china", china))
        arrayListFlag.add(FlagData("colombia", colombia))
        arrayListFlag.add(FlagData("comoros", comoros))
        arrayListFlag.add(FlagData("croatia", croatia))
        arrayListFlag.add(FlagData("cuba", cuba))
        arrayListFlag.add(FlagData("cyprus", cyprus))
        arrayListFlag.add(FlagData("czechia", czechia))
        arrayListFlag.add(FlagData("denmark", denmark))
        arrayListFlag.add(FlagData("djibouti", djibouti))
        arrayListFlag.add(FlagData("ecuador", ecuador))
        arrayListFlag.add(FlagData("egypt", egypt))
        arrayListFlag.add(FlagData("england", england))
        arrayListFlag.add(FlagData("eritrea", eritrea))
        arrayListFlag.add(FlagData("estonia", estonia))
        arrayListFlag.add(FlagData("eswatini", eswatini))
        arrayListFlag.add(FlagData("ethiopia", ethiopia))
        arrayListFlag.add(FlagData("pakistan", pakistan))
        arrayListFlag.add(FlagData("palestine", palestine))
        arrayListFlag.add(FlagData("panama", panama))
        arrayListFlag.add(FlagData("paraguay", paraguay))
        arrayListFlag.add(FlagData("peru", peru))
        arrayListFlag.add(FlagData("philippines", philippines))
        arrayListFlag.add(FlagData("poland", poland))
        arrayListFlag.add(FlagData("portugal", portugal))
        arrayListFlag.add(FlagData("finland", finland))
        arrayListFlag.add(FlagData("france", france))
        arrayListFlag.add(FlagData("gabon", gabon))
        arrayListFlag.add(FlagData("georgia", georgia))
        arrayListFlag.add(FlagData("germany", germany))
        arrayListFlag.add(FlagData("ghana", ghana))
        arrayListFlag.add(FlagData("greece", greece))
        arrayListFlag.add(FlagData("grenada", grenada))
        arrayListFlag.add(FlagData("guatemala", guatemala))
        arrayListFlag.add(FlagData("guinea", guinea))
        arrayListFlag.add(FlagData("guyana", guyana))
        arrayListFlag.add(FlagData("iceland", iceland))
        arrayListFlag.add(FlagData("india", india))
        arrayListFlag.add(FlagData("indonesia", indonesia))
        arrayListFlag.add(FlagData("iran", iran))
        arrayListFlag.add(FlagData("iraq", iraq))
        arrayListFlag.add(FlagData("ireland", ireland))
        arrayListFlag.add(FlagData("israel", israel))
        arrayListFlag.add(FlagData("italy", italy))
        arrayListFlag.add(FlagData("madagascar", madagascar))
        arrayListFlag.add(FlagData("malawi", malawi))
        arrayListFlag.add(FlagData("malaysia", malaysia))
        arrayListFlag.add(FlagData("maldives", maldives))
        arrayListFlag.add(FlagData("mali", mali))
        arrayListFlag.add(FlagData("malta", malta))
        arrayListFlag.add(FlagData("mauritania", mauritania))
        arrayListFlag.add(FlagData("mauritius", mauritius))
        arrayListFlag.add(FlagData("mexico", mexico))
        arrayListFlag.add(FlagData("moldova", moldova))
        arrayListFlag.add(FlagData("monaco", monaco))
        arrayListFlag.add(FlagData("mongolia", mongolia))
        arrayListFlag.add(FlagData("montenegro", montenegro))
        arrayListFlag.add(FlagData("morocco", morocco))
        arrayListFlag.add(FlagData("mozambique", mozambique))
        arrayListFlag.add(FlagData("myanmar", myanmar))
        arrayListFlag.add(FlagData("haiti", haiti))
        arrayListFlag.add(FlagData("honduras", honduras))
        arrayListFlag.add(FlagData("hungary", hungary))
        arrayListFlag.add(FlagData("jamaica", jamaica))
        arrayListFlag.add(FlagData("japan", japan))
        arrayListFlag.add(FlagData("jordan", jordan))
        arrayListFlag.add(FlagData("kazakhstan", kazakhstan))
        arrayListFlag.add(FlagData("kenya", kenya))
        arrayListFlag.add(FlagData("kosovo", kosovo))
        arrayListFlag.add(FlagData("kuwait", kuwait))
        arrayListFlag.add(FlagData("kyrgyzstan", kyrgyzstan))
        arrayListFlag.add(FlagData("laos", laos))
        arrayListFlag.add(FlagData("latvia", latvia))
        arrayListFlag.add(FlagData("lebanon", lebanon))
        arrayListFlag.add(FlagData("lesotho", lesotho))
        arrayListFlag.add(FlagData("liberia", liberia))
        arrayListFlag.add(FlagData("libya", libya))
        arrayListFlag.add(FlagData("lithuania", lithuania))
        arrayListFlag.add(FlagData("luxembourg", luxembourg))
        arrayListFlag.add(FlagData("namibia", namibia))
        arrayListFlag.add(FlagData("nepal", nepal))
        arrayListFlag.add(FlagData("netherlands", netherlands))
        arrayListFlag.add(FlagData("nicaragua", nicaragua))
        arrayListFlag.add(FlagData("nigeria", nigeria))
        arrayListFlag.add(FlagData("norway", norway))
        arrayListFlag.add(FlagData("oman", oman))
        arrayListFlag.add(FlagData("qatar", qatar))
        arrayListFlag.add(FlagData("romania", romania))
        arrayListFlag.add(FlagData("russia", russia))
        arrayListFlag.add(FlagData("rwanda", rwanda))
        arrayListFlag.add(FlagData("taiwan", taiwan))
        arrayListFlag.add(FlagData("tajikistan", tajikistan))
        arrayListFlag.add(FlagData("tanzania", tanzania))
        arrayListFlag.add(FlagData("thailand", thailand))
        arrayListFlag.add(FlagData("togo", togo))
        arrayListFlag.add(FlagData("tunisia", tunisia))
        arrayListFlag.add(FlagData("turkey", turkey))
        arrayListFlag.add(FlagData("turkmenistan", turkmenistan))
        arrayListFlag.add(FlagData("saudi Arabia", saudiArabia))
        arrayListFlag.add(FlagData("senegal", senegal))
        arrayListFlag.add(FlagData("serbia", serbia))
        arrayListFlag.add(FlagData("seychelles", seychelles))
        arrayListFlag.add(FlagData("singapore", singapore))
        arrayListFlag.add(FlagData("slovenia", slovenia))
        arrayListFlag.add(FlagData("somalia", somalia))
        arrayListFlag.add(FlagData("south Africa", southAfrica))
        arrayListFlag.add(FlagData("south Sudan", southSudan))
        arrayListFlag.add(FlagData("spain", spain))
        arrayListFlag.add(FlagData("sri Lanka", sriLanka))
        arrayListFlag.add(FlagData("sudan", sudan))
        arrayListFlag.add(FlagData("suriname", suriname))
        arrayListFlag.add(FlagData("sweden", sweden))
        arrayListFlag.add(FlagData("switzerland", switzerland))
        arrayListFlag.add(FlagData("syria", syria))
        arrayListFlag.add(FlagData("uganda", uganda))
        arrayListFlag.add(FlagData("ukraine", ukraine))
        arrayListFlag.add(FlagData("uruguay", uruguay))
        arrayListFlag.add(FlagData("yemen", yemen))
        arrayListFlag.add(FlagData("zambia", zambia))
        arrayListFlag.add(FlagData("zimbabwe", zimbabwe))
        arrayListFlag.add(FlagData("vietnam", vietnam))
        arrayListFlag.add(FlagData("venezuela", venezuela))
        arrayListFlag.add(FlagData("slovakia", slovakia))
        arrayListFlag.shuffle()
        arrayListFlag.add(FlagData("uzbekistan", uzbekistan))
        arrayListFlag.reverse()
        return arrayListFlag
    }

    fun firstTimeWorkResult(
        arrayList: ArrayList<FlagData>,
        booleanSound: Boolean,
    ): ArrayList<ResultData> {
        arrayListResult = ArrayList()
        val boolean = defineTheWord(arrayList[0].flagName)
        if (boolean) {
            arrayListResult = forDoubleWord(arrayList[0].flagName)
        } else {
            val arrayListWord = buildWord(arrayList[0].flagName)
            val arrayListWord2 = buildWord("")
            val arrayListChar = buildChar(arrayList[0].flagName)
            arrayListResult.add(ResultData(arrayListWord, arrayListWord2, arrayListChar, -1, true))
        }
        arrayListResult[0].booleanSound = booleanSound
        return arrayListResult
    }

    private fun forDoubleWord(string: String): ArrayList<ResultData> {
        val arrayList = ArrayList<ResultData>()
        var boolean = false
        var word1 = ""
        var word2 = ""
        for (i in string) {
            if (i.toString() == " ") {
                boolean = true
            }
            if (boolean && i.toString() != " ") {
                word2 += i.toString()
            }
            if (!boolean && i.toString() != " ") {
                word1 += i.toString()
            }
        }
        val arrayListWord = buildWord(word1)
        val arrayListWord2 = buildWord(word2)
        val arrayListChar = buildChar(string)
        arrayList.add(ResultData(arrayListWord, arrayListWord2, arrayListChar, -1, true))
        return arrayList
    }

    fun defineTheWord(string: String): Boolean {
        var boolean = false
        for (i in string) {
            if (i.toString() == " ") {
                boolean = true
            }
        }
        return boolean
    }

    fun buildWord(string: String): ArrayList<TextHintData> {
        val arrayList = ArrayList<TextHintData>()
        for (i in string.indices) {
            arrayList.add(TextHintData("", ""))
        }
        return arrayList
    }

    fun buildChar(string: String): ArrayList<String> {
        val arrayList = ArrayList<String>()
        val randomChars = "QWERTYUIOPASDFGHJKLZXCVBNM"
        for (k in string) {
            if (k.toString() != " ") {
                arrayList.add(k.toString().uppercase())
            }
        }
        while (true) {
            arrayList.add(randomChars[(Math.random() * 25).toInt()].toString().uppercase())
            if (arrayList.size == 20) {
                break
            }
        }
        arrayList.shuffle()
        return arrayList
    }
}