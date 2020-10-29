package com.shoopi.routina.actions

interface ActionFactory<out T> {
    val name: String
    val description: String
    val icon: Int
    val gradient: Int

    fun create(from: Any?): Action<T>

}