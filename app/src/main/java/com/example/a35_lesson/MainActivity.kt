package com.example.a35_lesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a35_lesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.container,FirstFragment(),"First fragment").commit()

    }
}