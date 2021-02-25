package com.example.breakingbaddk

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.breakingbaddk.ui.detail.DetailFragment
import com.example.breakingbaddk.ui.main.ListFragment

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity(), ListFragment.Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            Log.d(TAG,"onCreate: Updated List")
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ListFragment.newInstance(), "Character List")
                    .commitNow()
        }
    }

    override fun onClickCharacter(position: Int) {
        Log.d(TAG, "onClickCharacter: Position= $position")
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, DetailFragment.newInstance(position))
            .commit()
    }
}