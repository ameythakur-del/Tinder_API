package com.example.tinder_api.ui.main

import android.content.ContentValues.TAG
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.tinder_api.R
import com.example.tinder_api.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    /**
     * Inflates the layout with Data Binding, sets its lifecycle owner to the OverviewFragment
     * to enable Data Binding to observe LiveData, and sets up the RecyclerView with an adapter.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = MainFragmentBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        setHasOptionsMenu(true)

        val adapter = MainAdapter(
            MainAdapter.ResultListener { Result ->
                viewModel.onAcceptClicked(Result)
            }, MainAdapter.ResultListener { Result ->
                viewModel.onDeclineClicked(Result)
            })

        binding.resultList.adapter = adapter

        viewModel.playlist.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it.results)
            }
        })

        return binding.root
    }
}