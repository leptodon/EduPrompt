package ru.cactus.eduprompt.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import ru.cactus.eduprompt.data.repository.MainRepository
import ru.cactus.eduprompt.util.Resource

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getLessons() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getLessons()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}