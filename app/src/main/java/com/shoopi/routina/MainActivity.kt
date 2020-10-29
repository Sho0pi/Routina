package com.shoopi.routina

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.shoopi.routina.adapters.RoutineListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var adapter: RoutineListAdapter
    private var routines: List<Routine> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridLayoutManager = GridLayoutManager(this, 2)
        routineList.layoutManager = gridLayoutManager

        routines += Routine(
            "hello",
            "saying hello",
            R.drawable.ic_subject,
            R.drawable.gradient_yellow
        )
        routines += Routine(
            "hagar",
            "saying hello",
            R.drawable.ic_battery,
            R.drawable.gradient_turquoise
        )
        routines += Routine(
            "open android open it and then open it again and again and again and again.",
            "android",
            R.drawable.ic_android,
            R.drawable.gradient_green
        )
        routines += Routine(
            "web me",
            "This is a web action for you and your family, Hello my name is george.",
            R.drawable.ic_web,
            R.drawable.gradient_blue
        )

        adapter = RoutineListAdapter(routines)
        routineList.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}