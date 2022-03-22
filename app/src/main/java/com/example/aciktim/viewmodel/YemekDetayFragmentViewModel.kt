package com.example.aciktim.viewmodel

import androidx.lifecycle.ViewModel
import com.example.aciktim.repo.SepetRepository

class YemekDetayFragmentViewModel : ViewModel(){

    val srepo = SepetRepository()

    fun sepeteEkle(yemek_adi : String, yemek_resim_adi : String, yemek_fiyat : Int, yemek_siparis_adet : Int, kullanici_adi : String) {

        srepo.sepetYemekEkle(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)

    }

}