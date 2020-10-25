package ru.cactus.eduprompt

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.cactus.eduprompt.di.lessonsModule

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        initDi()
    }

    private fun initDi() {
        startKoin {
            androidContext(this@Application)
            modules(
                listOf(
//                    headerModule,
//                    counterModule,
//                    homeworkModue,
//                    footerModule,
                    lessonsModule
                    )
            )
        }
    }

}