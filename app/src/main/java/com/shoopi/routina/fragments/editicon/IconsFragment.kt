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
import com.shoopi.routina.adapters.IconListAdapter
import net.steamcrafted.materialiconlib.MaterialDrawableBuilder

class IconsFragment : Fragment() {

    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var adapter: IconListAdapter
    private lateinit var iconView: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_icons, container, false)

        val iconList = view.findViewById<RecyclerView>(R.id.icon_list)

        gridLayoutManager = GridLayoutManager(this.context, 5)
        iconList.layoutManager = gridLayoutManager
        adapter = IconListAdapter(icons(), iconView)
        iconList.adapter = adapter
        adapter.notifyDataSetChanged()

        return view
    }

    fun newInstance(iconView: LinearLayout): IconsFragment {
        val fragment = IconsFragment()
        fragment.iconView = iconView
        return fragment
    }

    private fun icons(): List<MaterialDrawableBuilder.IconValue> {
        return listOf(
            MaterialDrawableBuilder.IconValue.YOUTUBE,
            MaterialDrawableBuilder.IconValue.GITHUB_CIRCLE,
            MaterialDrawableBuilder.IconValue.SHAPE,
            MaterialDrawableBuilder.IconValue.POPCORN,
            MaterialDrawableBuilder.IconValue.GMAIL,
            MaterialDrawableBuilder.IconValue.PALETTE,
            MaterialDrawableBuilder.IconValue.BRUSH
        )
    }


}