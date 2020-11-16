package com.shoopi.routina.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView
import com.shoopi.routina.R
import com.shoopi.routina.actions.utils.ShowToastActionGenerator
import com.shoopi.routina.actionsholders.BasicActionHolder
import com.shoopi.routina.adapters.SlidePageAdapter
import com.shoopi.routina.fragments.editicon.ColorsFragment
import com.shoopi.routina.fragments.editicon.IconsFragment
import kotlinx.android.synthetic.main.activity_edit_icon.*

class EditIconActivity : AppCompatActivity() {


    private lateinit var pagerAdapter: SlidePageAdapter
    private lateinit var actionHolder: BasicActionHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_icon)

        val fragments = listOf(
            ColorsFragment().newInstance(icon_view),
            IconsFragment().newInstance(icon_view)
        )

        pagerAdapter = SlidePageAdapter(supportFragmentManager, fragments)
        pager.adapter = pagerAdapter
        bottom_nav.setupWithViewPager(pager)

        actionHolder = BasicActionHolder(this)

        val materialCardView = findViewById<MaterialCardView>(R.id.icon_background)
        materialCardView.setOnClickListener {
            actionHolder.add(ShowToastActionGenerator(this))
            materialCardView.setOnClickListener {
                actionHolder.execute()
            }
        }

    }
}