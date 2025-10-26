package com.example.consumercatfact

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fatoTextView = findViewById<TextView>(R.id.fatoTv)
        val botaoVoltar = findViewById<Button>(R.id.buttonVoltar)

        val parametro = intent.getStringExtra("FATO_EXTRA")

        if (parametro != null) {
            val catFactApi = RetrofitHelper.getInstance().create(CatFactApi::class.java)

            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val response = catFactApi.getFato(parametro)
                    if (response.isSuccessful) {
                        val curiosidade = response.body()
                        Log.d("Retorno da API: ", curiosidade.toString())

                        withContext(Dispatchers.Main) {
                            fatoTextView.text = "Curiosidade:\n${curiosidade?.fact}"
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            fatoTextView.text = "Erro: ${response.code()}"
                        }
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        fatoTextView.text = "Ocorreu um erro: ${e.message}"
                    }
                }
            }
        } else {
            fatoTextView.text = "Personagem não encontrado."
        }

        botaoVoltar.setOnClickListener {
            onBackPressed()
        }
    }
}