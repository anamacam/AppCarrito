package com.example.appcarrito

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appcarrito.Opt_login.Login_correo
import com.example.appcarrito.databinding.ActivityMainBinding
import com.example.appcarrito.databinding.ActivityOpLoginBinding

class OpLogin : AppCompatActivity() {

    private lateinit var binding: ActivityOpLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityOpLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.IgresarEmail.setOnClickListener {
            startActivity(Intent(this@OpLogin, Login_correo::class.java))
        }



    }
}