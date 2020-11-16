package com.shoopi.routina.actions

interface ActionGenerator<out T : Any> {
    val name: String
    val description: String
    val icon: Int
    val gradient: Int
    val isReceiver: Boolean
    val isSupplier: Boolean

    fun generate(from: Any): Action<T>

}