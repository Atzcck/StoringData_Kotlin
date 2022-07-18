package com.alptazecicek.storingdata_kotlin

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alptazecicek.storingdata_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences : SharedPreferences
    var ageFromPreferences: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //SharedPreferences Initialize
        sharedPreferences = this.getSharedPreferences("com.alptazecicek.storingdata_kotlin", MODE_PRIVATE)

        val ageFromPreferences = sharedPreferences.getInt("age", -1)
            if (ageFromPreferences == -1) {
                binding.textView.text = "Your Age: "
            } else {
                binding.textView.text = "Your Age: $ageFromPreferences"
            }
    }


    fun save(view: View) {
        //Shared Preferences


        val myAge = binding.ageText.text.toString().toIntOrNull()
        if (myAge != null) {
            binding.textView.text = "Your Age: ${myAge}"
            sharedPreferences.edit().putInt("age", myAge).apply()

        } else {
            binding.textView.text = "Error!"
        }
    }

    fun delete(view: View) {
        ageFromPreferences = sharedPreferences.getInt("age", -1)
        if (ageFromPreferences != -1){
            sharedPreferences.edit().remove("age").apply()
            binding.textView.text = "Your Age:"
        }

    }



}