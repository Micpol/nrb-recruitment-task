package com.micpol.norbsoft_recruitment_task.architecture.di.contribute

import com.micpol.norbsoft_recruitment_task.feature.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

}