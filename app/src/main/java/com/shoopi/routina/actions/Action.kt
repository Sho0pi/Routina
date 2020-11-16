package com.shoopi.routina.actions

fun interface Action<out T : Any> {
    fun execute(): T
}