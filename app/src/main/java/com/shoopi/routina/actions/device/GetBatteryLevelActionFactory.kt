package com.shoopi.routina.actions.device

import android.content.Context
import com.shoopi.routina.R
import com.shoopi.routina.actions.ActionFactory

class GetBatteryLevelActionFactory(private val context: Context) :
    ActionFactory<Int> {
    override fun create(from: Any?): GetBatteryLevelAction {
        return GetBatteryLevelAction(context)
    }

    override val name: String
        get() = "Get Battery Level"
    override val description: String
        get() = "Returns the battery level in the device"
    override val icon: Int
        get() = R.drawable.ic_battery
    override val gradient: Int
        get() = R.drawable.gradient_green
}