package com.ir.flagquizgame

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ir.flagquizgame.Class.BuildFirstResult
import com.ir.flagquizgame.Data.FlagData
import com.ir.flagquizgame.Data.ResultData
import com.ir.flagquizgame.Data.UserData
import com.ir.flagquizgame.MyShare.MyShare
import com.ir.flagquizgame.databinding.FragmentHomeBinding
import java.io.*

class HomeFragment : Fragment() {
    lateinit var dataList: ArrayList<UserData>
    lateinit var arrayListFlag: ArrayList<FlagData>
    lateinit var arrayListResult: ArrayList<ResultData>
    private var coins: Int = -1
    private var booleanSound: Boolean = true
    lateinit var binding: FragmentHomeBinding

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        MyShare.init(requireActivity())

        addResultCache()
        showFlagAndCoins()

        binding.cardViewPlay.setOnClickListener {
            if (booleanSound) {
                val mediaPlayerPlay = MediaPlayer.create(requireActivity() , R.raw.sound_play)
                mediaPlayerPlay.start()
                mediaPlayerPlay.setOnCompletionListener {
                    mediaPlayerPlay.release()
                }
            }
            findNavController().navigate(R.id.action_homeFragment_to_gameFragment)
        }

        binding.lyItem.setOnClickListener {
            if (booleanSound) {
                val mediaPlayerPlay = MediaPlayer.create(requireActivity() , R.raw.sound_play)
                mediaPlayerPlay.start()
                mediaPlayerPlay.setOnCompletionListener {
                    mediaPlayerPlay.release()
                }
            }
            binding.drawerLayout.openDrawer(Gravity.START)
        }

        booleanSound = arrayListResult[0].booleanSound
        binding.switchSound.isChecked = booleanSound
        binding.lySound.setOnClickListener {
            val boolean = !booleanSound
            booleanSound = boolean
            binding.switchSound.isChecked = booleanSound
            dataList[0].arrayListResult[0].booleanSound = booleanSound
            MyShare.dataList!![0].arrayListResult[0].booleanSound =
                dataList[0].arrayListResult[0].booleanSound
        }

        binding.lyContactUs.setOnClickListener {
            contactUs()
        }

        binding.lyShare.setOnClickListener {
            sendApk()
        }

        binding.switchSound.setOnCheckedChangeListener { _, isChecked ->
            booleanSound = isChecked
            dataList[0].arrayListResult[0].booleanSound = booleanSound
            MyShare.dataList = dataList
        }

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun showFlagAndCoins() {
        binding.tvCoins.text = coins.toString()
        binding.flag.setImageResource(arrayListFlag[0].flagPicture)
        binding.tvLevel.text = "${(158 - arrayListFlag.size)}/158"

        try {
            binding.lyPlay.setBackgroundResource(R.drawable.gradient_play)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        binding.cardLevel.radius = (getHeightOfView(binding.cardLevel) / 2).toFloat()
        binding.cardCoins.radius = (getHeightOfView(binding.cardCoins) / 2).toFloat()

    }

    private fun addResultCache() {
        dataList = ArrayList()
        arrayListFlag = ArrayList()
        arrayListResult = ArrayList()

        dataList.addAll(MyShare.dataList!!)

        if (dataList.isEmpty()) {
            val buildFirstResult = BuildFirstResult()
            dataList = buildFirstResult.buildDataList(true, 500)
            MyShare.dataList = dataList
        }

        arrayListFlag = dataList[0].arrayListFlag
        arrayListResult = dataList[0].arrayListResult
        coins = dataList[0].coins
    }

    private fun sendApk() {
        val app = requireActivity().applicationContext.applicationInfo
        val filePath = app.sourceDir
        val intent = Intent(Intent.ACTION_SEND)

        // MIME of .apk is "application/vnd.android.package-archive".
        // but Bluetooth does not accept this. Let's use "*/*" instead.
        intent.type = "application/vnd.android.package-archive"

        // Append file and send Intent
        val originalApk = File(filePath)

        //Make new directory in new location
        var tempFile = File(requireActivity().externalCacheDir.toString() + "/ExtractedApk")
        //If directory doesn't exists create new
        if (!tempFile.isDirectory) {
            if (!tempFile.mkdirs()) {
                return
            }
        }
        //Get application's name and convert to lowercase
        tempFile = File(tempFile.path.toString() + "/" + getString(app.labelRes)
            .replace(" ", "") + ".apk")
        //If file doesn't exists create new
        if (!tempFile.exists()) {
            if (!tempFile.createNewFile()) {
                return
            }
        }
        //Copy file to new location
        val `in`: InputStream = FileInputStream(originalApk)
        val out: OutputStream = FileOutputStream(tempFile)
        val buf = ByteArray(1024)
        var len: Int
        while (`in`.read(buf).also { len = it } > 0) {
            out.write(buf, 0, len)
        }
        `in`.close()
        out.close()
        println("File copied.")
        //Open share dialog
        val uri =
            FileProvider.getUriForFile(requireActivity(), requireActivity().packageName, tempFile)
        intent.putExtra(Intent.EXTRA_STREAM, uri)
        requireActivity().grantUriPermission(requireActivity().packageManager.toString(),
            uri,
            Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_READ_URI_PERMISSION)
        startActivity(intent)
    }

    private fun contactUs() {
        val arrEmail = arrayOf("developer.iraimjanov@gmail.com")
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, arrEmail)
        intent.putExtra(Intent.EXTRA_SUBJECT, "Flag Quiz Game")
        requireActivity().startActivity(Intent.createChooser(intent,
            getString(R.string.emailSelectMenu)))
    }

    private fun getHeightOfView(contentView: View): Int {
        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        //contentView.getMeasuredWidth();
        return contentView.measuredHeight
    }

}