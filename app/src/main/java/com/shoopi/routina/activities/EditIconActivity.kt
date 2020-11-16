package com.shoopi.routina.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.card.MaterialCardView
import com.shoopi.routina.R
import com.shoopi.routina.actions.utils.SetTextActionGenerator
import com.shoopi.routina.actions.web.OpenUrlAction
import com.shoopi.routina.actions.web.OpenUrlActionGenerator
import com.shoopi.routina.actionsholders.BasicActionHolder
import com.shoopi.routina.adapters.ColorListAdapter
import com.shoopi.routina.colors
import kotlinx.android.synthetic.main.activity_edit_icon.*

class EditIconActivity : AppCompatActivity() {


    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var colorListAdapter: ColorListAdapter
    private lateinit var actionHolder: BasicActionHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_icon)

        gridLayoutManager = GridLayoutManager(this, 5)

        color_list.layoutManager = gridLayoutManager
        colorListAdapter = ColorListAdapter(colors(), icon_view)
        color_list.adapter = colorListAdapter
        colorListAdapter.notifyDataSetChanged()

        actionHolder = BasicActionHolder(this)

        val materialCardView = findViewById<MaterialCardView>(R.id.icon_background)
        materialCardView.setOnClickListener {
            actionHolder.add(SetTextActionGenerator())
            materialCardView.setOnClickListener {
                actionHolder.add(OpenUrlActionGenerator(this))
                materialCardView.setOnClickListener {
                    actionHolder.execute()
                }
            }
        }

    }
}