package com.shoopi.routina.actions.utils

import android.content.Context
import android.widget.Toast
import com.shoopi.routina.actions.Action

class ShowToastAction(
    private val message: String,
    private val isLong: Boolean,
    private val context: Context
) : Action<Unit> {
    override fun execute() {
        val duration = if (isLong) {
            Toast.LENGTH_LONG
        } else {
            Toast.LENGTH_SHORT
        }
        return Toast.makeText(context, message, duration).show()
    }
}