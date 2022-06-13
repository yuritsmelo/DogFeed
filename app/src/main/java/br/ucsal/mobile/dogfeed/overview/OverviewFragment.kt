package br.ucsal.mobile.dogfeed.overview

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import br.ucsal.mobile.dogfeed.R
import br.ucsal.mobile.dogfeed.banco.FavsDao
import br.ucsal.mobile.dogfeed.banco.UrlViewModel
import br.ucsal.mobile.dogfeed.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment(){

    private val viewModel: OverviewViewModel by viewModels()
    private val viewModel2: UrlViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel
        //binding.viewModel2 = viewModel2

        binding.photosRecyclerview.adapter = DogListAdapter()

        binding.buttonNew.setOnClickListener{viewModel.getDogPhotos()}

        //binding.buttonFav.setOnClickListener{Toast.makeText(this.context, "added to favs", Toast.LENGTH_SHORT).show()}

        binding.buttonFav.setOnClickListener{ viewModel.photos.value?.let { it1 ->
            viewModel2.insert(
                it1[0]
            )
        } }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            requireView().findNavController()) || super.onOptionsItemSelected(item)
    }
}