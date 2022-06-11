package br.ucsal.mobile.dogfeed.banco

import androidx.lifecycle.*
import br.ucsal.mobile.dogfeed.network.DogPhoto
import kotlinx.coroutines.launch

class UrlViewModel(private val repository: UrlRepository) : ViewModel() {

    val allUrls: LiveData<List<DogPhoto>> = repository.allUrls.asLiveData()

    fun insert(dogPhoto: DogPhoto) = viewModelScope.launch {
        repository.insert(dogPhoto)
    }
}

class UrlViewModelFactory(private val repository: UrlRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UrlViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return UrlViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}