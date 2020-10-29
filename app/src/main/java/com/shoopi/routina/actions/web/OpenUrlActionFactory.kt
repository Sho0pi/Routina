package com.shoopi.routina.actions.web

import android.content.Context
import com.shoopi.routina.R
import com.shoopi.routina.actions.ActionFactory

class OpenUrlActionFactory(private val context: Context) : ActionFactory<Nothing?> {

    override val name: String
        get() = "Open Url"
    override val description: String
        get() = "Opens Url in you default browser"
    override val icon: Int
        get() = R.drawable.ic_web
    override val gradient: Int
        get() = R.drawable.gradient_blue

    override fun create(from: Any?): OpenUrlAction {
        when (from) {
            is String -> return OpenUrlAction(from, context)
            else -> throw Error()
        }
    }
}