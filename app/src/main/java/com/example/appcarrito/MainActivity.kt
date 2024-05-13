package com.example.appcarrito

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appcarrito.Fragmentos.FragmentChats
import com.example.appcarrito.Fragmentos.FragmentCuenta
import com.example.appcarrito.Fragmentos.FragmentInicio
import com.example.appcarrito.Fragmentos.FragmentMisAnuncios
import com.example.appcarrito.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        comprobarSesion()

        verFragmentInicio()

        binding.BottomNV.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Item_Inicio -> {
                    verFragmentInicio()
                    true
                }

                R.id.Item_Chatas -> {
                    verFragmentChats()
                    true
                }

                R.id.Item_Mis_Anuncios -> {
                    verFragmentMisAnuncios()
                    true
                }

                R.id.Item_Cuenta -> {
                    verFragmentCuenta()
                    true
                }

                else -> {
                    false
                }
            }
        }
    }

    private fun comprobarSesion(){
        if (firebaseAuth.currentUser == null){
            startActivity(Intent(this, OpLogin::class.java))
            finishAffinity()
        }
    }

    private fun verFragmentInicio() {
        binding.ItemTituloRL.text = "Inicio"
        val fragment = FragmentInicio()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id, fragment, "FragmentInicio")
        fragmentTransition.commit()

    }

    private fun verFragmentChats() {
        binding.ItemTituloRL.text = "Chats"
        val fragment = FragmentChats()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id, fragment, "FragmentChats")
        fragmentTransition.commit()

    }
    private fun verFragmentMisAnuncios(){
        binding.ItemTituloRL.text = "Mis anuncios"
        val fragment = FragmentMisAnuncios()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id, fragment, "FragmentMisAnuncios")
        fragmentTransition.commit()

    }
    private fun verFragmentCuenta(){
        binding.ItemTituloRL.text = "Cuenta"
        val fragment = FragmentCuenta()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id, fragment, "FragmentCuenta")
        fragmentTransition.commit()

    }
}