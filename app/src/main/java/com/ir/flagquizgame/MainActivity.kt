package com.ir.flagquizgame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ir.flagquizgame.Data.UserData
import com.ir.flagquizgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var dataList:ArrayList<UserData>
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}