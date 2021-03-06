package com.example.aciktim.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.aciktim.MainActivity
import com.example.aciktim.R
import com.example.aciktim.adapter.SepetAdapter
import com.example.aciktim.databinding.FragmentSepetBinding
import com.example.aciktim.entity.Sepet
import com.example.aciktim.viewmodel.SepetFragmentViewModel

class SepetFragment : Fragment() {

    private lateinit var tasarim : FragmentSepetBinding
    private lateinit var viewModel : SepetFragmentViewModel
    private lateinit var listeSepet : List<Sepet>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_sepet, container, false)
        tasarim.sepetFragment = this


        viewModel.sepetListesi.observe(viewLifecycleOwner) {

            (activity as MainActivity).badgeNumber(viewModel.sepetListesi.value?.size)

            val adapter = SepetAdapter(requireContext(), it, viewModel)
            tasarim.sepetAdapter = adapter

            listeSepet = viewModel.sepetListesi.value!!

            tasarim.toplamFiyat.text = toplamFiyat(listeSepet, listeSepet.size - 1).toString() + " ₺"
        }

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel : SepetFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.sepetYemekGetir()
    }

    fun toplamFiyat (listeSepet: List<Sepet>, size : Int) : Int {

        var toplam = 0

        for(s in 0..size) {

            toplam += (listeSepet.get(s).yemek_siparis_adet.toInt() * listeSepet.get(s).yemek_fiyat.toInt())

        }
        return toplam
    }
}