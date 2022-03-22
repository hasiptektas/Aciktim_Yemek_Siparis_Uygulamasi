package com.example.aciktim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aciktim.databinding.ActivityKayitBinding
import com.google.android.material.snackbar.Snackbar

class KayitActivity : AppCompatActivity() {
    private lateinit var tasarim : ActivityKayitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tasarim = ActivityKayitBinding.inflate(layoutInflater)

        setContentView(tasarim.root)

        tasarim.btnKayit.setOnClickListener {

            Snackbar.make(it, "Kayıt Başarılı ", Snackbar.LENGTH_LONG).show()

        }

        tasarim.btnDevamett.setOnClickListener {
            val intent = Intent(this@KayitActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}