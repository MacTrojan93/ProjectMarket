package com.example.breakingbaddk.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbaddk.ui.adapter.CharacterListAdapter
import com.example.breakingbaddk.ui.adapter.ItemFragment

private const val TAG = "ListFragment"
class ListFragment : ItemFragment() {

    private var listener: Listener? = null

    override val layoutManager: RecyclerView.LayoutManager
        get() = LinearLayoutManager(context)

    private lateinit var adapter: CharacterListAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Listener)
            listener = context
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
        recyclerView.adapter = adapter
        viewModel.getListOfCharacters().observe(this,
            Observer {
                Log.d(TAG, "onStart: ObserveData")
                adapter.setDataSet(it)
            })

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CharacterListAdapter(listener!!)

        viewModel = ViewModelProvider(context as AppCompatActivity,
            MainViewModel.MainViewModelFactory()).get(MainViewModel::class.java)

        viewModel.updateDataCharacters()
    }

//        fun onClickCharacter(position: Int)
//        {
//            val ft: FragmentTransaction = fragmentManager!!.beginTransaction()
//            ft.replace(R.id.rv_display, DetailFragment(), TAG)
//            ft.addToBackStack(TAG)
//            ft.commitAllowingStateLoss()
//            Toast.makeText(context, "Gathering Details ", Toast.LENGTH_LONG).show()
//        }
    interface Listener {
        fun onClickCharacter(position: Int)
    }

    companion object {
        fun newInstance(): ListFragment {
            return ListFragment()
        }
    }
}