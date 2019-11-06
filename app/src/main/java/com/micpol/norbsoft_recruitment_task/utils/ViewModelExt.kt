package com.micpol.norbsoft_recruitment_task.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

inline fun <reified T : ViewModel> Fragment.getVM(factory: ViewModelProvider.Factory) =
    ViewModelProviders.of(this, factory).get(T::class.java)
