package com.example.aciktim.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.aciktim.databinding.PopularCardTasarimBinding
import com.example.aciktim.entity.Yemekler
import com.example.aciktim.fragment.AnasayfaFragmentDirections
import com.example.aciktim.picasso.PicassoService
import com.example.aciktim.viewmodel.AnasayfaFragmentViewModel

class PopularCardAdapter(var mContext : Context,
                         var yemeklerListesi : List<Yemekler>,
                         var viewModel : AnasayfaFragmentViewModel
) : RecyclerView.Adapter<PopularCardAdapter.PopularYemekCardTasarimTutucu>() {

    inner class PopularYemekCardTasarimTutucu (tasarim : PopularCardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){

        var tasarim : PopularCardTasarimBinding

        init {
            this.tasarim = tasarim
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularYemekCardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = PopularCardTasarimBinding.inflate(layoutInflater,parent,false)

        return PopularYemekCardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: PopularYemekCardTasarimTutucu, position: Int) {

        val yemek = yemeklerListesi.get(position)
        val t = holder.tasarim
        t.yemekNesnesi = yemek


        PicassoService().resimGoster(t.yemekNesnesi!!.yemek_resim_adi,t.popularImageViewYemek)

        t.popularCard.setOnClickListener{
            val gecis = AnasayfaFragmentDirections.yemekDetayGecis(yemek = yemek)
            Navigation.findNavController(it).navigate(gecis)
        }
    }

    override fun getItemCount(): Int {
        return yemeklerListesi.size
    }


}