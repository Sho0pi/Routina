package com.shoopi.routina.adapters

import android.content.res.ColorStateList
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.shoopi.routina.R
import com.shoopi.routina.Routine
import net.steamcrafted.materialiconlib.MaterialIconView

class RoutineListAdapter(private val routines: List<Routine>) :
    RecyclerView.Adapter<RoutineListAdapter.RoutineHolder>() {

    class RoutineHolder(private var view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        private val routineName: TextView = view.findViewById(R.id.routine_name)
        private val routineDescription: TextView = view.findViewById(R.id.routine_description)
        private val routineIcon: MaterialIconView = view.findViewById(R.id.routine_icon)
        private val routineCardBackground: LinearLayout = view.findViewById(R.id.card_background)

        //        private val routineSettingsButton: MaterialButton =
//            view.findViewById(R.id.routine_settings_button)
        private val routineCard: MaterialCardView = view.findViewById(R.id.routine_card)

        init {
            routineCard.setOnClickListener(this)
            routineCard.setOnLongClickListener {
                routineCard.isChecked = !routineCard.isChecked
//                routineSettingsButton.visibility =
//                    if (routineCard.isChecked) MaterialButton.INVISIBLE else MaterialButton.VISIBLE
                true
            }
//            routineSettingsButton.setOnClickListener {
//                Toast.makeText(view.context, "settings", Toast.LENGTH_LONG).show()
//            }
        }

        override fun onClick(v: View) {
            Toast.makeText(v.context, "Clicked", Toast.LENGTH_LONG).show()
        }

        fun bind(routine: Routine) {
            routineName.text = routine.name
            routineDescription.text = routine.description
            routineIcon.setIcon(routine.icon)

            setBackground(routine.background)
            setForeground(routine.foreground)
        }

        private fun setForeground(color: Int) {
            @ColorInt val colorInt = view.context.getColorFromAttr(color)
//            routineSettingsButton.iconTint = ColorStateList.valueOf(colorInt)
            routineName.setTextColor(colorInt)
            routineDescription.setTextColor(colorInt)
            routineIcon.setColor(
                colorInt
            )
        }

        private fun setBackground(color: Int) {
            routineCard.backgroundTintList =
                ColorStateList.valueOf(view.context.getColorFromAttr(color))
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