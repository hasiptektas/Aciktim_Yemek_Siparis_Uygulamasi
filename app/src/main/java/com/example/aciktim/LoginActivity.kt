package com.example.aciktim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aciktim.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private lateinit var tasarim : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tasarim = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(tasarim.root)

        tasarim.btndevamet.setOnClickListener {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        tasarim.btnKayit.setOnClickListener {

            val intent = Intent(this@LoginActivity, KayitActivity::class.java)
            startActivity(intent)
        }

        tasarim.btnGiris.setOnClickListener {

            Snackbar.make(it, "Giriş Başarılı ", Snackbar.LENGTH_LONG).show()

            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}