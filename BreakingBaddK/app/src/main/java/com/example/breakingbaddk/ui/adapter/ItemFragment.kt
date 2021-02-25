package com.example.breakingbaddk.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbaddk.databinding.MainFragmentBinding
import com.example.breakingbaddk.ui.main.MainViewModel

abstract class ItemFragment: Fragment() {

    protected lateinit var viewModel: MainViewModel
    protected lateinit var recyclerView: RecyclerView
    protected abstract val layoutManager: RecyclerView.LayoutManager
    private lateinit var __binding : MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        __binding = MainFragmentBinding.inflate(inflater, container , false)
        recyclerView = __binding.rvDisplay
        recyclerView.layoutManager = layoutManager
        return __binding.root
    }

}