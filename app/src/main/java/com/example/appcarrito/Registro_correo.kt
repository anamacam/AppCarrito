package com.example.appcarrito

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appcarrito.databinding.ActivityRegistroCorreoBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class Registro_correo : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroCorreoBinding

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroCorreoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Espere un momento por favor")
        progressDialog.setCanceledOnTouchOutside(false)

        binding.BtnRegistrar.setOnClickListener {
            validarInfo()
        }


    }

    private var email = ""
    private var password = ""
    private var r_password = ""


    private fun validarInfo() {
        email = binding.EtEmail.text.toString().trim()
        password = binding.EtPassword.text.toString().trim()
        r_password = binding.EtPassword.text.toString().trim()

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.EtEmail.error = "Correo inválido"
            binding.EtEmail.requestFocus()
        }
        else if (email.isEmpty()) {
            binding.EtEmail.error = "Ingrese un correo válido"
            binding.EtEmail.requestFocus()
        }
        else if (password.isEmpty()) {
            binding.EtPassword.error = "Ingrese la contraseña"
            binding.EtPassword.requestFocus()
        }
        else if (r_password.isEmpty()) {
            binding.EtrRPassword.error = "Repita la contraseña"
            binding.EtrRPassword.requestFocus()
        }
        else if (password != r_password) {
            binding.EtrRPassword.error = "La contraseña no coincide"
            binding.EtrRPassword.requestFocus()
        }
        else {
            registrarUsuario()
        }
    }
    private fun registrarUsuario() {
        progressDialog.setMessage("Creando cuenta")
        progressDialog.show()

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                llenarInfo()
                // Manejar el éxito del registro de usuario
                progressDialog.dismiss()
                Toast.makeText(
                    this,
                    "Usuario registrado correctamente",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .addOnFailureListener { e ->
                // Manejar el error en el registro de usuario
                progressDialog.dismiss()
                Toast.makeText(
                    this,
                    "No se pudo registrar el usuario: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    private fun llenarInfo() {
        progressDialog.setMessage("Guardando la información")

        val tiempo = Constantes.obtenerTiempoDis()
        val  emailUsuario = firebaseAuth.currentUser!!.email
        val  uidUsuario = firebaseAuth.uid

        val hashMap = HashMap<String, Any>()
        hashMap["nombres"] = ""
        hashMap["codigoTelefono"] = ""
        hashMap["telefono"] = ""
        hashMap["urlImagenPerfil"] = ""
        hashMap["proveedor"] = ""
        hashMap["escribiendo"] = ""
        hashMap["tiempo"] = ""
        hashMap["omline"] = ""
        hashMap["email"] = ""
        hashMap["uid"] = ""
        hashMap["fecha_nac"] = ""

        val ref = FirebaseDatabase.getInstance().getReference("Usuarios")
        ref.child(uidUsuario!!)
            .setValue(hashMap)
            .addOnSuccessListener {
                progressDialog.dismiss()
                startActivity(Intent(this, MainActivity::class.java))
                finishAffinity()

            }
            .addOnFailureListener { e->
                progressDialog.dismiss()
                Toast.makeText(
                    this,
                    "No se registro el usuario ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }

    }

}


