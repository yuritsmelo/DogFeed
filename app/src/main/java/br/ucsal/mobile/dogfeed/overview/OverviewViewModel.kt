package br.ucsal.mobile.dogfeed.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.ucsal.mobile.dogfeed.network.DogApi
import br.ucsal.mobile.dogfeed.network.DogPhoto
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel(){

    private val _status = MutableLiveData<String>()
    private val _photos = MutableLiveData<List<DogPhoto>?>()

    val status: LiveData<String> = _status
    val photos: MutableLiveData<List<DogPhoto>?> = _photos

    init {
        getDogPhotos()
    }

    suspend fun toList(): List<DogPhoto> {
        return listOf(DogApi.retrofitService.getPhotos())
    }

    private fun getDogPhotos() {
        viewModelScope.launch {
            try {
                _photos.value = toList()
                _status.value = "Success: Mars properties retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}