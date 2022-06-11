package br.ucsal.mobile.dogfeed.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.ucsal.mobile.dogfeed.databinding.GridViewItemBinding
import br.ucsal.mobile.dogfeed.network.DogPhoto

class PhotoGridAdapter : ListAdapter<DogPhoto, PhotoGridAdapter.DogPhotosViewHolder>(DiffCallback){

    class DogPhotosViewHolder(private var binding: GridViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dogPhoto: DogPhoto) {
            binding.photo = dogPhoto
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<DogPhoto>() {
        override fun areContentsTheSame(oldItem: DogPhoto, newItem: DogPhoto): Boolean {
            return oldItem.imgSrcUrl == newItem.imgSrcUrl
        }

        override fun areItemsTheSame(oldItem: DogPhoto, newItem: DogPhoto): Boolean {
            return oldItem.imgSrcUrl == newItem.imgSrcUrl
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogPhotosViewHolder {
        return DogPhotosViewHolder(
            GridViewItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: DogPhotosViewHolder, position: Int) {
        val dogPhoto = getItem(position)
        holder.bind(dogPhoto)
    }
}