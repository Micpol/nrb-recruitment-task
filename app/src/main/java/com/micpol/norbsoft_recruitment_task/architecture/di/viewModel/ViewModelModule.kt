package com.micpol.norbsoft_recruitment_task.architecture.di.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.micpol.norbsoft_recruitment_task.feature.home.HomeVM
import com.micpol.norbsoft_recruitment_task.feature.home.HomeVMImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeVM::class)
    abstract fun provideSearchViewModel(vm: HomeVMImpl): ViewModel
}
