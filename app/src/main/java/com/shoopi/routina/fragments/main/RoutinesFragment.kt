package com.shoopi.routina.fragments.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shoopi.routina.Color
import com.shoopi.routina.IntentConstants
import com.shoopi.routina.R
import com.shoopi.routina.adapters.RoutineListAdapter
import com.shoopi.routina.createDummyRoutines
import net.steamcrafted.materialiconlib.MaterialDrawableBuilder

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
        adapter = RoutineListAdapter(createDummyRoutines(), this)
        routineList.adapter = adapter
        adapter.notifyDataSetChanged()

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK) {
            return
        }
        if (requestCode == UPDATE_ICON) {
            Log.e(TAG, "onActivityResult: ${data?.extras.toString()}")
            val extras = data?.extras
            if (extras != null) {
                val position = extras.getInt(IntentConstants.EXTRA_ROUTINE_POSITION)
                val color = extras.getSerializable(IntentConstants.EXTRA_COLOR_OBJECT) as Color
                val icon =
                    extras.getSerializable(IntentConstants.EXTRA_ICON_OBJECT) as MaterialDrawableBuilder.IconValue

                adapter.onUpdate(position, color, icon)
            }
        }
    }

    companion object {
        private const val TAG = "RoutinesFragment"
        const val UPDATE_ICON = 100
    }
}