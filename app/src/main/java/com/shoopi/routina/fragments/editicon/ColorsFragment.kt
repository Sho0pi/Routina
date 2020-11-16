package com.shoopi.routina.fragments.editicon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shoopi.routina.Color
import com.shoopi.routina.R
import com.shoopi.routina.SharedColor
import com.shoopi.routina.adapters.ColorListAdapter
import com.shoopi.routina.colors
import com.shoopi.routina.utils.GridSpacingItemDecoration

class ColorsFragment() : Fragment() {

    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var adapter: ColorListAdapter
    private lateinit var iconView: LinearLayout
    private lateinit var iconColor: SharedColor

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_colors, container, false)

        val colorList = view.findViewById<RecyclerView>(R.id.color_list)

        val spanCount = 5
        val spacing = 50
        gridLayoutManager = GridLayoutManager(this.context, 5)
        colorList.layoutManager = gridLayoutManager
        colorList.addItemDecoration(GridSpacingItemDecoration(spanCount, spacing, true))

        adapter = ColorListAdapter(colors(), iconView, iconColor)
        colorList.adapter = adapter
        adapter.notifyDataSetChanged()

        return view
    }

    fun newInstance(iconView: LinearLayout, iconColor: SharedColor): ColorsFragment {
        val fragment = ColorsFragment()
        fragment.iconView = iconView
        fragment.iconColor = iconColor
        return fragment
    }

}