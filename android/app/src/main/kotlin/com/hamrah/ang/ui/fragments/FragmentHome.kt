package com.hamrah.ang.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hamrah.ang.R
import com.hamrah.ang.helper.SimpleItemTouchHelperCallback
import com.hamrah.ang.ui.MainRecyclerAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FragmentHome : Fragment() {
    private lateinit var adapter: MainRecyclerAdapter
    private var mItemTouchHelper: ItemTouchHelper? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_page_home, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView_home)

        // Use lifecycleScope.launch to run code in a coroutine
//        lifecycleScope.launch(Dispatchers.Default) {
            // Your existing code for setting up RecyclerView and adapter
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter = adapter

            val callback = SimpleItemTouchHelperCallback(adapter)
            mItemTouchHelper = ItemTouchHelper(callback)
            mItemTouchHelper?.attachToRecyclerView(recyclerView)
            // Any other code that needs to be executed in the background
//        }

        return view
    }

    fun setAdapter(adapter: MainRecyclerAdapter) {
        this.adapter = adapter
    }
}
