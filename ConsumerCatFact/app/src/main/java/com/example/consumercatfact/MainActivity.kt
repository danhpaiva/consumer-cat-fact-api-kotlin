package com.example.consumercatfact

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val idFatoEditText = findViewById<EditText>(R.id.editTextId)
        val searchButton = findViewById<Button>(R.id.buttonFetchFact)

        searchButton.setOnClickListener {
            val fato = idFatoEditText.text.toString().trim()

            if (fato.isNotEmpty()) {
                val intent = Intent(this, ResultadoActivity::class.java)

                intent.putExtra("FATO_EXTRA", fato)

                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, digite fact.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}