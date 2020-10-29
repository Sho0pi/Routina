package com.shoopi.routina.actions.utils

import com.shoopi.routina.R
import com.shoopi.routina.actions.Action
import com.shoopi.routina.actions.ActionFactory

class TextActionFactory(private val text: String) : ActionFactory<String> {

    override val name: String
        get() = "Text"
    override val description: String
        get() = "Set the text"
    override val icon: Int
        get() = R.drawable.ic_text
    override val gradient: Int
        get() = R.drawable.gradient_yellow

    override fun create(from: Any?): Action<String> {
        return Action { text }
    }
}