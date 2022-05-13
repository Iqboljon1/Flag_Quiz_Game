package com.ir.flagquizgame

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.flexbox.*
import com.ir.flagquizgame.Adapters.AdapterChars
import com.ir.flagquizgame.Adapters.AdapterWord
import com.ir.flagquizgame.Adapters.AdapterWord2
import com.ir.flagquizgame.Class.BuildFirstResult
import com.ir.flagquizgame.Data.FlagData
import com.ir.flagquizgame.Data.ResultData
import com.ir.flagquizgame.Data.TextHintData
import com.ir.flagquizgame.Data.UserData
import com.ir.flagquizgame.Interface.MyOnClickListener
import com.ir.flagquizgame.MyShare.MyShare
import com.ir.flagquizgame.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    lateinit var dataList: ArrayList<UserData>
    lateinit var arrayListFlag: ArrayList<FlagData>
    lateinit var arrayListResult: ArrayList<ResultData>
    private lateinit var adapterChars: AdapterChars
    private lateinit var adapterWord: AdapterWord
    private lateinit var adapterWord2: AdapterWord2
    private var coins: Int = -1
    private var booleanSound: Boolean = true
    var booleanRecyclerView = false
    var helpWordCount: Int = 0
    lateinit var animOpened: Animation
    lateinit var animClosed: Animation
    lateinit var animEnter: Animation
    lateinit var animExit: Animation
    lateinit var animShow: Animation
    lateinit var nextStepDialog: AlertDialog
    lateinit var finalStepDialog: AlertDialog
    lateinit var binding: FragmentGameBinding
    lateinit var soundNegative: MediaPlayer
    lateinit var soundPositive: MediaPlayer

    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentGameBinding.inflate(layoutInflater)
        MyShare.init(requireActivity())
        createBase()
        showActivity()
        setAnimation(R.anim.anim_show)

        binding.cardHelpWord.setOnClickListener {
            if (coins > 4) {
                if (!booleanRecyclerView) {
                    if (arrayListFlag[0].flagName.length - 1 != helpWordCount) {
                        helpWordCount += 1
                        arrayListResult[0].helpWordCount = helpWordCount
                        addHelpWords()
                        buildWord()
                        buildWord2()
                        if (booleanSound) {
                            val mediaPlayerHelpWord = MediaPlayer.create(requireActivity(), R.raw.sound_help_word)
                            mediaPlayerHelpWord.start()
                            mediaPlayerHelpWord.setOnCompletionListener {
                                mediaPlayerHelpWord.release()
                            }
                        }
                        coins -= 5
                        binding.tvCoinsMa2.text = coins.toString()
                    }
                } else {
                    if (arrayListFlag[0].flagName.length - 2 != helpWordCount) {
                        helpWordCount += 1
                        arrayListResult[0].helpWordCount = helpWordCount
                        addHelpWords()
                        buildWord()
                        buildWord2()
                        if (booleanSound) {
                            val mediaPlayerHelpWord = MediaPlayer.create(requireActivity(), R.raw.sound_help_word)
                            mediaPlayerHelpWord.start()
                            mediaPlayerHelpWord.setOnCompletionListener {
                                mediaPlayerHelpWord.release()
                            }
                        }
                        coins -= 5
                        binding.tvCoinsMa2.text = coins.toString()
                    }
                }
            } else {
                binding.tvCoinsMa2.startAnimation(animOpened)
                animOpened.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation?) {
                        binding.tvCoinsMa2.setTextColor(Color.parseColor("#FF0000"))
                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        binding.tvCoinsMa2.setTextColor(Color.WHITE)

                    }

                    override fun onAnimationRepeat(animation: Animation?) {
                        TODO("Not yet implemented")
                    }
                })
            }
        }

        binding.imageBack.setOnClickListener {
            if (booleanSound) {
                val mediaPlayerPlay = MediaPlayer.create(requireActivity(), R.raw.sound_play)
                mediaPlayerPlay.start()
                mediaPlayerPlay.setOnCompletionListener {
                    mediaPlayerPlay.release()
                }
            }
            findNavController().popBackStack()
        }

        return binding.root
    }

    private fun setAnimation(int: Int) {
        val anim0 = AnimationUtils.loadAnimation(requireActivity(), int)
        val anim1 = AnimationUtils.loadAnimation(requireActivity(), int)
        val anim2 = AnimationUtils.loadAnimation(requireActivity(), int)
        val anim3 = AnimationUtils.loadAnimation(requireActivity(), int)
        binding.imageFlag.startAnimation(anim0)
        binding.recyclerviewWord.startAnimation(anim1)
        binding.recyclerviewWord2.startAnimation(anim2)
        binding.recyclerviewChars.startAnimation(anim3)

        if (int == R.anim.anim_exit) {
            anim0.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {
                    if (booleanSound) {
                        val mediaPlayerRight = MediaPlayer.create(requireActivity(), R.raw.sound_navigation_right)
                        mediaPlayerRight.start()
                        mediaPlayerRight.setOnCompletionListener {
                            mediaPlayerRight.release()
                        }
                    }
                }

                override fun onAnimationEnd(animation: Animation?) {
                    showActivity()
                    setAnimation(R.anim.anim_enter)
                    if (booleanSound) {
                        val mediaPlayerLeft = MediaPlayer.create(requireActivity(), R.raw.sound_navigation_left)
                        mediaPlayerLeft.start()
                        mediaPlayerLeft.setOnCompletionListener {
                            mediaPlayerLeft.release()
                        }
                    }
                }

                override fun onAnimationRepeat(animation: Animation?) {}
            })
        }

    }

    @SuppressLint("SetTextI18n")
    private fun showActivity() {
        binding.tvCoinsMa2.text = coins.toString()
        binding.imageFlag.setImageResource(arrayListFlag[0].flagPicture)
        binding.tvLevel.text = "${(158 - arrayListFlag.size)}/158"
        try {
            binding.lyHelp.setBackgroundResource(R.drawable.gradient_play)
            binding.lyHelpCorners.setBackgroundResource(R.drawable.gradient_help)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        binding.cardLevel.radius = (getHeightOfView(binding.cardLevel) / 2).toFloat()
        binding.cardCoins.radius = (getHeightOfView(binding.cardCoins) / 2).toFloat()
        binding.cardHelpWord.radius = (getHeightOfView(binding.cardHelpWord) / 2).toFloat()

        if (booleanRecyclerView) {
            buildWord2()
        } else {
            binding.recyclerviewWord2.adapter = null
        }

        buildWord()
        buildChars()
    }

    private fun buildChars() {
        binding.recyclerviewChars.layoutManager = GridLayoutManager(requireActivity(), 5)
        adapterChars = AdapterChars(requireActivity(),
            arrayListResult[0].resultChars,
            arrayListResult[0].resultWord,
            arrayListResult[0].resultWord2,
            object : MyOnClickListener {
                override fun onClick(
                    string: String,
                    arrayListWord: ArrayList<TextHintData>,
                    arrayListWord2: ArrayList<TextHintData>,
                    arrayListChars: ArrayList<String>,
                    positionWord: Int,
                    positionChars: Int,
                    booleanRecyclerView: Boolean,
                ) {
                    arrayListResult[0].resultChars = arrayListChars
                    binding.recyclerviewChars.adapter!!.notifyItemChanged(positionChars)
                    if (booleanRecyclerView) {
                        arrayListResult[0].resultWord2 = arrayListWord2
                        binding.recyclerviewWord2.adapter!!.notifyItemChanged(positionWord)
                    } else {
                        arrayListResult[0].resultWord = arrayListWord
                        binding.recyclerviewWord.adapter!!.notifyItemChanged(positionWord)
                    }
                    if (booleanSound) {
                        val mediaPlayerTab = MediaPlayer.create(requireActivity(), R.raw.sound_tab)
                        mediaPlayerTab.start()
                        mediaPlayerTab.setOnCompletionListener {
                            mediaPlayerTab.release()
                        }
                    }
                    answerInspection()
                }
            }, booleanRecyclerView)
        binding.recyclerviewChars.adapter = adapterChars
    }

    private fun buildWord() {
        val flexboxLayoutManager = FlexboxLayoutManager(requireActivity())
        flexboxLayoutManager.justifyContent = JustifyContent.CENTER
        flexboxLayoutManager.alignItems = AlignItems.CENTER
        flexboxLayoutManager.flexDirection = FlexDirection.ROW
        flexboxLayoutManager.flexWrap = FlexWrap.WRAP
        binding.recyclerviewWord.layoutManager = flexboxLayoutManager
        adapterWord = AdapterWord(requireActivity(),
            arrayListResult[0].resultWord,
            arrayListResult[0].resultWord2,
            arrayListResult[0].resultChars,
            object : MyOnClickListener {
                override fun onClick(
                    string: String,
                    arrayListWord: ArrayList<TextHintData>,
                    arrayListWord2: ArrayList<TextHintData>,
                    arrayListChars: ArrayList<String>,
                    positionWord: Int,
                    positionChars: Int,
                    booleanRecyclerView: Boolean,
                ) {
                    arrayListResult[0].resultWord = arrayListWord
                    arrayListResult[0].resultChars = arrayListChars
                    binding.recyclerviewWord.adapter!!.notifyItemChanged(positionWord)
                    binding.recyclerviewChars.adapter!!.notifyItemChanged(positionChars)
                    if (booleanSound) {
                        val mediaPlayerTab = MediaPlayer.create(requireActivity(), R.raw.sound_tab)
                        mediaPlayerTab.start()
                        mediaPlayerTab.setOnCompletionListener {
                            mediaPlayerTab.release()
                        }
                    }
                }
            }, booleanRecyclerView)
        binding.recyclerviewWord.adapter = adapterWord
    }

    private fun buildWord2() {
        val flexboxLayoutManager = FlexboxLayoutManager(requireActivity())
        flexboxLayoutManager.justifyContent = JustifyContent.CENTER
        flexboxLayoutManager.alignItems = AlignItems.CENTER
        flexboxLayoutManager.flexDirection = FlexDirection.ROW
        flexboxLayoutManager.flexWrap = FlexWrap.WRAP
        binding.recyclerviewWord2.layoutManager = flexboxLayoutManager
        adapterWord2 = AdapterWord2(requireActivity(),
            arrayListResult[0].resultWord2,
            arrayListResult[0].resultWord,
            arrayListResult[0].resultChars,
            object : MyOnClickListener {
                override fun onClick(
                    string: String,
                    arrayListWord: ArrayList<TextHintData>,
                    arrayListWord2: ArrayList<TextHintData>,
                    arrayListChars: ArrayList<String>,
                    positionWord: Int,
                    positionChars: Int,
                    booleanRecyclerView: Boolean,
                ) {
                    arrayListResult[0].resultWord2 = arrayListWord2
                    arrayListResult[0].resultChars = arrayListChars
                    binding.recyclerviewChars.adapter!!.notifyItemChanged(positionChars)
                    binding.recyclerviewWord2.adapter!!.notifyItemChanged(positionWord)
                    if (booleanSound) {
                        val mediaPlayerTab = MediaPlayer.create(requireActivity(), R.raw.sound_tab)
                        mediaPlayerTab.start()
                        mediaPlayerTab.setOnCompletionListener {
                            mediaPlayerTab.release()
                        }
                    }
                }
            },
            booleanRecyclerView)
        binding.recyclerviewWord2.adapter = adapterWord2
    }

    private fun createBase() {
        dataList = ArrayList()
        arrayListFlag = ArrayList()
        arrayListResult = ArrayList()
        dataList.addAll(MyShare.dataList!!)

        arrayListFlag = dataList[0].arrayListFlag
        arrayListResult = dataList[0].arrayListResult
        coins = dataList[0].coins
        booleanRecyclerView = dataList[0].boolean
        helpWordCount = arrayListResult[0].helpWordCount
        if (helpWordCount != -1) {
            addHelpWords()
        }

        soundNegative = MediaPlayer.create(requireActivity(), R.raw.sound_negative)
        soundPositive = MediaPlayer.create(requireActivity(), R.raw.sound_positive)
        animOpened = AnimationUtils.loadAnimation(requireActivity(), R.anim.anim_opened)
        animClosed = AnimationUtils.loadAnimation(requireActivity(), R.anim.anim_closed)
        animEnter = AnimationUtils.loadAnimation(requireActivity(), R.anim.anim_enter)
        animExit = AnimationUtils.loadAnimation(requireActivity(), R.anim.anim_exit)
        animShow = AnimationUtils.loadAnimation(requireActivity(), R.anim.anim_show)
        booleanSound = arrayListResult[0].booleanSound
    }

    private fun addHelpWords() {
        for (i in 0..helpWordCount) {
            if (arrayListResult[0].resultWord.size > i) {
                arrayListResult[0].resultWord[i].stringHint =
                    arrayListFlag[0].flagName[i].toString().uppercase()
            } else {
                arrayListResult[0].resultWord2[i - arrayListResult[0].resultWord.size].stringHint =
                    arrayListFlag[0].flagName[i + 1].toString().uppercase()
            }
        }
    }

    private fun answerInspection() {
        var answer = ""
        var correctAnswer = ""

        for (i in arrayListResult[0].resultWord) {
            answer += i.stringText
        }

        for (i in arrayListResult[0].resultWord2) {
            answer += i.stringText
        }

        for (k in arrayListFlag[0].flagName) {
            if (k.toString() != " ") {
                correctAnswer += k.toString().uppercase()
            }
        }

        if (correctAnswer == answer) {
            if (booleanSound) {
                soundPositive.start()
            }
            binding.imageAnswer.setImageResource(R.drawable.correct)
            arrayListFlag.removeAt(0)
            if (arrayListFlag.isNotEmpty()) {
                buildNextStepDialog()
                nextStepDialog.show()
            } else {
                buildFinalStepDialog()
                finalStepDialog.show()
            }
        } else {
            if (correctAnswer.length == answer.length) {
                if (booleanSound) {
                    soundNegative.start()
                }
                binding.imageAnswer.setImageResource(R.drawable.nocorrect)
            }
        }

        if (correctAnswer.length == answer.length) {
            binding.imageAnswer.visibility = View.VISIBLE
            binding.imageAnswer.startAnimation(animOpened)
        }
        animOpened.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.imageAnswer.startAnimation(animClosed)
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        })
        animClosed.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.imageAnswer.visibility = View.INVISIBLE
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }
        })
    }

    private fun buildNextStepDialog() {
        val view = layoutInflater.inflate(R.layout.dialog_great, null, false)
        val playAgain = view.findViewById<TextView>(R.id.btn_dialog_play_again)
        val alertDialog = AlertDialog.Builder(requireActivity())
        val buildFirstResult = BuildFirstResult()
        arrayListResult = buildFirstResult.firstTimeWorkResult(arrayListFlag, booleanSound)
        booleanRecyclerView = buildFirstResult.defineTheWord(arrayListFlag[0].flagName)
        helpWordCount = arrayListResult[0].helpWordCount


        playAgain.setOnClickListener {
            nextStepDialog.cancel()
        }

        alertDialog.setOnCancelListener {
            setAnimation(R.anim.anim_exit)
            coins += 15
        }

        alertDialog.setView(view)
        nextStepDialog = alertDialog.create()
        nextStepDialog.window!!.attributes.windowAnimations = R.style.MyAnimation
        nextStepDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    }

    private fun buildFinalStepDialog() {
        val view = layoutInflater.inflate(R.layout.dialog_youwin, null, false)
        val restartGame = view.findViewById<TextView>(R.id.btn_dialog_Restart_Game)
        val alertDialog = AlertDialog.Builder(requireActivity())
        val buildFirstResult = BuildFirstResult()
        dataList = buildFirstResult.buildDataList(booleanSound, coins)
        MyShare.dataList = dataList
        createBase()
        coins += 15

        restartGame.setOnClickListener {
            finalStepDialog.cancel()
        }

        alertDialog.setOnCancelListener {
            if (booleanSound) {
                val mediaPlayerRight = MediaPlayer.create(requireActivity(), R.raw.sound_navigation_right)
                mediaPlayerRight.start()
                mediaPlayerRight.setOnCompletionListener {
                    mediaPlayerRight.release()
                }
            }
            showActivity()
            setAnimation(R.anim.anim_opened)
        }

        alertDialog.setView(view)
        finalStepDialog = alertDialog.create()
        finalStepDialog.window!!.attributes.windowAnimations = R.style.MyAnimation
        finalStepDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun onPause() {
        dataList[0].arrayListFlag = arrayListFlag
        dataList[0].arrayListResult = arrayListResult
        dataList[0].coins = coins
        dataList[0].boolean = booleanRecyclerView
        MyShare.dataList = dataList
        super.onPause()
    }

    private fun getHeightOfView(contentView: View): Int {
        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        //contentView.getMeasuredWidth();
        return contentView.measuredHeight
    }

}