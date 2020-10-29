package com.shoopi.routina.actions.utils

import com.shoopi.routina.R
import com.shoopi.routina.actions.Action
import com.shoopi.routina.actions.ActionFactory

class EmptyActionFactory : ActionFactory<Nothing?> {
    override val name: String
        get() = "Nothing"
    override val description: String
        get() = "Do Nothing!"
    override val icon: Int
        get() = R.drawable.ic_settings
    override val gradient: Int
        get() = R.drawable.gradient_gray

    override fun create(from: Any?): Action<Nothing?> {
        return Action { null }
    }
}