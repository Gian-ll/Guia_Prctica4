package com.example.contadorvidas

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LivesActivity : AppCompatActivity() {
    private val viewModel: LivesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lives)

        val tvVidas = findViewById<TextView>(R.id.tvVidas)
        val tvMensaje = findViewById<TextView>(R.id.tvMensaje)
        val btnQuitarVida = findViewById<Button>(R.id.btnQuitarVida)

        viewModel.botonAc.observe(this) { activo ->
            btnQuitarVida.isEnabled = activo
        }

        viewModel.mensaje.observe(this) { mensaje ->
            tvMensaje.text = mensaje
        }

        viewModel.vidas.observe(this) { valorActualizado ->
            tvVidas.text = valorActualizado.toString()
        }

        btnQuitarVida.setOnClickListener { viewModel.reducirVida() }
    }
}