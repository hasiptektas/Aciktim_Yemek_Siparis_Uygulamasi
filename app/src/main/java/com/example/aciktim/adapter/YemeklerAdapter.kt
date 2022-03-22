package com.example.aciktim.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.aciktim.databinding.YemekCardTasarimBinding
import com.example.aciktim.entity.Yemekler
import com.example.aciktim.fragment.AnasayfaFragmentDirections
import com.example.aciktim.viewmodel.AnasayfaFragmentViewModel
import com.example.aciktim.picasso.PicassoService

class YemeklerAdapter(var mContext : Context,
                      var yemeklerListesi : List<Yemekler>,
                      var viewModel : AnasayfaFragmentViewModel
) : RecyclerView.Adapter<YemeklerAdapter.YemekCardTasarimTutucu>() {

    inner class YemekCardTasarimTutucu(tasarim : YemekCardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root) {

        var tasarim : YemekCardTasarimBinding

        init {
            this.tasarim = tasarim
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YemekCardTasarimTutucu {

        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = YemekCardTasarimBinding.inflate(layoutInflater,parent,false)

        return YemekCardTasarimTutucu(tasarim)

    }

    override fun onBindViewHolder(holder: YemekCardTasarimTutucu, position: Int) {

        val yemek = yemeklerListesi.get(position)
        val t = holder.tasarim
        t.yemekNesnesi = yemek

        PicassoService().resimGoster(t.yemekNesnesi!!.yemek_resim_adi,t.imageViewYemek)

        t.yemekCard.setOnClickListener{
            val gecis = AnasayfaFragmentDirections.yemekDetayGecis(yemek = yemek)
            Navigation.findNavController(it).navigate(gecis)
        }

    }

    override fun getItemCount(): Int {
        return yemeklerListesi.size
    }


}