package com.shoopi.routina.actions.web

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import com.shoopi.routina.actions.Action

class OpenUrlAction(private val url: String, private val context: Context) : Action<Unit> {

    override fun execute() {
        Log.d(TAG, "opening url: $url")
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(url)
        }
        return context.startActivity(intent)
    }

    companion object {
        private const val TAG = "OpenUrlAction"
    }
}