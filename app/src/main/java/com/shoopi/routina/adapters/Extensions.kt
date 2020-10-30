package com.shoopi.routina.adapters

import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
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

@ColorInt
fun Context.getColorFromAttr(
    @AttrRes attrColor: Int,
    typedValue: TypedValue = TypedValue(),
    resolveRefs: Boolean = true
): Int {
    theme.resolveAttribute(attrColor, typedValue, resolveRefs)
    return typedValue.data
}