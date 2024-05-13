package com.example.appcarrito

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appcarrito.Opt_login.Login_correo
import com.example.appcarrito.databinding.ActivityOpLoginBinding
import com.google.firebase.auth.FirebaseAuth

class OpLogin : AppCompatActivity() {

    private lateinit var binding: ActivityOpLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOpLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        comprobarSesion()

        binding.IgresarEmail.setOnClickListener {
            startActivity(Intent(this@OpLogin, Login_correo::class.java))
        }
    }

    private fun comprobarSesion() {
        if (firebaseAuth.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }
    }
}
