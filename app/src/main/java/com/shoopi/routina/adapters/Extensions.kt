package com.shoopi.routina.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.core.content.res.ResourcesCompat

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToBoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToBoot)
}

fun ImageView.setDrawable(@DrawableRes drawableRes: Int, context: Context) {
    this.setImageDrawable(
        ResourcesCompat.getDrawable(
            context.resources,
            drawableRes,
            context.theme
        )
    )
}

fun View.setGradient(@DrawableRes gradient: Int) {
    this.background = ResourcesCompat.getDrawable(this.resources, gradient, this.context.theme)
}
