package com.shoopi.routina.actions

import android.content.Context

interface EditableActionGenerator<out T : Any> : ActionGenerator<T> {

    fun edit(context: Context)
}