package ru.cactus.eduprompt.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.cactus.eduprompt.presentation.MainActivity
import ru.cactus.eduprompt.presentation.main.MainViewModel

val lessonsModule = module(override = true) {
    scope(named<MainActivity>()) {

        viewModel { MainViewModel(get()) }
    }
}