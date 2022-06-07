package br.ucsal.mobile.dogfeed.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import br.ucsal.mobile.dogfeed.databinding.FragmentOverviewBinding
import br.ucsal.mobile.dogfeed.databinding.GridViewItemBinding

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

        return binding.root
    }
}



