package com.shoopi.routina.adapters

import android.app.ActivityOptions
import android.content.Intent
import android.content.res.ColorStateList
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.shoopi.routina.Color
import com.shoopi.routina.IntentConstants
import com.shoopi.routina.R
import com.shoopi.routina.Routine
import com.shoopi.routina.activities.EditIconActivity
import com.shoopi.routina.activities.EditRoutineActivity
import com.shoopi.routina.fragments.main.RoutinesFragment
import net.steamcrafted.materialiconlib.MaterialDrawableBuilder
import net.steamcrafted.materialiconlib.MaterialIconView

class RoutineListAdapter(private val routines: List<Routine>, private val parent: Fragment) :
    RecyclerView.Adapter<RoutineListAdapter.RoutineHolder>() {

    class RoutineHolder(private var view: View, private val parent: Fragment) :
        RecyclerView.ViewHolder(view),
        View.OnClickListener {

        private lateinit var routine: Routine
        private val routineName: TextView = view.findViewById(R.id.routine_name)
        private val routineDescription: TextView = view.findViewById(R.id.routine_description)
        private val routineIcon: MaterialIconView = view.findViewById(R.id.routine_icon)

        private val routineCard: MaterialCardView = view.findViewById(R.id.routine_card)

        init {
            routineCard.setOnClickListener(this)
            routineCard.setOnLongClickListener {
                routineCard.isChecked = !routineCard.isChecked
                true
            }
        }

        override fun onClick(v: View) {
            val intent = Intent(view.context, EditRoutineActivity::class.java).apply {
                putExtra(IntentConstants.EXTRA_ICON_OBJECT, routine.icon)
                putExtra(IntentConstants.EXTRA_COLOR_OBJECT, routine.color)
                putExtra(IntentConstants.EXTRA_ROUTINE_NAME_OBJECT, routine.name)
                putExtra(IntentConstants.EXTRA_ROUTINE_POSITION, adapterPosition)
            }
            parent.startActivityForResult(
                intent, RoutinesFragment.UPDATE_ICON,
                ActivityOptions.makeCustomAnimation(
                    parent.context,
                    android.R.anim.fade_in,
                    android.R.anim.fade_out
                ).toBundle()
            )
        }

        fun bind(routine: Routine) {
            this.routine = routine
            routineName.text = routine.name
            routineDescription.text = routine.description
            routineIcon.setIcon(routine.icon)

            setBackground(routine.color.background)
            setForeground(routine.color.foreground)
        }

        private fun setForeground(color: Int) {
            @ColorInt val colorInt = view.context.getColorFromAttr(color)
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
        return RoutineHolder(inflatedView, this.parent)
    }

    override fun onBindViewHolder(holder: RoutineHolder, position: Int) {
        holder.bind(routines[position])
    }

    fun onUpdate(
        position: Int,
        newColor: Color,
        newIconValue: MaterialDrawableBuilder.IconValue,
        newName: String
    ) {
        routines[position].color = newColor
        routines[position].icon = newIconValue
        routines[position].name = newName
        notifyItemChanged(position)
    }

    override fun getItemCount() = routines.size
}