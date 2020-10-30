package com.shoopi.routina

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shoopi.routina.adapters.SlidePageAdapter
import com.shoopi.routina.fragments.AutomationFragment
import com.shoopi.routina.fragments.RoutinesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var pagerAdapter: SlidePageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragments = listOf(RoutinesFragment(), AutomationFragment())

        pagerAdapter = SlidePageAdapter(supportFragmentManager, fragments)
        pager.adapter = pagerAdapter

        bottom_nav.setupWithViewPager(pager)
    }
}