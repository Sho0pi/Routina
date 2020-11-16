package com.shoopi.routina.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.shoopi.routina.R
import net.steamcrafted.materialiconlib.MaterialDrawableBuilder
import net.steamcrafted.materialiconlib.MaterialIconView

class IconListAdapter(
    private val icons: List<MaterialDrawableBuilder.IconValue>,
    private val iconView: LinearLayout
) :
    RecyclerView.Adapter<IconListAdapter.IconHolder>() {

    class IconHolder(view: View, private val iconView: LinearLayout) :
        RecyclerView.ViewHolder(view), View.OnClickListener {

        private val iconButton: MaterialCardView = view.findViewById(R.id.icon_button)
        private lateinit var iconValue: MaterialDrawableBuilder.IconValue

        init {
            iconButton.setOnClickListener(this)
        }

        fun bind(iconValue: MaterialDrawableBuilder.IconValue) {
            this.iconValue = iconValue
            iconButton.findViewById<MaterialIconView>(R.id.icon_button_img).setIcon(iconValue)
        }

        private fun setIcon(iconView: LinearLayout) {
            iconView.findViewById<MaterialIconView>(R.id.icon).setIcon(
                iconValue
            )
        }

        override fun onClick(v: View?) {
            setIcon(iconView)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IconHolder {
        val inflatedView = parent.inflate(R.layout.icon_choose_item)
        return IconHolder(inflatedView, iconView)
    }

    override fun onBindViewHolder(holder: IconHolder, position: Int) {
        holder.bind(icons[position])
    }

    override fun getItemCount() = icons.size

}