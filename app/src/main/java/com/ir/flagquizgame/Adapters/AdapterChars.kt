package com.ir.flagquizgame.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ir.flagquizgame.Data.TextHintData
import com.ir.flagquizgame.Interface.MyOnClickListener
import com.ir.flagquizgame.databinding.DinamikView2Binding

class AdapterChars(
    val context: Context,
    private val arrayListChars: ArrayList<String>,
    private val arrayListWord: ArrayList<TextHintData>,
    private val arrayListWord2: ArrayList<TextHintData>,
    val myOnClickListener: MyOnClickListener,
    private val booleanRecyclerView: Boolean,
) :
    RecyclerView.Adapter<AdapterChars.VH>() {

    var booleanForAddWord2 = false

    inner class VH(private var itemRV: DinamikView2Binding) : RecyclerView.ViewHolder(itemRV.root) {
        fun onBind(string: String, position: Int) {
            var antiBagBoolean = true
            itemRV.tvChar.text = string
            itemRV.root.setOnClickListener {
                val positionWord = buildWordPosition()
                if (antiBagBoolean && positionWord != -1 && string.isNotEmpty()) {
                    antiBagBoolean = false
                    if (!booleanForAddWord2) {
                        arrayListWord[positionWord].stringText = string
                    } else {
                        arrayListWord2[positionWord].stringText = string
                    }
                    arrayListChars[position] = ""
                    myOnClickListener.onClick(string,
                        arrayListWord,
                        arrayListWord2,
                        arrayListChars,
                        positionWord,
                        position, booleanForAddWord2)
                    booleanForAddWord2 = false
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(DinamikView2Binding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(arrayListChars[position], position)
    }

    override fun getItemCount(): Int = arrayListChars.size

    fun buildWordPosition(): Int {
        var position = -1
        if (booleanRecyclerView) {
            var boolean = false
            for (i in 0 until arrayListWord.size) {
                if (arrayListWord[i].stringText.isEmpty()) {
                    position = i
                    boolean = true
                    break
                }
            }
            if (!boolean) {
                for (k in 0 until arrayListWord2.size) {
                    if (arrayListWord2[k].stringText.isEmpty()) {
                        position = k
                        booleanForAddWord2 = true
                        break
                    }
                }
            }
        } else {
            for (i in 0 until arrayListWord.size) {
                if (arrayListWord[i].stringText.isEmpty()) {
                    position = i
                    break
                }
            }
        }
        return position
    }
}