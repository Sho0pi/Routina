package com.shoopi.routina.actions

fun interface Action<out T> {
    fun execute(): T
}