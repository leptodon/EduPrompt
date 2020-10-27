package ru.cactus.eduprompt.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import ru.cactus.eduprompt.data.entities.LessonsList
import ru.cactus.eduprompt.data.entities.Result
import ru.cactus.eduprompt.data.repository.NetworkRepository
import ru.cactus.eduprompt.data.repositoryImpl.NetworkRepositoryImpl
import ru.cactus.eduprompt.util.Resource

class MainViewModel(private val networkRepository: NetworkRepository) : ViewModel() {

    private var list = MutableLiveData<LessonsList>()

    private lateinit var disposable: Disposable

    fun getLessons(): MutableLiveData<LessonsList> {
        disposable = networkRepository.getLessons().subscribeOn(Schedulers.io()).observeOn(
            AndroidSchedulers.mainThread())
            .subscribe(Consumer { list.value = it })
        return list
    }
}