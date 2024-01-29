package com.xray.lite.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xray.lite.R
import com.xray.lite.helper.SimpleItemTouchHelperCallback
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FragmentTwo : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_page_two, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView_two)
        // Setup RecyclerView for Tab 2
//        val recyclerView = findViewById<RecyclerView>(R.id.list)
        // Use lifecycleScope.launch to run code in a coroutine
//        lifecycleScope.launch(Dispatchers.Default) {
            // Your existing code for setting up RecyclerView and adapter
            recyclerView.layoutManager = LinearLayoutManager(activity)
            // Any other code that needs to be executed in the background
//        }
//
//        recyclerView.itemAnimator = FadeInAnimator()
//        val adapter = activity?.let { MainAdapter(it, SampleData.LIST.toMutableList()) }
//        recyclerView.adapter = adapter?.let {
//            AlphaInAnimationAdapter(it).apply {
//                setFirstOnly(true)
//                setDuration(300)
//                setInterpolator(OvershootInterpolator(.5f))
//            }
//        }

        return view
    }
}
