package com.shoopi.routina.fragments.editicon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shoopi.routina.R
import com.shoopi.routina.adapters.ColorListAdapter
import com.shoopi.routina.colors

class ColorsFragment() : Fragment() {

    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var adapter: ColorListAdapter
    private lateinit var iconView: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_colors, container, false)

        val colorList = view.findViewById<RecyclerView>(R.id.color_list)

        gridLayoutManager = GridLayoutManager(this.context, 5)
        colorList.layoutManager = gridLayoutManager
        adapter = ColorListAdapter(colors(), iconView)
        colorList.adapter = adapter
        adapter.notifyDataSetChanged()

        return view
    }

    fun newInstance(iconView: LinearLayout): ColorsFragment {
        val fragment = ColorsFragment()
        fragment.iconView = iconView
        return fragment
    }

}