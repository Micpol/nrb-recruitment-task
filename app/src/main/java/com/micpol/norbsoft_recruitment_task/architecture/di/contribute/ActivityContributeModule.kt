package com.micpol.norbsoft_recruitment_task.architecture.di.contribute

import com.micpol.norbsoft_recruitment_task.feature.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityContributeModule {

    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    abstract fun contributeHomeActivity(): HomeActivity
}
