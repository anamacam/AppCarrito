package com.example.appcarrito

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appcarrito.Fragmentos.FragmentChats
import com.example.appcarrito.Fragmentos.FragmentCuenta
import com.example.appcarrito.Fragmentos.FragmentInicio
import com.example.appcarrito.Fragmentos.FragmentMisAnuncios
import com.example.appcarrito.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

    private fun verFragmentInicio() {
        binding.ItemTituloRL.text = "Inicio"
        var fragment = FragmentInicio()
        var fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id, fragment, "FragmentInicio")
        fragmentTransition.commit()

    }

    private fun verFragmentChats() {
        binding.ItemTituloRL.text = "Chats"
        var fragment = FragmentChats()
        var fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id, fragment, "FragmentChats")
        fragmentTransition.commit()

    }
    private fun verFragmentMisAnuncios(){
        binding.ItemTituloRL.text = "Mis anuncios"
        var fragment = FragmentMisAnuncios()
        var fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id, fragment, "FragmentMisAnuncios")
        fragmentTransition.commit()

    }
    private fun verFragmentCuenta(){
        binding.ItemTituloRL.text = "Cuenta"
        var fragment = FragmentCuenta()
        var fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id, fragment, "FragmentCuenta")
        fragmentTransition.commit()

    }
}