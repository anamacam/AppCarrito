package com.example.appcarrito.Opt_login

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appcarrito.R
import com.example.appcarrito.Registro_correo
import com.example.appcarrito.databinding.ActivityLoginCorreoBinding
import com.example.appcarrito.databinding.ActivityOpLoginBinding

class Login_correo : AppCompatActivity() {

    private lateinit var binding: ActivityLoginCorreoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginCorreoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.TxtRegistrate.setOnClickListener{
            startActivity(Intent(this@Login_correo, Registro_correo::class.java))
        }

    }
}