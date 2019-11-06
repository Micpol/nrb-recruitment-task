package com.micpol.norbsoft_recruitment_task.feature.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.micpol.norbsoft_recruitment_task.R
import com.micpol.norbsoft_recruitment_task.architecture.BaseFragment
import com.micpol.norbsoft_recruitment_task.data.model.Channel
import com.micpol.norbsoft_recruitment_task.feature.home.list.ChannelsAdapter
import com.micpol.norbsoft_recruitment_task.utils.getVM
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: HomeVM by lazy { getVM<HomeVM>(viewModelFactory) }

    private val channelsAdapter by lazy {
        ChannelsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareChannelsRV()
        observe()
    }

    private fun prepareChannelsRV() {
        channelsListRV.apply {
            adapter = channelsAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }

    private fun observe() {
        viewModel.channels.observe(
            this,
            Observer {
                Log.d("HomeFragment", "observe: ${it.joinToString(separator = "\n")}}");
                submitData(it)
            })
    }

    private fun submitData(it: List<Channel>) {
        channelsAdapter.submitList(it)
    }

}
