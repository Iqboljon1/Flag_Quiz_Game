package com.ir.flagquizgame.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ir.flagquizgame.Data.TextHintData
import com.ir.flagquizgame.Interface.MyOnClickListener
import com.ir.flagquizgame.databinding.DinamikViewBinding

class AdapterWord2(
    val context: Context,
    private var arrayListWord2: ArrayList<TextHintData>,
    private var arrayListWord: ArrayList<TextHintData>,
    private var arrayListChars: ArrayList<String>,
    val myOnClickListener: MyOnClickListener,
    private val booleanRecyclerView: Boolean,
) :
    RecyclerView.Adapter<AdapterWord2.VH>() {

    inner class VH(var itemRV: DinamikViewBinding) : RecyclerView.ViewHolder(itemRV.root) {
        fun onBind(stringText: String, stringHint: String , position: Int) {
            var antiBagBoolean = true
            itemRV.tvChar.text = stringText
            itemRV.tvChar.hint = stringHint
            itemRV.root.setOnClickListener {
                val positionChars = buildCharsPosition()
                if (antiBagBoolean && positionChars != -1 && stringText.isNotEmpty()) {
                    antiBagBoolean = false
                    arrayListChars[positionChars] = stringText
                    arrayListWord2[position].stringText = ""
                    myOnClickListener.onClick(stringText,
                        arrayListWord,
                        arrayListWord2,
                        arrayListChars,
                        position,
                        positionChars, booleanRecyclerView)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(DinamikViewBinding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(arrayListWord2[position].stringText, arrayListWord2[position].stringHint , position)
    }

    override fun getItemCount(): Int = arrayListWord2.size

    fun buildCharsPosition(): Int {
        var position = -1
        for (i in 0 until arrayListChars.size) {
            if (arrayListChars[i].isEmpty()) {
                position = i
                break
            }
        }
        return position
    }

}