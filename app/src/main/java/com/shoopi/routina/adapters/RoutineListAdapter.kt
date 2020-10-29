package com.shoopi.routina.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.shoopi.routina.R
import com.shoopi.routina.Routine

class RoutineListAdapter(private val routines: List<Routine>) :
    RecyclerView.Adapter<RoutineListAdapter.RoutineHolder>() {

    class RoutineHolder(private var view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        private val routineName: TextView
        private val routineDescription: TextView
        private val routineIcon: ImageView
        private val routineCardBackground: LinearLayout
        private val routineSettingsButton: MaterialButton

        init {
            view.setOnClickListener(this)
            routineName = view.findViewById(R.id.routine_name)
            routineDescription = view.findViewById(R.id.routine_description)
            routineIcon = view.findViewById(R.id.routine_icon)
            routineCardBackground = view.findViewById(R.id.card_background)
            routineSettingsButton = view.findViewById(R.id.routine_settings_button)
        }

        override fun onClick(v: View) {
            Toast.makeText(v.context, "Clicked", Toast.LENGTH_LONG).show()
        }

        fun bind(routine: Routine) {
            routineName.text = routine.name
            routineDescription.text = routine.description
            routineIcon.setDrawable(routine.icon, view.context)
            routineCardBackground.setGradient(routine.gradient)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutineHolder {
        val inflatedView = parent.inflate(R.layout.routine_list_item)
        return RoutineHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: RoutineHolder, position: Int) {
        holder.bind(routines[position])
    }

    override fun getItemCount() = routines.size
}