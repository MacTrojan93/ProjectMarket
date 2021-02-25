package com.example.breakingbaddk.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbaddk.ui.adapter.CharacterDetailAdapter
import com.example.breakingbaddk.ui.adapter.ItemFragment
import com.example.breakingbaddk.ui.main.MainViewModel

class DetailFragment: ItemFragment() {

    override val layoutManager: RecyclerView.LayoutManager
        get() = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

    private lateinit var adapter: CharacterDetailAdapter

    override fun onStart() {
        super.onStart()
        viewModel.getListOfCharacters().observe(this,
            Observer {
                adapter.setDatSet(it)
            })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CharacterDetailAdapter()

        viewModel = ViewModelProvider(context as AppCompatActivity,
            MainViewModel.MainViewModelFactory()).get(MainViewModel::class.java)

        recyclerView.adapter = adapter
        arguments?.let {
            recyclerView.scrollToPosition(it.getInt(KEY_POSITION_SELECTED))
        }
    }

    companion object{
        const val KEY_POSITION_SELECTED = "DetailFragment_KEY_POSITION"
        fun newInstance(position:Int): DetailFragment{
            return DetailFragment().apply {
                arguments =
                    Bundle().apply {
                        putInt(KEY_POSITION_SELECTED, position)
                    }
            }
        }
    }
}