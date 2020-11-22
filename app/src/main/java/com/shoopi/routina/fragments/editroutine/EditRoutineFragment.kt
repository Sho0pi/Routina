package com.shoopi.routina.fragments.editroutine

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textfield.TextInputEditText
import com.shoopi.routina.Color
import com.shoopi.routina.IntentConstants
import com.shoopi.routina.R
import com.shoopi.routina.activities.EditIconActivity
import com.shoopi.routina.adapters.getColorFromAttr
import com.shoopi.routina.fragments.main.RoutinesFragment
import net.steamcrafted.materialiconlib.MaterialDrawableBuilder
import net.steamcrafted.materialiconlib.MaterialIconView

class EditRoutineFragment : Fragment() {
    private var routineName: String = ""
    private var routineIcon: MaterialDrawableBuilder.IconValue =
        MaterialDrawableBuilder.IconValue.SETTINGS
    private var routineColor: Color = Color.GRAY

    private lateinit var routineColorView: MaterialCardView
    private lateinit var routineIconView: MaterialIconView
    private lateinit var routineNameView: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            routineName = it.getString(NAME_KEY, "")
            routineIcon = it.getSerializable(ICON_KEY) as MaterialDrawableBuilder.IconValue
            routineColor = it.getSerializable(COLOR_KEY) as Color
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_edit_routine, container, false)

        routineColorView = view.findViewById(R.id.icon_background)
        routineIconView = view.findViewById(R.id.icon)
        routineNameView = view.findViewById(R.id.routine_name_edit)

        routineNameView.setText(routineName)
        updateIcon(routineColor, routineIcon)

        routineColorView.setOnClickListener {
            val intent = Intent(context, EditIconActivity::class.java).apply {
                putExtra(IntentConstants.EXTRA_ICON_OBJECT, routineIcon)
                putExtra(IntentConstants.EXTRA_COLOR_OBJECT, routineColor)
            }
            startActivityForResult(
                intent, RoutinesFragment.UPDATE_ICON,
                ActivityOptions.makeCustomAnimation(
                    context,
                    android.R.anim.fade_in,
                    android.R.anim.fade_out
                ).toBundle()
            )
        }
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK) {
            return
        }
        if (requestCode == RoutinesFragment.UPDATE_ICON) {
            val extras = data?.extras
            if (extras != null) {
                val color = extras.getSerializable(IntentConstants.EXTRA_COLOR_OBJECT) as Color
                val icon =
                    extras.getSerializable(IntentConstants.EXTRA_ICON_OBJECT) as MaterialDrawableBuilder.IconValue

                updateIcon(color, icon)
            }
        }
    }

    private fun updateIcon(newColor: Color, newIcon: MaterialDrawableBuilder.IconValue) {
        routineColor = newColor
        routineIcon = newIcon
        routineColorView.backgroundTintList =
            ColorStateList.valueOf(this.context!!.getColorFromAttr(newColor.background))
        routineIconView.setColor(this.context!!.getColorFromAttr(newColor.foreground))
        routineIconView.setIcon(newIcon)
    }

    fun getRoutineColor(): Color = routineColor
    fun getRoutineIcon(): MaterialDrawableBuilder.IconValue = routineIcon
    fun getRoutineName(): String = routineNameView.text.toString()

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment EditRoutineFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(
            routineColor: Color,
            routineIcon: MaterialDrawableBuilder.IconValue,
            routineName: String
        ) =
            EditRoutineFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(COLOR_KEY, routineColor)
                    putSerializable(ICON_KEY, routineIcon)
                    putString(NAME_KEY, routineName)
                }
            }

        private const val COLOR_KEY = "color"
        private const val ICON_KEY = "icon"
        private const val NAME_KEY = "name"
    }
}