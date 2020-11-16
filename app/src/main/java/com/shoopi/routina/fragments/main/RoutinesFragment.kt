package com.shoopi.routina.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shoopi.routina.R
import com.shoopi.routina.Routine
import com.shoopi.routina.adapters.RoutineListAdapter
import com.shoopi.routina.createDummyRoutines

class RoutinesFragment : Fragment() {

    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var adapter: RoutineListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_routines, container, false)

        // Inflate the layout for this fragment
        gridLayoutManager = GridLayoutManager(this.context, 2)
        val routineList = view.findViewById<RecyclerView>(R.id.routineList)


        routineList.layoutManager = gridLayoutManager
        adapter = RoutineListAdapter(createDummyRoutines())
        routineList.adapter = adapter
        adapter.notifyDataSetChanged()

        return view
    }
}