package br.ucsal.mobile.dogfeed.overview

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import br.ucsal.mobile.dogfeed.R
import br.ucsal.mobile.dogfeed.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment(){

    private val viewModel: OverviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)
        //val binding = GridViewItemBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.photosGrid.adapter = PhotoGridAdapter()

        binding.buttonNew.setOnClickListener{viewModel.getDogPhotos()}

        binding.switchFav.setOnClickListener{Toast.makeText(this.context, "added to favs", Toast.LENGTH_SHORT).show()}

        return binding.root
    }
}