package com.shoopi.routina.actions.utils

import com.shoopi.routina.R
import com.shoopi.routina.actions.Action
import com.shoopi.routina.actions.ActionGenerator

class EmptyActionGenerator : ActionGenerator<Unit> {
    override val name: String
        get() = "Nothing"
    override val description: String
        get() = "Do Nothing!"
    override val icon: Int
        get() = R.drawable.ic_settings
    override val gradient: Int
        get() = R.drawable.gradient_gray
    override val isReceiver: Boolean
        get() = false
    override val isSupplier: Boolean
        get() = false

    override fun generate(from: Any): Action<Unit> {
        return Action { }
    }
}