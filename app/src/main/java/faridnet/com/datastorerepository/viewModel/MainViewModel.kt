package faridnet.com.datastorerepository.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import faridnet.com.datastorerepository.repository.DataStoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = DataStoreRepository(application)

    // Convert Flow to LiveData
    val readFromDataStore = repository.readFromDataStore.asLiveData()

    fun saveToDataStore(myName: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.saveToDataStore(myName)
    }
}