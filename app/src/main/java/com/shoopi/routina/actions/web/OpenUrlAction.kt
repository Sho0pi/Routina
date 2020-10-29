package com.shoopi.routina.actions.web

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.shoopi.routina.actions.Action

class OpenUrlAction(private val url: String, private val context: Context) : Action<Nothing?> {

    override fun execute(): Nothing? {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(url)
        }
        context.startActivity(intent)
        return null
    }
}