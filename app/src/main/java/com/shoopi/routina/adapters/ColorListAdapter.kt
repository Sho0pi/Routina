package com.shoopi.routina.adapters

import android.content.res.ColorStateList
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.shoopi.routina.Color
import com.shoopi.routina.R

class ColorListAdapter(private val colors: List<Color>, private val iconView: LinearLayout) :

    RecyclerView.Adapter<ColorListAdapter.ColorHolder>() {
    class ColorHolder(private var view: View, private val iconView: LinearLayout) :
        RecyclerView.ViewHolder(view),
        View.OnClickListener {

        private lateinit var color: Color

        private val colorView: MaterialCardView = view.findViewById(R.id.color_view)

        init {
            colorView.setOnClickListener(this)
        }

        fun bind(color: Color) {
            this.color = color
            check()
        }

        fun check() {
            colorView.backgroundTintList =
                ColorStateList.valueOf(view.context.getColorFromAttr(color.foreground))
        }

        fun uncheck() {
            colorView.backgroundTintList =
                ColorStateList.valueOf(view.context.getColorFromAttr(color.background))
        }

        private fun setColor(iconView: LinearLayout) {
            val iconBackground = iconView.findViewById<MaterialCardView>(R.id.icon_background)
            val icon = iconView.findViewById<ImageView>(R.id.icon)

            iconBackground.backgroundTintList =
                ColorStateList.valueOf(view.context.getColorFromAttr(color.background))

            icon.imageTintList =
                ColorStateList.valueOf(view.context.getColorFromAttr(color.foreground))
        }

        override fun onClick(v: View) {
            check()
            setColor(iconView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorHolder {
        val inflatedView = parent.inflate(R.layout.color_choose_item)
        return ColorHolder(inflatedView, iconView)
    }

    override fun onBindViewHolder(holder: ColorHolder, position: Int) {
        holder.bind(colors[position])
    }

    override fun getItemCount() = colors.size


}
