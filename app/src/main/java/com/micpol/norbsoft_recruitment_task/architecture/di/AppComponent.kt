package com.micpol.norbsoft_recruitment_task.architecture.di

import android.app.Application
import com.micpol.norbsoft_recruitment_task.NorbsoftRTApplication
import com.micpol.norbsoft_recruitment_task.architecture.di.contribute.ActivityContributeModule
import com.micpol.norbsoft_recruitment_task.architecture.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityContributeModule::class
    ]
)
interface AppComponent : AndroidInjector<NorbsoftRTApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
