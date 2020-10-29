package com.shoopi.routina.actions.device

import android.content.Context
import android.os.BatteryManager
import com.shoopi.routina.actions.Action

class GetBatteryLevelAction(private val context: Context) : Action<Int> {
    override fun execute(): Int {
        val batteryManager = context.getSystemService(BatteryManager::class.java)
        return batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
    }
}