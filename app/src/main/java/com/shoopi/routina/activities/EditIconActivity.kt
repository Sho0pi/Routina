package com.shoopi.routina.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.shoopi.routina.R
import com.shoopi.routina.adapters.ColorListAdapter
import com.shoopi.routina.colors
import kotlinx.android.synthetic.main.activity_edit_icon.*

class EditIconActivity : AppCompatActivity() {


    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var colorListAdapter: ColorListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_icon)

        gridLayoutManager = GridLayoutManager(this, 5)

        color_list.layoutManager = gridLayoutManager
        colorListAdapter = ColorListAdapter(colors(), icon_view)
        color_list.adapter = colorListAdapter
        colorListAdapter.notifyDataSetChanged()

    }
}