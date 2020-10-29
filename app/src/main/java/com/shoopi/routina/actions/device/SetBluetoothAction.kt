package com.shoopi.routina.actions.device

import android.bluetooth.BluetoothAdapter
import com.shoopi.routina.actions.Action

class SetBluetoothAction(private val toEnable: Boolean): Action<Boolean> {
    override fun execute(): Boolean {
        val bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        return if (toEnable){
            bluetoothAdapter.enable()
            true
        } else {
            bluetoothAdapter.disable()
            true
        }
    }
}