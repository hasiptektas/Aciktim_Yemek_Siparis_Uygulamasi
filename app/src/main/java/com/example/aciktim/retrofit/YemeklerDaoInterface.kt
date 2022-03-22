package com.example.aciktim.retrofit

import com.example.aciktim.entity.YemeklerCevap
import retrofit2.Call
import retrofit2.http.GET

interface YemeklerDaoInterface {

    @GET("yemekler/tumYemekleriGetir.php")
    fun tumYemekler() : Call<YemeklerCevap>

}