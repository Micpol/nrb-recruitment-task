package com.micpol.norbsoft_recruitment_task.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.micpol.norbsoft_recruitment_task.R
import com.micpol.norbsoft_recruitment_task.architecture.BaseFragment
import com.micpol.norbsoft_recruitment_task.utils.getVM
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: HomeVM by lazy { getVM<HomeVM>(viewModelFactory) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.loadChannels()
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.channels.observe(
            this,
            Observer {
                submitData()
            })
    }

    private fun submitData() {

    }

}
